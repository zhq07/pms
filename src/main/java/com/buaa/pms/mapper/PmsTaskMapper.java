package com.buaa.pms.mapper;

import com.buaa.pms.entity.PmsTask;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PmsTaskMapper {

    public List<PmsTask> selectAll();

    public List<PmsTask> selectByProjUid(String taskProjUid);

    public List<PmsTask> selectByProcUid(String taskProcUid);

    public List<PmsTask> selectByParUid(String taskParUid);

    public PmsTask selectByUid(String taskUid);

    public void save(PmsTask pmsTask);

    public void deleteByUid(String taskUid);

    public void deleteByProjUid(String projUid);

    public void deleteByProcUid(String procUid);

    public void deleteByParUid(String parUid);

    public void update(PmsTask pmsTask);
}
