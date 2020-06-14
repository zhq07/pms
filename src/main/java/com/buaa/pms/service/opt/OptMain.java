package com.buaa.pms.service.opt;

import com.buaa.pms.entity.*;
import com.buaa.pms.model.OptResult;
import com.buaa.pms.model.OptTaskNode;
import com.buaa.pms.model.ResOcpyNode;
import com.buaa.pms.model.Task;
import com.buaa.pms.service.*;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

@Service
public class OptMain {
    @Resource
    PmsTaskService pmsTaskService;
    @Resource
    PmsTaskLinkService pmsTaskLinkService;
    @Resource
    PmsProjectService pmsProjectService;
    @Resource
    PmsProcessService pmsProcessService;
    @Resource
    PmsTaskResPlanService pmsTaskResPlanService;
    @Resource
    PmsTaskResReqService pmsTaskResReqService;
    @Resource
    PmsHumanService pmsHumanService;
    @Resource
    PmsEquipmentService pmsEquipmentService;

    public static final int TASKLINKTYPE_NORMAL = 0;    // 任务连接类型，普通连接
    public static final int TASKLINKTYPE_REAL = 1;    // 任务连接类型，真连接
    public static final int IMPORTANCEVALUE_HIGHEST = 4;    // 任务最大重要性值
    public static final long MS_OF_HOUR = 1000 * 3600;      // 1小时的毫秒数
    public static final long MS_OF_DAY = 1000 * 3600 * 24;  // 1天的毫秒数

    public static final int maxG = 2;           // 最大迭代次数
    public static final int chromosomeNum = 5;  // 种群规模（个体数量）
    public static final double SF = 0.5;        // 变异操作时的缩放因子
    public static final double MR = 0.1;        // 变异操作时，后半段的变异概率
    public static final double CR = 0.8;        // 交叉操作时的交叉概率

    // 编码上每一位基因的取值范围
    int[] genValueLimit;

    // 待优化任务的总数量
    private int optTaskCountSum;

    // 虚拟首节点
    OptTaskNode startOptTaskNode;
    // 虚拟尾结点
    OptTaskNode endOptTaskNode;

    // 优化的时间起点，即所有项目的最早开始时间
    private Timestamp optOrigin;

    // 优化的时间终点，即所有项目的最晚完成时间
    private Timestamp optDestination;

    // 优化起点与终点时间相隔的天数
    private double optDays;

    // 所有参与优化的项目，key为项目UID，value为对应项目实例
    private Map<String, PmsProject> pmsProjectMap;
    
    // 所有参与优化的项目的最大步长，key为项目UID，value为对应项目的任务数量最大的路径上的任务个数
    private Map<String, Double> projMaxPathTaskCountMap;

    // 项目的无紧前任务的任务和无紧后任务的任务，key是项目UID，value是项目中没有紧前任务的任务节点和无紧后任务的任务两个list组成的数组
    // 两者分别是数组的第0个元素和第1个元素
    private Map<String, List<OptTaskNode>[]> projFirstLastTasksMap;

    // 所有参与优化的流程，key为流程UID，value为对应流程实例
    private Map<String, PmsProcess> pmsProcessMap;

    // 所有参与优化的任务，key为任务UID，value为对应OptTaskNode
    private Map<String, OptTaskNode> optTaskNodeMap;

    // 所有任务的资源方案，key为任务UID，value为该任务包含的资源方案
    private Map<String, List<PmsTaskResPlan>> taskResPlanMap;

    // 所有资源方案的资源需求，key为资源方案UID，value为该资源包含的资源需求
    private Map<String, List<PmsTaskResReq>> resPlanResReqMap;

    // 资源占用情况，key为资源UID，value为该资源被占用的时间段链表
    private Map<String, ResOcpyNode> resOcpyNodeMap;

