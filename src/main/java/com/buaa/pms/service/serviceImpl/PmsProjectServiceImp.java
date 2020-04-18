package com.buaa.pms.service.serviceImpl;

import com.buaa.pms.entity.PmsOrganization;
import com.buaa.pms.entity.PmsProject;
import com.buaa.pms.entity.PmsTask;
import com.buaa.pms.mapper.PmsOrganizationMapper;
import com.buaa.pms.mapper.PmsProjectMapper;
import com.buaa.pms.model.ProjTableItem;
import com.buaa.pms.service.PmsProjectService;
import com.buaa.pms.service.PmsTaskService;
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
    PmsTaskService pmsTaskService;

    @Resource
    PmsOrganizationMapper pmsOrganizationMapper;

    @Override
    public List<PmsProject> selectAll() {
        return pmsProjectMapper.selectAll();
    }

    @Override
    public List<PmsProject> selectTop() {
        return pmsProjectMapper.selectTop();
    }

    @Override
    public List<PmsProject> selectPublished() {
        return pmsProjectMapper.selectPublished();
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
        // 分配UUID
        pmsProject.setProjUid(new MyUUID().getUUID());
        // 计算工期
        if (pmsProject.getProjPlanStartDate() != null && pmsProject.getProjPlanFinishDate() != null) {
            int planDur = (int) (pmsProject.getProjPlanStartDate().getTime() - pmsProject.getProjPlanFinishDate().getTime()) / (1000 * 60 * 60 * 24) + 1;
            pmsProject.setProjPlanDur(planDur);
        }
        // 计算实际工期
        if (pmsProject.getProjActStartDate() != null && pmsProject.getProjActFinishDate() != null) {
            int actDur = (int) (pmsProject.getProjActFinishDate().getTime() - pmsProject.getProjActStartDate().getTime()) / (1000 * 60 * 60 * 24) + 1;
            pmsProject.setProjActDur(actDur);
        }
        // 新增项目默认状态 0-“编制中”
        if (pmsProject.getProjState() == null)
            pmsProject.setProjState(0);
        pmsProjectMapper.save(pmsProject);
    }

    @Override
    public void deleteByUid(String projUid) {
        pmsProjectMapper.deleteByUid(projUid);
        // 后续要添加代码，项目删除后，其包含的流程和任务、对应的优化项目和仿真项目也要删除
    }

    @Override
    public void update(PmsProject pmsProject) {
        // 计算计划工期
        if (pmsProject.getProjPlanStartDate() != null && pmsProject.getProjPlanFinishDate() != null) {
            int planDur = (int) (pmsProject.getProjPlanFinishDate().getTime() - pmsProject.getProjPlanStartDate().getTime()) / (1000 * 60 * 60 * 24) + 1;
            pmsProject.setProjPlanDur(planDur);
        }
        // 计算实际工期
        if (pmsProject.getProjActStartDate() != null && pmsProject.getProjActFinishDate() != null) {
            int actDur = (int) (pmsProject.getProjActFinishDate().getTime() - pmsProject.getProjActStartDate().getTime()) / (1000 * 60 * 60 * 24) + 1;
            pmsProject.setProjActDur(actDur);
        }
        // 项目状态若为空，则保持以前的状态
        if (pmsProject.getProjState() == null) {
            int state = pmsProjectMapper.selectByUid(pmsProject.getProjUid()).getProjState();
            pmsProject.setProjState(state);
        }
        pmsProjectMapper.update(pmsProject);
    }

    @Override
    public void saveOrUpdate(PmsProject pmsProject) {
        if (pmsProject.getProjUid() == null || pmsProject.getProjUid().equals("")) {
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
        PmsTask projTask = pmsTaskService.selectByUid(proj.getProjTaskUid());
        tableItem.setProjTaskName(projTask == null ? "" : projTask.getTaskName());

        tableItem.setProjParUid(proj.getProjParUid());
        PmsProject parProj = pmsProjectMapper.selectByUid(proj.getProjParUid());
        tableItem.setProjParName(parProj == null ? "" : parProj.getProjName());

        tableItem.setProjOrgUid(proj.getProjOrgUid());
        PmsOrganization projOrg = pmsOrganizationMapper.selectByUid(proj.getProjOrgUid());
        tableItem.setProjOrgName(projOrg == null ? "" : projOrg.getOrgName());

        tableItem.setProjManager(proj.getProjManager());
        tableItem.setProjDescription(proj.getProjDescription());
        tableItem.setProjPlanStartDate(proj.getProjPlanStartDate());
        tableItem.setProjPlanFinishDate(proj.getProjPlanFinishDate());
        tableItem.setProjPlanDur(proj.getProjPlanDur());
        tableItem.setProjEarlyStartDate(proj.getProjEarlyStartDate());
        tableItem.setProjLateFinishDate(proj.getProjLateFinishDate());
        tableItem.setProjActStartDate(proj.getProjActStartDate());
        tableItem.setProjActFinishDate(proj.getProjActFinishDate());
        tableItem.setProjPctWork(proj.getProjPctWork());
        tableItem.setProjState(proj.getProjState());
        tableItem.setChildren(this.getChildrenByUid(proj.getProjUid()));

        return tableItem;
    }
}
