package com.buaa.pms.service;

import com.buaa.pms.entity.PmsProcess;
import com.buaa.pms.model.Process;

import java.util.List;

public interface PmsProcessService {

    public List<PmsProcess> selectAll();

    public List<Process> getProcList();

    public List<PmsProcess> selectPublished();

    public List<PmsProcess> selectByProjUid(String procProjUid);

    public List<Process> getProcListByProjUid(String procProjUid);

    public PmsProcess selectByUid(String procUid);

    public void save(PmsProcess pmsProcess);

    public void deleteByUid(String procUid);

    public void deleteByProjUid(String projUid);

    public void update(PmsProcess pmsProcess);

    public void saveOrUpdate(PmsProcess pmsProcess);

}