    public OptTaskNode initTaskNodes(List<String> procUidList) {
        // 若待优化流程集合为空，则返回null
        if (procUidList == null || procUidList.isEmpty()) {
            return null;
        }

        // 优化的时间起点，即所有项目的最早开始时间
        optOrigin = new Timestamp(Long.MAX_VALUE);

        // 优化的时间终点，即所有项目的最晚完成时间
        optDestination = new Timestamp(Long.MIN_VALUE);

        // 优化起点与终点时间相隔的天数
        optDays = 0;

        // 所有参与优化的项目，key为项目UID，value为对应项目实例
        pmsProjectMap = new HashMap<>();

        // 所有参与优化的项目的最大步长，key为项目UID，value为对应项目的任务数量最大的路径上的任务个数
        projMaxPathTaskCountMap = new HashMap<>();

        // 项目的无紧前任务的任务和无紧后任务的任务，key是项目UID，value是项目中没有紧前任务的任务节点和无紧后任务的任务两个list组成的数组
        // 两者分别是数组的第0个元素和第1个元素
        projFirstLastTasksMap = new HashMap<>();

        // 所有参与优化的流程，key为流程UID，value为对应流程实例
        pmsProcessMap = new HashMap<>();

        // 所有参与优化的任务，key为任务UID，value为对应OptTaskNode
        optTaskNodeMap = new HashMap<>();

        // 所有任务的资源方案，key为任务UID，value为该任务包含的资源方案
        taskResPlanMap = new HashMap<>();

        // 所有资源方案的资源需求，key为资源方案UID，value为该资源包含的资源需求
        resPlanResReqMap = new HashMap<>();

        // 资源占用情况，key为资源UID，value为该资源被占用的时间段链表
        resOcpyNodeMap = new HashMap<>();

        startOptTaskNode = new OptTaskNode();  // 虚拟首节点
        endOptTaskNode = new OptTaskNode();    // 虚拟尾结点

        List<String> projUidList = new ArrayList<>();   // 待优化项目UID集合
        // 获取全部待优化流程
        for (PmsProcess pmsProcess : pmsProcessService.selectByUidList(procUidList)) {
            pmsProcessMap.put(pmsProcess.getProcUid(), pmsProcess);
            projUidList.add(pmsProcess.getProcProjUid());
        }
        // 获取全部待优化项目，并得到优化起点和终点时间
        for (PmsProject pmsProject : pmsProjectService.selectByUidList(projUidList)) {
            pmsProjectMap.put(pmsProject.getProjUid(), pmsProject);
            Timestamp projEarly = pmsProject.getProjEarlyStartDateTime();
            Timestamp projLate = pmsProject.getProjLateFinishDateTime();
            // 优化起点为各项目最早的最早开始时间，终点为最晚的最晚结束时间
            if (optOrigin != null && projEarly != null && projEarly.before(optOrigin)) {
                optOrigin.setTime(projEarly.getTime());
            }
            if (optDestination != null && projLate != null && projLate.after(optDestination)) {
                optDestination.setTime(projLate.getTime());
            }
        }
        // 得到优化起点与终点时间相隔的天数
        optDays = (optDestination.getTime() - optOrigin.getTime()) / (MS_OF_DAY);
        // 获取全部待优化任务，实例化任务链表的节点OptTaskNode
        for (PmsTask pmsTask : pmsTaskService.selectByProcUidList(procUidList)) {
            optTaskNodeMap.put(pmsTask.getTaskUid(), new OptTaskNode(pmsTask));
        }
        optTaskCountSum = optTaskNodeMap.size();    // 待优化任务总数
        // 获取全部待优化任务的资源方案，初始化“任务-资源方案”taskResPlanMap
        for (PmsTaskResPlan pmsTaskResPlan : pmsTaskResPlanService.selectByProcUidList(procUidList)) {
            String pmsTaskUid = pmsTaskResPlan.getResPlanTaskUid();
            if (!taskResPlanMap.containsKey(pmsTaskUid)) {
                taskResPlanMap.put(pmsTaskUid, new LinkedList<PmsTaskResPlan>());
            }
            taskResPlanMap.get(pmsTaskUid).add(pmsTaskResPlan);
        }
        // 获取资源方案的资源需求，初始化“资源方案-资源需求”resPlanResReqMap
        for (PmsTaskResReq pmsTaskResReq : pmsTaskResReqService.selectByProcUidList(procUidList)) {
            String resPlanUid = pmsTaskResReq.getResReqResPlanUid();
            if (!resPlanResReqMap.containsKey(resPlanUid)) {
                resPlanResReqMap.put(resPlanUid, new LinkedList<PmsTaskResReq>());
            }
            resPlanResReqMap.get(resPlanUid).add(pmsTaskResReq);
        }
        // 获取全部任务连接，并赋予任务节点optTaskNode中的普通连接和真连接集合，使待优化任务节点连接起来
        for (PmsTaskLink pmsTaskLink : pmsTaskLinkService.selectByProcUidList(procUidList)) {
            OptTaskNode preTaskNode = optTaskNodeMap.get(pmsTaskLink.getTaskLinkPreTaskUid());  // 连接中的前任务
            OptTaskNode sucTaskNode = optTaskNodeMap.get(pmsTaskLink.getTaskLinkSucTaskUid());  // 连接中的后任务
            if (pmsTaskLink.getTaskLinkType() == TASKLINKTYPE_NORMAL) {         // 若为普通连接
                preTaskNode.getNormalSucTasks().add(sucTaskNode);
                sucTaskNode.getNormalPreTasks().add(preTaskNode);
            } else {                                                            // 若为真连接
                preTaskNode.getRealSucTasks().add(sucTaskNode);
                sucTaskNode.getRealPreTasks().add(preTaskNode);
            }
        }
        // 确定任务节点的实际紧前任务和紧后任务集合，确定紧前紧后任务数量和当前紧前任务数量，将虚拟首节点和尾结点加入任务连接图中
        // 确定任务的互斥任务集合，此处任务关系指，两个任务没有前后关系但又不能同时进行
        // 赋值任务节点中的资源方案和资源需求集合resPlanReqPairList
        for (OptTaskNode optTaskNode : optTaskNodeMap.values()) {
            // 实际紧前任务
            optTaskNode.setPreTasks(optTaskNode.getRealPreTasks().isEmpty() ? optTaskNode.getNormalPreTasks() : optTaskNode.getRealPreTasks());
            int preTaskCount = optTaskNode.getPreTasks().size();    // 紧前任务数量
            optTaskNode.setPreTaskCount(preTaskCount);
            optTaskNode.setCurPreTaskCount(preTaskCount);
            if (preTaskCount == 0) {
                startOptTaskNode.getSucTasks().add(optTaskNode);
            }
            // 实际紧后任务
            // 暂存实际紧后任务
            List<OptTaskNode> sucTasks = new ArrayList<>(optTaskNode.getRealSucTasks());     // 真紧后任务一定是实际紧后任务
            for (OptTaskNode normalSucTask : optTaskNode.getNormalSucTasks()) {
                if (normalSucTask.getRealPreTasks().size() == 0)    // 普通紧后任务中，没有设置真紧前任务的任务，也是实际紧后任务
                    sucTasks.add(normalSucTask);
            }
            optTaskNode.setSucTasks(sucTasks);
            int sucTaskCount = optTaskNode.getSucTasks().size();    // 紧后任务数量
            optTaskNode.setSucTaskCount(sucTaskCount);
            optTaskNode.setCurSucTaskCount(sucTaskCount);
            if (sucTaskCount == 0) {
                endOptTaskNode.getPreTasks().add(optTaskNode);
            }
            // 确定任务的互斥任务集合mutexTasks
            if (!optTaskNode.getRealPreTasks().isEmpty()) {         // 如果任务有真紧前任务
                Set<OptTaskNode> mutexTasks = new HashSet<>();
                // 将真紧前任务与该任务之间的任务加入互斥任务集合
                for (OptTaskNode realPreTask : optTaskNode.getRealPreTasks()) {
                    for (OptTaskNode curTask : realPreTask.getNormalSucTasks()) {
//                    OptTaskNode curTask = realPreTask.getNormalSucTasks().get(0);
                        while (curTask != optTaskNode && !curTask.getNormalSucTasks().isEmpty()) {
                            mutexTasks.add(curTask);
                            curTask = curTask.getNormalSucTasks().get(0);
                        }
                    }
                }
                if (!mutexTasks.isEmpty()) {
                    for (OptTaskNode mutexTask : mutexTasks) {
                        optTaskNode.getMutexTasks().add(mutexTask);
                        mutexTask.getMutexTasks().add(optTaskNode);
                    }
                }
            }
            // 任务的资源方案和资源需求集合resPlanReqPairList
            List<PmsTaskResPlan> pmsTaskResPlans = taskResPlanMap.get(optTaskNode.getPmsTask().getTaskUid());
            if (pmsTaskResPlans != null && !pmsTaskResPlans.isEmpty()) {
                for (PmsTaskResPlan pmsTaskResPlan : pmsTaskResPlans) {
                    Pair<String, List<PmsTaskResReq>> pair = new Pair<>(pmsTaskResPlan.getResPlanUid(), resPlanResReqMap.get(pmsTaskResPlan.getResPlanUid()));
                    optTaskNode.getResPlanReqPairList().add(pair);
                }
                optTaskNode.setResPlanCount(pmsTaskResPlans.size());    // 该任务的资源方案个数
            }
        }
        // 确定任务的
        // 后续任务数量（包括自身）最多的路径上的任务个数sucTaskCountSum;
        // 后续任务工期和（包括自身）最大的路径上的任务工期和sucTaskDurSum;
        // 任务最晚完成时间与优化起点日期相差的天数lateFinish;
        // 任务重要性importance
        // 以及优先级评价函数中相应规则项的值
        // 倒序广度优先遍历
        Queue<OptTaskNode> traversalQueue = new LinkedList<>(endOptTaskNode.getPreTasks());
        while (!traversalQueue.isEmpty()) {
            OptTaskNode optTaskNode = traversalQueue.poll();
            for (OptTaskNode preTask : optTaskNode.getPreTasks()) {
                preTask.setCurSucTaskCount(preTask.getCurSucTaskCount() - 1);
                // 紧前任务入队
                if (preTask.getCurSucTaskCount() == 0) {
                    traversalQueue.add(preTask);
                    preTask.setCurSucTaskCount(preTask.getCurSucTaskCount());
                }
            }
            // 以当前任务为起点到该任务所在项目终点的路径中：
            // 最大的任务数量sucTaskCountSum
            // 最长的任务工期和sucTaskDurSum
            double sucTaskCountSum = 0;
            double sucTaskDurSum = 0;
            for (OptTaskNode sucTask : optTaskNode.getSucTasks()) {
                sucTaskCountSum = Math.max(sucTaskCountSum, sucTask.getSucTaskCountSum());
                sucTaskDurSum = Math.max(sucTaskDurSum, sucTask.getSucTaskDurSum());
            }
            optTaskNode.setSucTaskCountSum(sucTaskCountSum + 1);   // 加上自身的数量1
            optTaskNode.setSucTaskDurSum(sucTaskDurSum + optTaskNode.getPmsTask().getTaskPlanDur()); // 加上自身工期
            // 任务最晚完成时间与优化起点日期相差的天数lateFinish
            optTaskNode.setLateFinish((optTaskNode.getPmsTask().getTaskLateFinishDateTime().getTime() - optOrigin.getTime()) / (MS_OF_DAY));
            // 任务重要性importance
            optTaskNode.setImportance(optTaskNode.getPmsTask().getTaskPriority());
        }
        // 设定每个项目原本没有紧前任务的任务的最早开始时间，若已设定，则保留；若未设定，则设为项目最早开始时间
        for (OptTaskNode firstOptTaskNode : startOptTaskNode.getSucTasks()) {
            PmsTask pmsTask = firstOptTaskNode.getPmsTask();
            if (pmsTask.getTaskEarlyStartDateTime() == null) {
                pmsTask.setTaskEarlyStartDateTime(pmsProjectMap.get(pmsTask.getTaskProjUid()).getProjEarlyStartDateTime());
            }
            // 初始化projMaxPathTaskCountMap，项目的最大步长，key为项目UID，value为对应项目的任务数量最大的路径上的任务个数
            if (!projMaxPathTaskCountMap.containsKey(pmsTask.getTaskProjUid())) {
                projMaxPathTaskCountMap.put(pmsTask.getTaskProjUid(), firstOptTaskNode.getSucTaskCountSum());
            } else  {
                projMaxPathTaskCountMap.put(pmsTask.getTaskProjUid(), Math.max(projMaxPathTaskCountMap.get(pmsTask.getTaskProjUid()), firstOptTaskNode.getSucTaskCountSum()));
            }
            // 初始化projFirstLastTasksMap，key是项目UID，value是项目中没有紧前任务的任务节点和无紧后任务的任务两个list组成的数组
            if (!projFirstLastTasksMap.containsKey(pmsTask.getTaskProjUid())) {
                projFirstLastTasksMap.put(pmsTask.getTaskProjUid(), new ArrayList[]{ new ArrayList<>(), new ArrayList<>() });
            }
            projFirstLastTasksMap.get(pmsTask.getTaskProjUid())[0].add(firstOptTaskNode);
        }
        // 赋值任务节点中的项目最大步长，即项目包含最多任务数量的路径中的任务数量maxProjPathTaskCount
        // 计算任务优先级评价函数中各规则项的值
        // 为每个任务指定其资源方案编号在编码中的位置下标resPlanIndex
        // 正序广度优先遍历每个项目
        genValueLimit = new int[optTaskCountSum + 4];
        for (int i = 0; i < 4; i++) {
            genValueLimit[i] = 1;       // 前半段基因取值的上限为1
        }
        int resPlanGenIndex = 4;    // 后半段表示资源方案，从下标4开始
        for (List<OptTaskNode>[] firstLastOptTaskNodes : projFirstLastTasksMap.values()) {
            List<OptTaskNode> firstOptTaskNodes = firstLastOptTaskNodes[0];
            double maxProjPathTaskCount = projMaxPathTaskCountMap.get(firstOptTaskNodes.get(0).getPmsTask().getTaskProjUid());
            // 正序广度优先遍历一个项目
            Queue<OptTaskNode> queue = new LinkedList<>(firstOptTaskNodes);
            while (!queue.isEmpty()) {
                OptTaskNode optTaskNode = queue.poll();
                for (OptTaskNode sucTask : optTaskNode.getSucTasks()) {
                    sucTask.setCurPreTaskCount(sucTask.getCurPreTaskCount() - 1);
                    // 紧后任务入队
                    if (sucTask.getCurPreTaskCount() == 0) {
                        queue.add(sucTask);
                        sucTask.setCurPreTaskCount(sucTask.getPreTaskCount());
                    }
                }
                // 指定在编码中的位置下标
                optTaskNode.setResPlanGenIndex(resPlanGenIndex);
                genValueLimit[resPlanGenIndex++] = optTaskNode.getResPlanReqPairList().size();    // 后半段基因取值的上限为资源方案的个数
                // 赋值任务节点中的maxProjPathTaskCount
                optTaskNode.setMaxProjPathTaskCount(maxProjPathTaskCount);
                
                // 计算任务优先级评价函数中各规则项的值
                // 后续任务数量规则项的值
                optTaskNode.setSucTaskCountSumValue(optTaskNode.getSucTaskCountSum() / maxProjPathTaskCount);
                // 后续任务工期和规则项的值
                double projPlanDur = pmsProjectMap.get(optTaskNode.getPmsTask().getTaskProjUid()).getProjPlanDur();
                optTaskNode.setSucTaskDurSumValue(optTaskNode.getSucTaskDurSum() / projPlanDur);
                // 任务最晚完成时间规则项的值
                optTaskNode.setLateFinishValue(1 - optTaskNode.getLateFinish() / optDays);
                // 任务重要性规则项的值
                optTaskNode.setImportanceValue(optTaskNode.getImportance() / IMPORTANCEVALUE_HIGHEST);

                // 将projFirstLastTasksMap补充完整，补充每个项目的无紧后任务的任务
                if (optTaskNode.getSucTaskCount() == 0) {
                    projFirstLastTasksMap.get(optTaskNode.getPmsTask().getTaskProjUid())[1].add(optTaskNode);
                }
            }
        }

        return startOptTaskNode;
    }

