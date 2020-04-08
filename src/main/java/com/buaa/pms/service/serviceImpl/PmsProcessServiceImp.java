package com.buaa.pms.service.serviceImpl;

import com.buaa.pms.entity.PmsProcess;
import com.buaa.pms.mapper.PmsProcessMapper;
import com.buaa.pms.mapper.PmsTaskMapper;
import com.buaa.pms.service.PmsProcessService;
import com.buaa.pms.util.MyUUID;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PmsProcessServiceImp implements PmsProcessService {
    @Resource
    PmsProcessMapper  pmsProcessMapper;

    @Override
    public List<PmsProcess> selectAll() {
        return pmsProcessMapper.selectAll();
    }

    @Override
    public List<PmsProcess> selectPublished() {
        return pmsProcessMapper.selectPublished();
    }

    @Override
    public List<PmsProcess> selectByProjUid(String procProjUid) {
        return pmsProcessMapper.selectByProjUid(procProjUid);
    }

    @Override
    public PmsProcess selectByUid(String procUid) {
        return pmsProcessMapper.selectByUid(procUid);
    }

    @Override
    public void save(PmsProcess pmsProcess) {
        // 分配UUID
        pmsProcess.setProcUid(new MyUUID().getUUID());
        // 计算计划工期
        if (pmsProcess.getProcPlanStartDate() != null && pmsProcess.getProcPlanFinishDate() != null) {
            int planDur = (int) (pmsProcess.getProcPlanStartDate().getTime() - pmsProcess.getProcPlanFinishDate().getTime()) / (1000 * 60 * 60 * 24) + 1;
            pmsProcess.setProcPlanDur(planDur);
        }
        // 新增流程默认状态 0-“编制中”
        if (pmsProcess.getProcState() == null)
            pmsProcess.setProcState(0);
        pmsProcessMapper.save(pmsProcess);
    }

    @Override
    public void deleteByUid(String procUid) {
        pmsProcessMapper.deleteByUid(procUid);
        // 后续要添加代码，流程删除后，其包含的任务、对应的优化项目和仿真项目也要删除
    }

    @Override
    public void deleteByProjUid(String projUid) {
        pmsProcessMapper.deleteByProjUid(projUid);
    }

    @Override
    public void update(PmsProcess pmsProcess) {
        // 计算计划工期
        if (pmsProcess.getProcPlanStartDate() != null && pmsProcess.getProcPlanFinishDate() != null) {
            int planDur = (int) (pmsProcess.getProcPlanFinishDate().getTime() - pmsProcess.getProcPlanStartDate().getTime()) / (1000 * 60 * 60 * 24) + 1;
            pmsProcess.setProcPlanDur(planDur);
        }
        // 项目状态若为空，则保持以前的状态
        if (pmsProcess.getProcState() == null) {
            int state = pmsProcessMapper.selectByUid(pmsProcess.getProcUid()).getProcState();
            pmsProcess.setProcState(state);
        }
        pmsProcessMapper.update(pmsProcess);
    }

    @Override
    public void saveOrUpdate(PmsProcess pmsProcess) {
        if (pmsProcess.getProcUid() == null || pmsProcess.getProcUid().equals("")) {
            pmsProcess.setProcUid(new MyUUID().getUUID());
            this.save(pmsProcess);
        } else {
            this.update(pmsProcess);
        }
    }
}
