package com.buaa.pms.entity;

import java.sql.Date;

public class PmsSimTask {

    private String simTaskUid;
    private String simTaskSimProjUid;
    private String simTaskTaskUid;
    private String simTaskProjUid;
    private String simTaskProcUid;
    private Date simTaskPlanStartDate;
    private Date simTaskPlanFinishDate;
    private Integer simTaskPlanDur;
    private Date simTaskEarlyStartDate;
    private Date simTaskLateFinishDate;
    private Integer simTaskWait;
    private Integer simTaskDurU;
    private Integer simTaskDurSigma;
    private Float simTaskPctRework;

    public String getSimTaskUid() {
        return simTaskUid;
    }

    public void setSimTaskUid(String simTaskUid) {
        this.simTaskUid = simTaskUid;
    }

    public String getSimTaskSimProjUid() {
        return simTaskSimProjUid;
    }

    public void setSimTaskSimProjUid(String simTaskSimProjUid) {
        this.simTaskSimProjUid = simTaskSimProjUid;
    }

    public String getSimTaskTaskUid() {
        return simTaskTaskUid;
    }

    public void setSimTaskTaskUid(String simTaskTaskUid) {
        this.simTaskTaskUid = simTaskTaskUid;
    }

    public String getSimTaskProjUid() {
        return simTaskProjUid;
    }

    public void setSimTaskProjUid(String simTaskProjUid) {
        this.simTaskProjUid = simTaskProjUid;
    }

    public String getSimTaskProcUid() {
        return simTaskProcUid;
    }

    public void setSimTaskProcUid(String simTaskProcUid) {
        this.simTaskProcUid = simTaskProcUid;
    }

    public Date getSimTaskPlanStartDate() {
        return simTaskPlanStartDate;
    }

    public void setSimTaskPlanStartDate(Date simTaskPlanStartDate) {
        this.simTaskPlanStartDate = simTaskPlanStartDate;
    }

    public Date getSimTaskPlanFinishDate() {
        return simTaskPlanFinishDate;
    }

    public void setSimTaskPlanFinishDate(Date simTaskPlanFinishDate) {
        this.simTaskPlanFinishDate = simTaskPlanFinishDate;
    }

    public Integer getSimTaskPlanDur() {
        return simTaskPlanDur;
    }

    public void setSimTaskPlanDur(Integer simTaskPlanDur) {
        this.simTaskPlanDur = simTaskPlanDur;
    }

    public Date getSimTaskEarlyStartDate() {
        return simTaskEarlyStartDate;
    }

    public void setSimTaskEarlyStartDate(Date simTaskEarlyStartDate) {
        this.simTaskEarlyStartDate = simTaskEarlyStartDate;
    }

    public Date getSimTaskLateFinishDate() {
        return simTaskLateFinishDate;
    }

    public void setSimTaskLateFinishDate(Date simTaskLateFinishDate) {
        this.simTaskLateFinishDate = simTaskLateFinishDate;
    }

    public Integer getSimTaskWait() {
        return simTaskWait;
    }

    public void setSimTaskWait(Integer simTaskWait) {
        this.simTaskWait = simTaskWait;
    }

    public Integer getSimTaskDurU() {
        return simTaskDurU;
    }

    public void setSimTaskDurU(Integer simTaskDurU) {
        this.simTaskDurU = simTaskDurU;
    }

    public Integer getSimTaskDurSigma() {
        return simTaskDurSigma;
    }

    public void setSimTaskDurSigma(Integer simTaskDurSigma) {
        this.simTaskDurSigma = simTaskDurSigma;
    }

    public Float getSimTaskPctRework() {
        return simTaskPctRework;
    }

    public void setSimTaskPctRework(Float simTaskPctRework) {
        this.simTaskPctRework = simTaskPctRework;
    }

    @Override
    public String toString() {
        return "PmsSimTask{" +
                "simTaskUid='" + simTaskUid + '\'' +
                ", simTaskSimProjUid='" + simTaskSimProjUid + '\'' +
                ", simTaskTaskUid='" + simTaskTaskUid + '\'' +
                ", simTaskProjUid='" + simTaskProjUid + '\'' +
                ", simTaskProcUid='" + simTaskProcUid + '\'' +
                ", simTaskPlanStartDate=" + simTaskPlanStartDate +
                ", simTaskPlanFinishDate=" + simTaskPlanFinishDate +
                ", simTaskPlanDur=" + simTaskPlanDur +
                ", simTaskEarlyStartDate=" + simTaskEarlyStartDate +
                ", simTaskLateFinishDate=" + simTaskLateFinishDate +
                ", simTaskWait=" + simTaskWait +
                ", simTaskDurU=" + simTaskDurU +
                ", simTaskDurSigma=" + simTaskDurSigma +
                ", simTaskPctRework=" + simTaskPctRework +
                '}';
    }
}