    /**
     * 流程优化主体
     * @param procUidList
     * @return
     */
    public List<PmsTask> optimize(List<String> procUidList) {
//        List<String> procUidList = new ArrayList<>();
//        procUidList.add("707224909687816192");
//        procUidList.add("707323834117652480");
        initTaskNodes(procUidList);  // 初始化任务节点图，获得任务节点网络的虚拟首节点

        int maxG = 50;                       // 最大迭代次数
        int G = 0;                          // 种群的代数
        int chromosomeNum = 30;              // 种群中的个体（染色体）个数
        int genNum = optTaskCountSum + 4;   // 一个染色体上的基因个数，即编码长度
        double[][] population = new double[chromosomeNum][genNum];  // 种群存在数组中
        double[] populationFitness = new double[chromosomeNum];     // 记录种群中个体的适应度值
        // 初始化种群
        Random random = new Random();
        for (int i = 0; i < chromosomeNum; i++) {
            for (int j = 0; j < 4; j++) {
                population[i][j] = random.nextDouble();
            }
            for (int j = 4; j < genNum; j++) {
                if (genValueLimit[j] == 0)
                    population[i][j] = -1;  // 若任务没有资源方案，则对应基因置为-1
                else
                    population[i][j] = random.nextInt(genValueLimit[j]);    // 取值范围0~资源方案个数n，包括0，不包括n
            }
        }
        // 计算初始种群中个体的适应度函数，初始化populationFitness
        System.out.println("**********************适应度*********************");
        System.out.println("第" + G + "代");
        for (int i = 0; i < chromosomeNum; i++) {
            populationFitness[i] = fitness(G, decode(population[i]));
            System.out.print(populationFitness[i] + "\t");
        }
        System.out.println();
        // 开始迭代进化
        while (++G <= maxG) {
            System.out.println("第" + G + "代");
            // 逐个遍历种群的个体，对第i个个体进行“变异->交叉->选择”操作，得到下一代种群的第i个个体
            // 先进行变异、交叉，得到每个个体对应的交叉个体
            double[][] populationCrossover = new double[chromosomeNum][genNum]; // 暂存交叉个体
            // 遍历种群，得到交叉个体
            for (int i = 0; i < chromosomeNum; i++) {
                double[] target = population[i];                            // 目标个体
                double[] mutation = mutate(i, population, genValueLimit);   // 得到变异个体（返回的是new double[]）
                double[] crossover = cross(target, mutation);               // 得到交叉个体（返回的是改变数值后的mutation）
                populationCrossover[i] = crossover;                         // 暂存交叉个体，以免population数组中的数据变化影响其他个体的变异交叉
            }
            // 选择操作，比较个体与其对应的交叉个体的适应度值，选择适应度值小（综合工期+罚函数值小）的个体进入下一代
            for (int i = 0; i < chromosomeNum; i++) {
                // 如果交叉个体的适应度值小于原个体，则选择交叉个体进入种群的下一代，否则，保持原个体进入下一代
                double targetFitness = fitness(G, decode(population[i]));               // 由于G增大了，所以要重新计算目标个体的适应度值
                double crossoverFitness = fitness(G, decode(populationCrossover[i]));   // 交叉个体的适应度值
                if(crossoverFitness < targetFitness) {
                    population[i] = populationCrossover[i];
                    populationFitness[i] = crossoverFitness;        // 更新种群中第i个个体的适应度值
                } else {
                    populationFitness[i] = targetFitness;
                }
            }
            // 打印新一代适应度值
            for (int i = 0; i < chromosomeNum; i++) {
                populationFitness[i] = fitness(G, decode(population[i]));
                System.out.print(populationFitness[i] + "\t");
            }
            System.out.println();
        }
        // 找出优化后，种群中的最佳个体
        double[] bestIndividual  = population[0];
        double bestFitness = populationFitness[0];
        for (int i = 0; i < chromosomeNum; i++) {
            if (bestFitness > populationFitness[i]) {
                bestFitness = populationFitness[i];
                bestIndividual = population[i];
            }
        }
        // 最佳个体解码，重置任务优先级、资源占用表
        decode(bestIndividual);
        // 正序广度优先遍历，打印优化结果
        List<PmsTask> result = new LinkedList<>();
        Queue<OptTaskNode> priQueue = new PriorityQueue<>(cmpOptTaskNode);  // 任务优先队列，按任务优先级评价的升序排列
        priQueue.addAll(startOptTaskNode.getSucTasks());
        while (!priQueue.isEmpty()) {
            OptTaskNode optTaskNode = priQueue.poll();
            for (OptTaskNode sucTask : optTaskNode.getSucTasks()) {
                sucTask.setCurPreTaskCount(sucTask.getCurPreTaskCount() - 1);
                // 可执行的紧后任务入队
                if (sucTask.getCurPreTaskCount() == 0) {
                    sucTask.setCurPreTaskCount(sucTask.getPreTaskCount());  // 恢复当前紧前任务值，以便下次遍历时使用
                    priQueue.add(sucTask);
                }
            }
            PmsTask pmsTask = optTaskNode.getPmsTask();
            result.add(pmsTask);
            System.out.println("**************");
            System.out.println(optTaskNode.getPriorityValue());
            System.out.println(pmsTask.getTaskName());
            System.out.println(pmsTask.getTaskPlanStartDateTime());
            System.out.println(pmsTask.getTaskPlanFinishDateTime());
        }
        return result;
    }

