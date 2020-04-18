package com.buaa.pms.service.serviceImpl;

import com.buaa.pms.entity.PmsTaskResPlan;
import com.buaa.pms.mapper.PmsTaskResPlanMapper;
import com.buaa.pms.service.PmsTaskResPlanService;
import com.buaa.pms.util.MyUUID;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PmsTaskResPlanServiceImp implements PmsTaskResPlanService {

    @Resource
    PmsTaskResPlanMapper pmsTaskResPlanMapper;

    @Override
    public List<PmsTaskResPlan> selectAll() {
        return pmsTaskResPlanMapper.selectAll();
    }

    @Override
    public List<PmsTaskResPlan> selectByProjUid(String resPlanProjUid) {
        return pmsTaskResPlanMapper.selectByProjUid(resPlanProjUid);
    }

    @Override
    public List<PmsTaskResPlan> selectByProcUid(String resPlanProcUid) {
        return pmsTaskResPlanMapper.selectByProcUid(resPlanProcUid);
    }

    @Override
    public List<PmsTaskResPlan> selectByTaskUid(String resPlanTaskUid) {
        return pmsTaskResPlanMapper.selectByTaskUid(resPlanTaskUid);
    }

    @Override
    public PmsTaskResPlan selectByUid(String resPlanUid) {
        return pmsTaskResPlanMapper.selectByUid(resPlanUid);
    }

    @Override
    public void save(PmsTaskResPlan pmsTaskResPlan) {
        // 分配UUID
        pmsTaskResPlan.setResPlanUid(new MyUUID().getUUID());
        pmsTaskResPlanMapper.save(pmsTaskResPlan);
    }

    @Override
    public void deleteByUid(String resPlanUid) {
        pmsTaskResPlanMapper.deleteByUid(resPlanUid);
    }

    @Override
    public void deleteByTaskUid(String resPlanTaskUid) {
        pmsTaskResPlanMapper.deleteByTaskUid(resPlanTaskUid);
    }

    @Override
    public void deleteByProcUid(String resPlanProcUid) {
        pmsTaskResPlanMapper.deleteByProcUid(resPlanProcUid);
    }

    @Override
    public void deleteByProjUid(String resPlanProjUid) {
        pmsTaskResPlanMapper.deleteByProjUid(resPlanProjUid);
    }

    @Override
    public void update(PmsTaskResPlan pmsTaskResPlan) {
        pmsTaskResPlanMapper.update(pmsTaskResPlan);
    }

    @Override
    public void saveOrUpdate(PmsTaskResPlan pmsTaskResPlan) {
        if (pmsTaskResPlan.getResPlanUid() == null || pmsTaskResPlan.getResPlanUid().equals("")) {
            this.save(pmsTaskResPlan);
        } else {
            this.update(pmsTaskResPlan);
        }
    }
}
