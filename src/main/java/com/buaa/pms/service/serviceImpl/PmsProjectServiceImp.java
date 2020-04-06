package com.buaa.pms.service.serviceImpl;

import com.buaa.pms.entity.PmsProject;
import com.buaa.pms.entity.PmsTask;
import com.buaa.pms.mapper.PmsProjectMapper;
import com.buaa.pms.mapper.PmsTaskMapper;
import com.buaa.pms.model.ProjTableItem;
import com.buaa.pms.service.PmsProjectService;
import com.buaa.pms.util.MyUUID;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PmsProjectServiceImp implements PmsProjectService {
    @Resource
    PmsProjectMapper  pmsProjectMapper;

    @Resource
    PmsTaskMapper pmsTaskMapper;

    @Override
    public List<PmsProject> selectAll() {
        return pmsProjectMapper.selectAll();
    }

    @Override
    public List<PmsProject> selectTop() {
        return pmsProjectMapper.selectTop();
    }

    @Override
    public List<PmsProject> selectByParUid(String projParUid) {
        return pmsProjectMapper.selectByParUid(projParUid);
    }

    @Override
    public PmsProject selectByUid(String projUid) {
        return pmsProjectMapper.selectByUid(projUid);
    }

    @Override
    public void save(PmsProject pmsProject) {
        pmsProject.setProjUid(new MyUUID().getUUID());
        pmsProjectMapper.save(pmsProject);
    }

    @Override
    public void deleteByUid(String projUid) {
        pmsProjectMapper.deleteByUid(projUid);
        // 后续要添加代码，项目删除后，其包含的流程和任务、对应的优化项目和仿真项目也要删除
    }

    @Override
    public void update(PmsProject pmsProject) {
        pmsProjectMapper.update(pmsProject);
    }

    @Override
    public void saveOrUpdate(PmsProject pmsProject) {
        if (pmsProject.getProjUid() == null || pmsProject.getProjUid().equals("")) {
            pmsProject.setProjUid(new MyUUID().getUUID());
            this.save(pmsProject);
        } else {
            this.update(pmsProject);
        }
    }

    @Override
    public List<ProjTableItem> getProjTableData() {
        List<ProjTableItem> tabalData = new ArrayList<>();

        for (PmsProject proj : pmsProjectMapper.selectTop()) {
            ProjTableItem tableItem = this.getTabItemFromProj(proj);
            tabalData.add(tableItem);
        }
        return tabalData;
    }

    private List<ProjTableItem> getChildrenByUid(String projUid) {
        List<ProjTableItem> children = new ArrayList<>();
        for (PmsProject proj : pmsProjectMapper.selectByParUid(projUid)) {
            ProjTableItem tableItem = this.getTabItemFromProj(proj);
            children.add(tableItem);
        }
        return children;
    }

    private ProjTableItem getTabItemFromProj(PmsProject proj) {
        ProjTableItem tableItem = new ProjTableItem();

        tableItem.setProjUid(proj.getProjUid());
        tableItem.setProjId(proj.getProjId());
        tableItem.setProjName(proj.getProjName());

        tableItem.setProjTaskUid(proj.getProjTaskUid());
        PmsTask projTask = pmsTaskMapper.selectByUid(proj.getProjTaskUid());
        tableItem.setProjTaskName(projTask == null ? "" : projTask.getTaskName());

        tableItem.setProjParUid(proj.getProjParUid());
        PmsProject parProj = pmsProjectMapper.selectByUid(proj.getProjParUid());
        tableItem.setProjParName(parProj == null ? "" : parProj.getProjName());

        tableItem.setProjManager(proj.getProjManager());
        tableItem.setProjDescription(proj.getProjDescription());
        tableItem.setProjPlanStartDate(proj.getProjPlanStartDate());
        tableItem.setProjPlanFinishDate(proj.getProjPlanFinishDate());
        tableItem.setProjPlanDur(proj.getProjPlanDur());
        tableItem.setProjEarlyStartDate(proj.getProjEarlyStartDate());
        tableItem.setProjLateFinishDate(proj.getProjLateFinishDate());
        tableItem.setProjStatus(proj.getProjStatus());

        tableItem.setChildren(this.getChildrenByUid(proj.getProjUid()));

        return tableItem;
    }
}
