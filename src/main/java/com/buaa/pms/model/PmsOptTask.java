package com.buaa.pms.model;

import java.sql.Date;

public class PmsOptTask {

    private String optTaskUid;
    private String optTaskOptProjUid;
    private String optTaskOptProjName;
    private String optTaskTaskUid;
    private String optTaskTaskId;
    private String optTaskTaskName;
    private String optTaskProjUid;
    private String optTaskProjName;
    private String optTaskProcUid;
    private String optTaskProcName;
    private Date optTaskPlanStartDate;
    private Date optTaskPlanFinishDate;
    private Integer optTaskPlanDur;
    private Date optTaskEarlyStartDate;
    private Date optTaskLateFinishDate;

    public String getOptTaskUid() {
        return optTaskUid;
    }

    public void setOptTaskUid(String optTaskUid) {
        this.optTaskUid = optTaskUid;
    }

    public String getOptTaskOptProjUid() {
        return optTaskOptProjUid;
    }

    public void setOptTaskOptProjUid(String optTaskOptProjUid) {
        this.optTaskOptProjUid = optTaskOptProjUid;
    }

    public String getOptTaskOptProjName() {
        return optTaskOptProjName;
    }

    public void setOptTaskOptProjName(String optTaskOptProjName) {
        this.optTaskOptProjName = optTaskOptProjName;
    }

    public String getOptTaskTaskUid() {
        return optTaskTaskUid;
    }

    public void setOptTaskTaskUid(String optTaskTaskUid) {
        this.optTaskTaskUid = optTaskTaskUid;
    }

    public String getOptTaskTaskId() {
        return optTaskTaskId;
    }

    public void setOptTaskTaskId(String optTaskTaskId) {
        this.optTaskTaskId = optTaskTaskId;
    }

    public String getOptTaskTaskName() {
        return optTaskTaskName;
    }

    public void setOptTaskTaskName(String optTaskTaskName) {
        this.optTaskTaskName = optTaskTaskName;
    }

    public String getOptTaskProjUid() {
        return optTaskProjUid;
    }

    public void setOptTaskProjUid(String optTaskProjUid) {
        this.optTaskProjUid = optTaskProjUid;
    }

    public String getOptTaskProjName() {
        return optTaskProjName;
    }

    public void setOptTaskProjName(String optTaskProjName) {
        this.optTaskProjName = optTaskProjName;
    }

    public String getOptTaskProcUid() {
        return optTaskProcUid;
    }

    public void setOptTaskProcUid(String optTaskProcUid) {
        this.optTaskProcUid = optTaskProcUid;
    }

    public String getOptTaskProcName() {
        return optTaskProcName;
    }

    public void setOptTaskProcName(String optTaskProcName) {
        this.optTaskProcName = optTaskProcName;
    }

    public Date getOptTaskPlanStartDate() {
        return optTaskPlanStartDate;
    }

    public void setOptTaskPlanStartDate(Date optTaskPlanStartDate) {
        this.optTaskPlanStartDate = optTaskPlanStartDate;
    }

    public Date getOptTaskPlanFinishDate() {
        return optTaskPlanFinishDate;
    }

    public void setOptTaskPlanFinishDate(Date optTaskPlanFinishDate) {
        this.optTaskPlanFinishDate = optTaskPlanFinishDate;
    }

    public Integer getOptTaskPlanDur() {
        return optTaskPlanDur;
    }

    public void setOptTaskPlanDur(Integer optTaskPlanDur) {
        this.optTaskPlanDur = optTaskPlanDur;
    }

    public Date getOptTaskEarlyStartDate() {
        return optTaskEarlyStartDate;
    }

    public void setOptTaskEarlyStartDate(Date optTaskEarlyStartDate) {
        this.optTaskEarlyStartDate = optTaskEarlyStartDate;
    }

    public Date getOptTaskLateFinishDate() {
        return optTaskLateFinishDate;
    }

    public void setOptTaskLateFinishDate(Date optTaskLateFinishDate) {
        this.optTaskLateFinishDate = optTaskLateFinishDate;
    }

    @Override
    public String toString() {
        return "PmsOptTask{" +
                "optTaskUid='" + optTaskUid + '\'' +
                ", optTaskOptProjUid='" + optTaskOptProjUid + '\'' +
                ", optTaskOptProjName='" + optTaskOptProjName + '\'' +
                ", optTaskTaskUid='" + optTaskTaskUid + '\'' +
                ", optTaskTaskId='" + optTaskTaskId + '\'' +
                ", optTaskTaskName='" + optTaskTaskName + '\'' +
                ", optTaskProjUid='" + optTaskProjUid + '\'' +
                ", optTaskProjName='" + optTaskProjName + '\'' +
                ", optTaskProcUid='" + optTaskProcUid + '\'' +
                ", optTaskProcName='" + optTaskProcName + '\'' +
                ", optTaskPlanStartDate=" + optTaskPlanStartDate +
                ", optTaskPlanFinishDate=" + optTaskPlanFinishDate +
                ", optTaskPlanDur=" + optTaskPlanDur +
                ", optTaskEarlyStartDate=" + optTaskEarlyStartDate +
                ", optTaskLateFinishDate=" + optTaskLateFinishDate +
                '}';
    }
}
