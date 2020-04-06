package com.buaa.pms.service.serviceImpl;

import com.buaa.pms.entity.PmsTask;
import com.buaa.pms.mapper.PmsTaskMapper;
import com.buaa.pms.service.PmsTaskService;
import com.buaa.pms.util.MyUUID;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PmsTaskServiceImp implements PmsTaskService {
    @Resource
    PmsTaskMapper  pmsTaskMapper;

    @Override
    public List<PmsTask> selectAll() {
        return pmsTaskMapper.selectAll();
    }

    @Override
    public List<PmsTask> selectByProjUid(String taskProjUid) {
        return pmsTaskMapper.selectByProjUid(taskProjUid);
    }

    @Override
    public List<PmsTask> selectByProcUid(String taskProcUid) {
        return pmsTaskMapper.selectByProcUid(taskProcUid);
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
        pmsTaskMapper.save(pmsTask);
    }

    @Override
    public void deleteByUid(String taskUid) {
        pmsTaskMapper.deleteByUid(taskUid);
    }

    @Override
    public void deleteByProjUid(String projUid) {
        pmsTaskMapper.deleteByProjUid(projUid);
    }

    @Override
    public void deleteByProcUid(String procUid) {
        pmsTaskMapper.deleteByProcUid(procUid);
    }

    @Override
    public void deleteByParUid(String parUid) {
        pmsTaskMapper.deleteByParUid(parUid);
    }

    @Override
    public void update(PmsTask pmsTask) {
        pmsTaskMapper.update(pmsTask);
    }


    @Override
    public void saveOrUpdate(PmsTask pmsTask) {
        if (pmsTask.getTaskUid() == null || pmsTask.getTaskUid().equals("")) {
            pmsTask.setTaskUid(new MyUUID().getUUID());
            this.save(pmsTask);
        } else {
            this.update(pmsTask);
        }
    }
}
