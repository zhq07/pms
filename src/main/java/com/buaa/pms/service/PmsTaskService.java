package com.buaa.pms.service;

import com.buaa.pms.entity.PmsTask;
import com.buaa.pms.model.Task;

import java.util.List;

public interface PmsTaskService {

    public List<PmsTask> selectAll();

    public List<PmsTask> selectByProjUid(String taskProjUid);

    public List<Task> getTaskListByProjUid(String taskProjUid);

    public List<PmsTask> selectByProcUid(String taskProcUid);

    public List<Task> getTaskListByProcUid(String taskProcUid);

    public List<PmsTask> selectByParUid(String taskParUid);

    public PmsTask selectByUid(String taskUid);

    public void save(PmsTask pmsTask);

    public void deleteByUid(String taskUid);

    public void deleteByProjUid(String projUid);

    public void deleteByProcUid(String procUid);

    public void deleteByParUid(String parUid);

    public void update(PmsTask pmsTask);

    public void updatePmsTaskIds(List<PmsTask> pmsTasks);

    public void saveOrUpdate(PmsTask pmsTask);

    public void saveOrUpdateTask(Task task);

}