    /**
     * 解码，得到个体对应的计划中，每个项目的开始、结束时间，存入projStartFinishTimeMap并返回
     * @param chromosome
     * @return
     */
    public Map<String, Timestamp[]> decode(double[] chromosome) {
        Map<String, Timestamp[]> projStartFinishTimeMap = new HashMap<>();
        Map<String, OptTaskNode> readyTaskMap = new HashMap<>();        // 存储已被安排时间的任务节点，key为任务UID
        resOcpyNodeMap = new HashMap<>();
//        resOcpyNodeMap.clear();     // 还原资源占用情况resOcpyNodeMap
        Calendar calendar = Calendar.getInstance();
        // 正序广度优先遍历，解码，求个体的工期Dur和完成时间Finish
        Queue<OptTaskNode> priQueue = new PriorityQueue<>(cmpOptTaskNode);  // 任务优先队列，按任务优先级评价的升序排列
        // 求原任务节点图中，没有紧前任务的任务节点的优先级评价值
        for (OptTaskNode optTaskNode : startOptTaskNode.getSucTasks()) {
            // 计算个体的优先级评价值
            optTaskNode.setPriorityValue(priorityValue(optTaskNode, chromosome));
        }
        priQueue.addAll(startOptTaskNode.getSucTasks());
        while (!priQueue.isEmpty()) {
            OptTaskNode optTaskNode = priQueue.poll();
            for (OptTaskNode sucTask : optTaskNode.getSucTasks()) {
                sucTask.setCurPreTaskCount(sucTask.getCurPreTaskCount() - 1);
                // 可执行的紧后任务入队
                if (sucTask.getCurPreTaskCount() == 0) {
                    sucTask.setPriorityValue(priorityValue(sucTask, chromosome));   // 入队前要计算优先级评价值
                    sucTask.setCurPreTaskCount(sucTask.getPreTaskCount());  // 恢复当前紧前任务值，以便下次遍历时使用
                    priQueue.add(sucTask);
                }
            }
            // 安排任务开始、结束时间
            PmsTask pmsTask = optTaskNode.getPmsTask();     // 获取任务实例
            // 确定安排任务开始时间的搜索起点，即任务最早开始时间及其紧前任务的计划完成时间中，最晚的时间
            Timestamp taskStart = new Timestamp(0);
            Timestamp taskFinish = new Timestamp(0);
            if (pmsTask.getTaskEarlyStartDateTime() != null) {
                taskStart.setTime(pmsTask.getTaskEarlyStartDateTime().getTime());
            }
            for (OptTaskNode preTask : optTaskNode.getPreTasks()) {
                if (preTask.getPmsTask().getTaskPlanFinishDateTime().after(taskStart))
                    taskStart.setTime(preTask.getPmsTask().getTaskPlanFinishDateTime().getTime());
            }
            taskFinish.setTime(endTime(taskStart, pmsTask.getTaskPlanDur(), pmsTask.getTaskWorkModel()).getTime());  // 当前任务开始时间对应的结束时间
            // 考虑互斥任务
            for (OptTaskNode mutexTaskNode : optTaskNode.getMutexTasks()) {
                PmsTask mutexTask = mutexTaskNode.getPmsTask();
                if (readyTaskMap.containsKey(mutexTask.getTaskUid())) {
                    // 若初始搜索时间段与该任务的已经安排的互斥任务有重合，则将开始时间向后推到互斥任务的结束时间，以避开重合
                    if (!taskStart.before(mutexTask.getTaskPlanStartDateTime()) && taskStart.before(mutexTask.getTaskPlanFinishDateTime())
                            || taskFinish.after(mutexTask.getTaskPlanStartDateTime()) && !taskFinish.after(mutexTask.getTaskPlanFinishDateTime())) {
                        taskStart.setTime(mutexTask.getTaskPlanFinishDateTime().getTime());
                        taskFinish.setTime(endTime(taskStart, pmsTask.getTaskPlanDur(), pmsTask.getTaskWorkModel()).getTime());
//                        System.out.println("互斥：" + mutexTask.getTaskName() + "--" + pmsTask.getTaskName());
                    }
                }
            }
            // 初始化任务计划开始、结束时间
            pmsTask.setTaskPlanStartDateTime(taskStart);
            pmsTask.setTaskPlanFinishDateTime(taskFinish);
            int resPlanIndex = (int)chromosome[optTaskNode.getResPlanGenIndex()];   // 个体选定的该任务的资源方案在任务资源方案list中的下标
            if (resPlanIndex == -1) {   // 如果没有资源方案，则不考虑资源
//                System.out.println("**************");
//                System.out.println(pmsTask.getTaskName());
//                System.out.println("优先级" + optTaskNode.getPriorityValue());
//                System.out.println(optTaskNode.getSucTaskCountSum() + "\t" + "\t" + optTaskNode.getSucTaskDurSum() + "\t" + "\t"
//                        + optTaskNode.getLateFinish() + "\t" + "\t" + optTaskNode.getImportance());
//                System.out.println(optTaskNode.getSucTaskCountSumValue() + "\t" + "\t" + optTaskNode.getSucTaskDurSumValue() + "\t" + "\t"
//                        + optTaskNode.getLateFinishValue() + "\t" + "\t" + optTaskNode.getImportanceValue());
//                System.out.println(pmsTask.getTaskPlanStartDateTime());
//                System.out.println(pmsTask.getTaskPlanFinishDateTime());
                readyTaskMap.put(pmsTask.getTaskUid(), optTaskNode);    // 加入已安排任务集合
                continue;
            }
            List<PmsTaskResReq> resReqs = optTaskNode.getResPlanReqPairList().get(resPlanIndex).getValue();    // 个体编码中的任务资源方案中的资源需求
            // 根据资源需求和资源占用情况搜索任务可行的最早开始时间，工作时间为8点到18点
            double dur = pmsTask.getTaskPlanDur();  // 任务预计工期
            List<ResOcpyNode> newResNodes = new LinkedList<>(); // 暂存新的资源占用节点
            boolean resAllocate = false;
            while (!resAllocate) {
                resAllocate = true;
                // 考虑互斥任务
                for (OptTaskNode mutexTaskNode : optTaskNode.getMutexTasks()) {
                    PmsTask mutexTask = mutexTaskNode.getPmsTask();
                    if (readyTaskMap.containsKey(mutexTask.getTaskUid())) {
                        // 若初始搜索时间段与该任务的已经安排的互斥任务有重合，则将开始时间向后推到互斥任务的结束时间，以避开重合
                        if (!taskStart.before(mutexTask.getTaskPlanStartDateTime()) && taskStart.before(mutexTask.getTaskPlanFinishDateTime())
                                || taskFinish.after(mutexTask.getTaskPlanStartDateTime()) && !taskFinish.after(mutexTask.getTaskPlanFinishDateTime())) {
                            taskStart.setTime(mutexTask.getTaskPlanFinishDateTime().getTime());
                            taskFinish.setTime(endTime(taskStart, pmsTask.getTaskPlanDur(), pmsTask.getTaskWorkModel()).getTime());
                        }
                    }
                }
                newResNodes.clear();    // 新一轮尝试安排任务时间之前，清空上轮产生的资源占用节点
                taskFinish.setTime(endTime(taskStart, dur, pmsTask.getTaskWorkModel()).getTime());  // 当前任务开始时间对应的结束时间
                for (PmsTaskResReq resReq : resReqs) {
                    String resUid = resReq.getResReqResUid();
                    if (resOcpyNodeMap.containsKey(resUid)) {   // 如果资源占用map包含了表示该资源情况的链表
                        ResOcpyNode newResNode = new ResOcpyNode(resReq);   // 任务资源需求产生的新的资源占用
                        ResOcpyNode resOcpyNode = resOcpyNodeMap.get(resUid);
                        ResOcpyNode preNode = resOcpyNode.preOcpy;  // 指向当前节点的前节点
                        if (resOcpyNode.getResAmount() == null || resOcpyNode.getResAmount() == 0) {       // 如果没有资源数量要求，即该资源为独占资源（人力/设备）
                            // 找到第一个占用结束时间不在任务开始时间之前的资源占用节点
                            while (resOcpyNode != null && !resOcpyNode.getResFinishDateTime().after(taskStart)) {
                                preNode = resOcpyNode;
                                resOcpyNode = resOcpyNode.sucOcpy;
                            }
                            if (resOcpyNode == null) {      // 如果所有已占用都在任务开始之前，则资源从任务开始时占用
                                newResNode.setResStartDateTime(taskStart);
                                newResNode.setResFinishDateTime(endTime(taskStart, resReq.getResReqResWork(), resReq.getResReqResWorkModel()));
                                newResNode.preOcpy = preNode;   // 暂时单向连上，挂在链表上，以便之后定位，搜索完毕后再将新节点嵌入链表中
                                newResNodes.add(newResNode);
                            } else {
                                // 判断资源需求能否得到满足，即在任务期内，资源有一整段的空闲，且这段空闲能够满足资源需求
                                while (preNode != null) {
                                    Timestamp resStartTime = preNode.getResFinishDateTime();    // 空闲时间段的前边界
                                    Timestamp resEndTime = endTime(resStartTime, resReq.getResReqResWork(), resReq.getResReqResWorkModel());
                                    Timestamp postTime = null;      // 空闲时间段的后边界
                                    if (resOcpyNode != null) {        // 如果没有超出链表末端，则为时间后边界赋值，否则postTime为空，即没有后边界
                                        postTime = resOcpyNode.getResStartDateTime();
                                    }
                                    // 如果搜索的资源占用结束时间超出了任务结束时间，则该任务时间不可行，任务开始时间后移到下一个整点
                                    if (resEndTime.after(taskFinish)) {
                                        resAllocate = false;
                                        calendar.setTime(taskStart);
                                        if (calendar.get(Calendar.HOUR_OF_DAY) == 18) {
                                            taskStart.setTime(taskStart.getTime() + 14 * MS_OF_HOUR);
                                        } else {
                                            taskStart.setTime(taskStart.getTime() + MS_OF_HOUR);
                                        }
                                        break;
                                    }
                                    // 如果找到了满足资源需求的时间段
                                    if (!resStartTime.before(taskStart) && (postTime == null || !resEndTime.after(postTime))) {
                                        newResNode.setResStartDateTime(preNode.getResFinishDateTime());
                                        newResNode.setResFinishDateTime(endTime(preNode.getResFinishDateTime(), resReq.getResReqResWork(), resReq.getResReqResWorkModel()));
                                        newResNode.preOcpy = preNode;   // 暂时单向连上，挂在链表上，以便之后定位，搜索完毕后再将新节点嵌入链表中
                                        newResNodes.add(newResNode);
                                        break;
                                    }
                                    preNode = resOcpyNode;
                                    resOcpyNode = resOcpyNode == null ? null : resOcpyNode.sucOcpy;
                                }
                            }
                        }
                    } else {
                        // 构造一个虚拟首节点，方便构造和遍历链表
                        ResOcpyNode preNode = new ResOcpyNode();
                        preNode.setResStartDateTime(new Timestamp(0));
                        preNode.setResFinishDateTime(new Timestamp(0));
                        resOcpyNodeMap.put(resUid, preNode);
                        // 将当前资源安排加入资源占用链表
                        ResOcpyNode resOcpyNode = new ResOcpyNode(resReq);
                        resOcpyNode.setResStartDateTime(taskStart);
                        resOcpyNode.setResFinishDateTime(endTime(taskStart, resReq.getResReqResWork(), resReq.getResReqResWorkModel()));
                        preNode.sucOcpy = resOcpyNode;
                        resOcpyNode.preOcpy = preNode;

                    }
                    if (!resAllocate) {
                        break;
                    }
                }
            }
            // 设定任务计划开始、结束时间
            pmsTask.setTaskPlanStartDateTime(taskStart);
            pmsTask.setTaskPlanFinishDateTime(taskFinish);
            // 将排好的资源占用时间加入资源占用链表中
            for (ResOcpyNode newResNode : newResNodes) {
                ResOcpyNode preNode = newResNode.preOcpy;
                ResOcpyNode sucNode = preNode.sucOcpy;
                preNode.sucOcpy = newResNode;
//                newResNode.preOcpy = preNode; // 之前已赋值
                if (sucNode != null) {
                    sucNode.preOcpy = newResNode;
                    newResNode.sucOcpy = sucNode;
                }
            }
            readyTaskMap.put(pmsTask.getTaskUid(), optTaskNode);    // 加入已安排任务集合
//            System.out.println("**************");
//            System.out.println(pmsTask.getTaskName());
//            System.out.println("优先级" + optTaskNode.getPriorityValue());
//            System.out.println(optTaskNode.getSucTaskCountSum() + "\t" + "\t" + optTaskNode.getSucTaskDurSum() + "\t" + "\t"
//                    + optTaskNode.getLateFinish() + "\t" + "\t" + optTaskNode.getImportance());
//            System.out.println(optTaskNode.getSucTaskCountSumValue() + "\t" + "\t" + optTaskNode.getSucTaskDurSumValue() + "\t" + "\t"
//                    + optTaskNode.getLateFinishValue() + "\t" + "\t" + optTaskNode.getImportanceValue());
//            System.out.println(pmsTask.getTaskPlanStartDateTime());
//            System.out.println(pmsTask.getTaskPlanFinishDateTime());
        }

        // 得到个体对应的计划中，每个项目的开始结束时间，存入projStartFinishTimeMap并返回
        for (Map.Entry<String, List<OptTaskNode>[]> entry : projFirstLastTasksMap.entrySet()) {
            String projUid = entry.getKey();
            List<OptTaskNode>[] value = entry.getValue();
            Timestamp start = new Timestamp(Long.MAX_VALUE);    // 项目的开始时间
            Timestamp finish = new Timestamp(Long.MIN_VALUE);   // 项目的结束时间
            for (OptTaskNode first : value[0]) {
                if (start.after(first.getPmsTask().getTaskPlanStartDateTime()))
                    start.setTime(first.getPmsTask().getTaskPlanStartDateTime().getTime());
            }
            for (OptTaskNode last : value[1]) {
                if (finish.before(last.getPmsTask().getTaskPlanFinishDateTime()))
                    finish.setTime(last.getPmsTask().getTaskPlanFinishDateTime().getTime());
            }
            projStartFinishTimeMap.put(projUid, new Timestamp[]{start, finish});
        }
        
        return projStartFinishTimeMap;
    }

