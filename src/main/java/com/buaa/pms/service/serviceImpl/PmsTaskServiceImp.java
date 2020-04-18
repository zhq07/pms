package com.buaa.pms.service.serviceImpl;

import com.buaa.pms.entity.PmsProcess;
import com.buaa.pms.entity.PmsProject;
import com.buaa.pms.entity.PmsTask;
import com.buaa.pms.entity.PmsTaskLink;
import com.buaa.pms.mapper.PmsTaskMapper;
import com.buaa.pms.model.Task;
import com.buaa.pms.service.*;
import com.buaa.pms.util.MyUUID;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PmsTaskServiceImp implements PmsTaskService {
    @Resource
    PmsTaskMapper  pmsTaskMapper;

    @Resource
    PmsTaskLinkService pmsTaskLinkService;

    @Resource
    PmsTaskResPlanService pmsTaskResPlanService;

    @Resource
    PmsProjectService pmsProjectService;

    @Resource
    PmsProcessService pmsProcessService;

    @Override
    public List<PmsTask> selectAll() {
        return pmsTaskMapper.selectAll();
    }

    @Override
    public List<PmsTask> selectByProjUid(String taskProjUid) {
        return pmsTaskMapper.selectByProjUid(taskProjUid);
    }

    @Override
    public List<Task> getTaskListByProjUid(String taskProjUid) {
        List<PmsTask> pmsTasks = this.selectByProjUid(taskProjUid);
        List<PmsTaskLink> pmsTaskLinks = pmsTaskLinkService.selectByProjUid(taskProjUid);
        return this.getTaskListByTasksAndTaskLinks(pmsTasks, pmsTaskLinks);
    }

    @Override
    public List<PmsTask> selectByProcUid(String taskProcUid) {
        return pmsTaskMapper.selectByProcUid(taskProcUid);
    }

    @Override
    public List<Task> getTaskListByProcUid(String taskProcUid) {
        List<PmsTask> pmsTasks = this.selectByProcUid(taskProcUid);
        List<PmsTaskLink> pmsTaskLinks = pmsTaskLinkService.selectByProcUid(taskProcUid);
        return this.getTaskListByTasksAndTaskLinks(pmsTasks, pmsTaskLinks);
    }

    @Override
    public List<PmsTask> selectByParUid(String taskParUid) {
        return pmsTaskMapper.selectByParUid(taskParUid);
    }

    @Override
    public PmsTask selectByUid(String taskUid) {
        return pmsTaskMapper.selectByUid(taskUid);
    }

    @Override
    public void save(PmsTask pmsTask) {
        // 分配UUID
        pmsTask.setTaskUid(new MyUUID().getUUID());
        // 计算计划工期
        if (pmsTask.getTaskPlanStartDate() != null && pmsTask.getTaskPlanFinishDate() != null) {
            int planDur = (int) (pmsTask.getTaskPlanFinishDate().getTime() - pmsTask.getTaskPlanStartDate().getTime()) / (1000 * 60 * 60 * 24) + 1;
            pmsTask.setTaskPlanDur(planDur);
        }
        // 计算实际工期
        if (pmsTask.getTaskActStartDate() != null && pmsTask.getTaskActFinishDate() != null) {
            int actDur = (int) (pmsTask.getTaskActFinishDate().getTime() - pmsTask.getTaskActStartDate().getTime()) / (1000 * 60 * 60 * 24) + 1;
            pmsTask.setTaskActDur(actDur);
        }
        // 新增任务默认状态 0-“编制中”
        if (pmsTask.getTaskState() == null)
            pmsTask.setTaskState(0);
        pmsTaskMapper.save(pmsTask);
    }

    @Override
    public void deleteByUid(String taskUid) {
        // 删除任务相关连接
        pmsTaskLinkService.deleteByTaskUid(taskUid);
        // 删除任务资源方案
        pmsTaskResPlanService.deleteByTaskUid(taskUid);
        // 删除任务
        pmsTaskMapper.deleteByUid(taskUid);
    }

    @Override
    public void deleteByProjUid(String projUid) {
        // 删除任务相关连接
        pmsTaskLinkService.deleteByProjUid(projUid);
        // 删除任务
        pmsTaskMapper.deleteByProjUid(projUid);
    }

    @Override
    public void deleteByProcUid(String procUid) {
        // 删除任务相关连接
        pmsTaskLinkService.deleteByProcUid(procUid);
        // 删除任务
        pmsTaskMapper.deleteByProcUid(procUid);
    }

    @Override
    public void deleteByParUid(String parUid) {
        pmsTaskMapper.deleteByParUid(parUid);
    }

    @Override
    public void update(PmsTask pmsTask) {
        // 计算计划工期
        if (pmsTask.getTaskPlanStartDate() != null && pmsTask.getTaskPlanFinishDate() != null) {
            int planDur = (int) (pmsTask.getTaskPlanFinishDate().getTime() - pmsTask.getTaskPlanStartDate().getTime()) / (1000 * 60 * 60 * 24) + 1;
            pmsTask.setTaskPlanDur(planDur);
        }
        // 计算实际工期
        if (pmsTask.getTaskActStartDate() != null && pmsTask.getTaskActFinishDate() != null) {
            int actDur = (int) (pmsTask.getTaskActFinishDate().getTime() - pmsTask.getTaskActStartDate().getTime()) / (1000 * 60 * 60 * 24) + 1;
            pmsTask.setTaskActDur(actDur);
        }
        // 任务状态若为空，则保持以前的状态
        if (pmsTask.getTaskState() == null) {
            int state = pmsTaskMapper.selectByUid(pmsTask.getTaskUid()).getTaskState();
            pmsTask.setTaskState(state);
        }
        pmsTaskMapper.update(pmsTask);
    }

    @Override
    public void updatePmsTaskIds(List<PmsTask> pmsTasks) {
        if (pmsTasks != null && !pmsTasks.isEmpty())
            pmsTaskMapper.updatePmsTaskIds(pmsTasks);
    }

    @Override
    public void saveOrUpdate(PmsTask pmsTask) {
        if (pmsTask.getTaskUid() == null || pmsTask.getTaskUid().equals("")) {
            this.save(pmsTask);
        } else {
            this.update(pmsTask);
        }
    }

    @Override
    public void saveOrUpdateTask(Task task) {
        // 保存任务
        PmsTask pmsTask = task.getPmsTask();
        this.saveOrUpdate(pmsTask);
        // 保存任务连接
        pmsTaskLinkService.deleteBySucTaskUid(task.getPmsTask().getTaskUid());
        List<PmsTaskLink> pmsTaskLinks = new ArrayList<>();
        MyUUID myUUID = new MyUUID();
        for (PmsTask normalPreTask : task.getTaskNormalPreTasks()) {
            PmsTaskLink normalTaskLink = new PmsTaskLink();
            normalTaskLink.setTaskLinkUid(myUUID.getUUID());
            normalTaskLink.setTaskLinkType(0);
            normalTaskLink.setTaskLinkPreTaskUid(normalPreTask.getTaskUid());
            normalTaskLink.setTaskLinkSucTaskUid(pmsTask.getTaskUid());
            normalTaskLink.setTaskLinkProcUid(pmsTask.getTaskProcUid());
            normalTaskLink.setTaskLinkProjUid(pmsTask.getTaskProjUid());
            pmsTaskLinks.add(normalTaskLink);
        }
        for (PmsTask realPreTask : task.getTaskRealPreTasks()) {
            PmsTaskLink realTaskLink = new PmsTaskLink();
            realTaskLink.setTaskLinkUid(myUUID.getUUID());
            realTaskLink.setTaskLinkType(1);
            realTaskLink.setTaskLinkPreTaskUid(realPreTask.getTaskUid());
            realTaskLink.setTaskLinkSucTaskUid(pmsTask.getTaskUid());
            realTaskLink.setTaskLinkProcUid(pmsTask.getTaskProcUid());
            realTaskLink.setTaskLinkProjUid(pmsTask.getTaskProjUid());
            pmsTaskLinks.add(realTaskLink);
        }
        if (!pmsTaskLinks.isEmpty())
            pmsTaskLinkService.saveTaskLinks(pmsTaskLinks);
    }

    private List<Task> getTaskListByTasksAndTaskLinks(List<PmsTask> pmsTasks, List<PmsTaskLink> pmsTaskLinks) {
        List<Task> taskList = new ArrayList<>();
        Map<String, PmsTask> pmsTaskMap = new HashMap<>();
        Map<String, List<PmsTask>> pmsTaskNormalPreMap = new HashMap<>();
        Map<String, List<PmsTask>> pmsTaskRealPreMap = new HashMap<>();
        for (PmsTask pmsTask : pmsTasks) {
            pmsTaskMap.put(pmsTask.getTaskUid(), pmsTask);
        }
        for (PmsTaskLink pmsTaskLink : pmsTaskLinks) {
            if (pmsTaskLink.getTaskLinkType() == 0) {
                if (!pmsTaskNormalPreMap.containsKey(pmsTaskLink.getTaskLinkSucTaskUid())) {
                    List<PmsTask> normalPreTasks = new ArrayList<>();
                    normalPreTasks.add(pmsTaskMap.get(pmsTaskLink.getTaskLinkPreTaskUid()));
                    pmsTaskNormalPreMap.put(pmsTaskLink.getTaskLinkSucTaskUid(), normalPreTasks);
                } else {
                    pmsTaskNormalPreMap.get(pmsTaskLink.getTaskLinkSucTaskUid()).add(pmsTaskMap.get(pmsTaskLink.getTaskLinkPreTaskUid()));
                }
            } else {
                if (!pmsTaskRealPreMap.containsKey(pmsTaskLink.getTaskLinkSucTaskUid())) {
                    List<PmsTask> realPreTasks = new ArrayList<>();
                    realPreTasks.add(pmsTaskMap.get(pmsTaskLink.getTaskLinkPreTaskUid()));
                    pmsTaskRealPreMap.put(pmsTaskLink.getTaskLinkSucTaskUid(), realPreTasks);
                } else {
                    pmsTaskRealPreMap.get(pmsTaskLink.getTaskLinkSucTaskUid()).add(pmsTaskMap.get(pmsTaskLink.getTaskLinkPreTaskUid()));
                }
            }
        }
        for (PmsTask pmsTask : pmsTasks) {
            List<PmsTask> normalPreTasks = pmsTaskNormalPreMap.get(pmsTask.getTaskUid());
            List<PmsTask> realPreTasks = pmsTaskRealPreMap.get(pmsTask.getTaskUid());
            Task task = new Task(pmsTask, normalPreTasks == null ? new ArrayList<>() : normalPreTasks, realPreTasks == null ? new ArrayList<>() : realPreTasks);
            taskList.add(task);
        }
        return taskList;
    }
}
