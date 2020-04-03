package com.buaa.pms.entity;

import java.sql.Date;

public class PmsPublishedTask {

    private String taskUid;
    private String taskId;
    private String taskName;
    private String taskProjUid;
    private String taskProjName;
    private String taskProcUid;
    private String taskProcName;
    private String taskManager;
    private String taskDescription;
    private Date taskPlanStartDate;
    private Date taskPlanFinishDate;
    private Integer taskPlanDur;
    private Date taskEarlyStartDate;
    private Date taskLateFinishDate;
    private Date taskActStartDate;
    private Date taskActFinishDate;
    private Integer taskActDur;
    private Integer taskWork;
    private Integer taskCompWork;
    private Integer taskRemWork;
    private Float taskPctWork;
    private Integer taskStatus;

    public String getTaskUid() {
        return taskUid;
    }

    public void setTaskUid(String taskUid) {
        this.taskUid = taskUid;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskProjUid() {
        return taskProjUid;
    }

    public void setTaskProjUid(String taskProjUid) {
        this.taskProjUid = taskProjUid;
    }

    public String getTaskProjName() {
        return taskProjName;
    }

    public void setTaskProjName(String taskProjName) {
        this.taskProjName = taskProjName;
    }

    public String getTaskProcUid() {
        return taskProcUid;
    }

    public void setTaskProcUid(String taskProcUid) {
        this.taskProcUid = taskProcUid;
    }

    public String getTaskProcName() {
        return taskProcName;
    }

    public void setTaskProcName(String taskProcName) {
        this.taskProcName = taskProcName;
    }

    public String getTaskManager() {
        return taskManager;
    }

    public void setTaskManager(String taskManager) {
        this.taskManager = taskManager;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Date getTaskPlanStartDate() {
        return taskPlanStartDate;
    }

    public void setTaskPlanStartDate(Date taskPlanStartDate) {
        this.taskPlanStartDate = taskPlanStartDate;
    }

    public Date getTaskPlanFinishDate() {
        return taskPlanFinishDate;
    }

    public void setTaskPlanFinishDate(Date taskPlanFinishDate) {
        this.taskPlanFinishDate = taskPlanFinishDate;
    }

    public Integer getTaskPlanDur() {
        return taskPlanDur;
    }

    public void setTaskPlanDur(Integer taskPlanDur) {
        this.taskPlanDur = taskPlanDur;
    }

    public Date getTaskEarlyStartDate() {
        return taskEarlyStartDate;
    }

    public void setTaskEarlyStartDate(Date taskEarlyStartDate) {
        this.taskEarlyStartDate = taskEarlyStartDate;
    }

    public Date getTaskLateFinishDate() {
        return taskLateFinishDate;
    }

    public void setTaskLateFinishDate(Date taskLateFinishDate) {
        this.taskLateFinishDate = taskLateFinishDate;
    }

    public Date getTaskActStartDate() {
        return taskActStartDate;
    }

    public void setTaskActStartDate(Date taskActStartDate) {
        this.taskActStartDate = taskActStartDate;
    }

    public Date getTaskActFinishDate() {
        return taskActFinishDate;
    }

    public void setTaskActFinishDate(Date taskActFinishDate) {
        this.taskActFinishDate = taskActFinishDate;
    }

    public Integer getTaskActDur() {
        return taskActDur;
    }

    public void setTaskActDur(Integer taskActDur) {
        this.taskActDur = taskActDur;
    }

    public Integer getTaskWork() {
        return taskWork;
    }

    public void setTaskWork(Integer taskWork) {
        this.taskWork = taskWork;
    }

    public Integer getTaskCompWork() {
        return taskCompWork;
    }

    public void setTaskCompWork(Integer taskCompWork) {
        this.taskCompWork = taskCompWork;
    }

    public Integer getTaskRemWork() {
        return taskRemWork;
    }

    public void setTaskRemWork(Integer taskRemWork) {
        this.taskRemWork = taskRemWork;
    }

    public Float getTaskPctWork() {
        return taskPctWork;
    }

    public void setTaskPctWork(Float taskPctWork) {
        this.taskPctWork = taskPctWork;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "PmsPublishedTask{" +
                "taskUid='" + taskUid + '\'' +
                ", taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskProjUid='" + taskProjUid + '\'' +
                ", taskProjName='" + taskProjName + '\'' +
                ", taskProcUid='" + taskProcUid + '\'' +
                ", taskProcName='" + taskProcName + '\'' +
                ", taskManager='" + taskManager + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskPlanStartDate=" + taskPlanStartDate +
                ", taskPlanFinishDate=" + taskPlanFinishDate +
                ", taskPlanDur=" + taskPlanDur +
                ", taskEarlyStartDate=" + taskEarlyStartDate +
                ", taskLateFinishDate=" + taskLateFinishDate +
                ", taskActStartDate=" + taskActStartDate +
                ", taskActFinishDate=" + taskActFinishDate +
                ", taskActDur=" + taskActDur +
                ", taskWork=" + taskWork +
                ", taskCompWork=" + taskCompWork +
                ", taskRemWork=" + taskRemWork +
                ", taskPctWork=" + taskPctWork +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