    // 自定义优先队列的比较器，按任务优先级评价的降序排列
    static Comparator<OptTaskNode> cmpOptTaskNode = new Comparator<OptTaskNode>() {
        @Override
        public int compare(OptTaskNode o1, OptTaskNode o2) {
            return Double.compare(o2.getPriorityValue(), o1.getPriorityValue());
        }
    };

    // 求任务的优先级评价值
    public double priorityValue(OptTaskNode optTaskNode, double[] chromosome) {
        return (chromosome[0] * optTaskNode.getSucTaskCountSumValue()
                + chromosome[1] * optTaskNode.getSucTaskDurSumValue()
                + chromosome[2] * optTaskNode.getLateFinishValue()
                + chromosome[3] * optTaskNode.getImportanceValue());
    }
    // 由开始时间、时长以及工作模式得到结束时间
    public Timestamp endTime(Timestamp start, double dur, int model) {
        Timestamp end = new Timestamp(start.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        int durDays = (int)dur;      // 任务预计工期的天数部分
        int durHours = (int) ((dur - durDays) * 10);  // 任务预计工期的小时数部分
        int remainHours = 18 - calendar.get(Calendar.HOUR_OF_DAY);   // 当前开始时间到下班时间之间的小时数
        if (model == 1 && remainHours < durHours) {
            end.setTime(start.getTime() + remainHours * MS_OF_HOUR);
            remainHours = 0;
        }
        end.setTime(end.getTime() + durDays * MS_OF_DAY + durHours * MS_OF_HOUR);
        if (remainHours < durHours) {
            end.setTime(end.getTime() + 14 * MS_OF_HOUR);   // 如果当天剩余的工作时间无法满足工期的小时数部分，则需要多跨一天
        }
        return end;
    }

    // 根据个体解码信息，计算适应度值
    public double fitness(int G, Map<String, Timestamp[]> projStartFinishTimeMap) {
        double fitness = 0;
        double g = G >> 2; g = g * g;      // 罚函数中的系数，G为种群代数
        for (Map.Entry<String, Timestamp[]> entry : projStartFinishTimeMap.entrySet()) {
            PmsProject pmsProject = pmsProjectMap.get(entry.getKey());  // 当前遍历到的项目实例
            Timestamp start = entry.getValue()[0];                      // 解码得到的该项目的计划开始时间
            Timestamp finish = entry.getValue()[1];                     // 解码得到的该项目的计划结束时间
            Timestamp projLateFinish = pmsProject.getProjLateFinishDateTime();  // 项目的最晚完成时间
            double estimateDur = pmsProject.getProjPlanDur();                   // 编制时预估的项目工期
            double planDur = (finish.getTime() - start.getTime()) / (double)MS_OF_DAY;  // 解码得到的计划工期(天)
            double f = planDur / estimateDur;           // 个体适应度值
            if (finish.after(projLateFinish)) {         // 如果项目超期了，适应度值就加上罚函数
                double exceedTime = (finish.getTime() - projLateFinish.getTime()) / MS_OF_DAY + 1;  // 超期天数
                f += g * exceedTime * exceedTime / estimateDur;      // 加上罚函数对个体进行惩罚
                System.out.println();
                System.out.println("超期" + exceedTime + "被惩罚了：" + finish);
            }
            fitness += f;
        }
        return fitness;
    }

    public double[] mutate(int target, double[][] population, int[] genValueLimit) {
        int chromosomeNum = population.length;
        int genNum = population[0].length;
        double[] mutation = new double[genNum];     // 变异个体
        // 选取三个不同的个体
        int a = (int)(Math.random() * chromosomeNum);
        int b = (int)(Math.random() * chromosomeNum);
        int c = (int)(Math.random() * chromosomeNum);
        while (a == target)
            a = (int)(Math.random() * chromosomeNum);
        while (b == a)
            b = (int)(Math.random() * chromosomeNum);
        while (c == b)
            c = (int)(Math.random() * chromosomeNum);
        double[] r1 = population[a];
        double[] r2 = population[b];
        double[] r3 = population[c];
        // 编码前半段，差分进化产生变异，缩放因子SF
        for (int i = 0; i < 4; i++) {
            mutation[i] = r1[i] + SF * (r2[i] - r3[i]);
            // mutation[i]不超过[0, 1]
            if (mutation[i] < 0)
                mutation[i] = -mutation[i];
            if (mutation[i] > 1)
                mutation[i] = 2 - mutation[i];
        }
        // 编码后半段，逐码变异，变异概率MR
        for (int i = 4; i < genNum; i++) {
            if (Math.random() < MR) {                   // 如果满足变异概率
                if (genValueLimit[i] >= 0)              // 如果任务有资源方案(!= -1)
                    mutation[i] = (int)(Math.random() * genValueLimit[i]);    // 取值范围0~资源方案个数n，包括0，不包括n
            } else {
                mutation[i] = r1[i];
            }
        }

        return mutation;
    }

    public double[] cross(double[] target, double[] mutation) {
        int genNum = target.length;
        double[] crossover = mutation;      // 变异个体将通过交叉操作成为交叉个体
        // 编码前半段，差分进化产生交叉，交叉概率为CR
        for (int i = 0; i < 4; i++) {
            if (Math.random() < MR) {       // 如果满足交叉概率
                crossover[i] = target[i];
            }
        }
        // 编码后半段，两点交叉
        if (Math.random() < MR) {       // 如果满足交叉概率
            int left = (int) (Math.random() * (genNum - 4)) + 4;      // 交叉点1
            int right = (int) (Math.random() * (genNum - 4)) + 4;     // 交叉点2
            if (left > right) {
                int temp = left;
                left = right;
                right = temp;
            }
            for (int i = left; i <= right; i++) {
                crossover[i] = target[i];
            }
        }
        return crossover;
    }

    public List<PmsTask> test() {
        List<String> procUidList = new ArrayList<>();
        procUidList.add("707224909687816192");
        procUidList.add("707323834117652480");
//        initTaskNodes(procUidList);
//
//        // 正序广度优先遍历
//        Queue<OptTaskNode> queue = new LinkedList<>();
//        queue.addAll(startOptTaskNode.getSucTasks());
//        System.out.println("正序遍历");
//        while (!queue.isEmpty()) {
//            OptTaskNode optTaskNode = queue.poll();
//            for (OptTaskNode sucTask : optTaskNode.getSucTasks()) {
//                sucTask.setCurPreTaskCount(sucTask.getCurPreTaskCount() - 1);
//                // 紧后任务入队
//                if (sucTask.getCurPreTaskCount() == 0) {
//                    queue.add(sucTask);
//                    sucTask.setCurPreTaskCount(sucTask.getPreTaskCount());
//                }
//            }
//            System.out.println("任务名称：" + optTaskNode.getPmsTask().getTaskName());
//            System.out.println("**基因位下标：" + optTaskNode.getResPlanGenIndex()
//                    + "   后续任务数量规则项：" + optTaskNode.getSucTaskCountSumValue() + "   后续任务工期规则项：" + optTaskNode.getSucTaskDurSumValue()
//                    + "   任务最晚完成时间规则项" + optTaskNode.getLateFinishValue() + "   任务重要性规则项" + optTaskNode.getImportanceValue());
//        }
        return optimize(procUidList);
    }
    public OptResult testWeb(List<String> procUidList) {
        List<Task> taskList = pmsTaskService.getTaskListByTasksAndTaskLinks(optimize(procUidList), pmsTaskLinkService.selectByProcUidList(procUidList));
        List<List<ResOcpyNode>> resOcpyNodesList = new LinkedList<>();
        for (Map.Entry<String, ResOcpyNode> entry : resOcpyNodeMap.entrySet()) {
            List<ResOcpyNode> resOcpyNodes = new LinkedList<>();
            ResOcpyNode resOcpyNode = entry.getValue().sucOcpy;
            String resUid = entry.getKey();
            String resName = null;
            int resType = resOcpyNode.getResType();
            if (resType == 0) {
                resName = pmsHumanService.selectByUid(resUid).getHumName();
            }
            if (resType == 1) {
                resName = pmsEquipmentService.selectByUid(resUid).getEquipName();
            }

            while (resOcpyNode != null) {
                ResOcpyNode newNode = new ResOcpyNode(resOcpyNode);
                newNode.setProjName(pmsProjectMap.get(newNode.getPmsTaskResReq().getResReqProjUid()).getProjName());
                newNode.setTaskName(optTaskNodeMap.get(newNode.getPmsTaskResReq().getResReqTaskUid()).getPmsTask().getTaskName());
                newNode.setResName(resName);
                newNode.setPreOcpy(null);
                newNode.setSucOcpy(null);
//                newNode.setPmsTaskResReq(null);
                resOcpyNodes.add(newNode);
                resOcpyNode = resOcpyNode.sucOcpy;
            }
            resOcpyNodesList.add(resOcpyNodes);
        }
        OptResult optResult = new OptResult(taskList, resOcpyNodesList);
        return optResult;
    }
}
