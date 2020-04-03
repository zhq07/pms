package com.buaa.pms.entity;

import java.sql.Date;

public class PmsOptTask {

    private String optTaskUid;
    private String optTaskOptProjUid;
    private String optTaskTaskUid;
    private String optTaskProjUid;
    private String optTaskProcUid;
    private Date optTaskPlanStartDate;
    private Date optTaskPlanFinishDate;
    private Integer optTaskPlanDur;

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

    public String getOptTaskTaskUid() {
        return optTaskTaskUid;
    }

    public void setOptTaskTaskUid(String optTaskTaskUid) {
        this.optTaskTaskUid = optTaskTaskUid;
    }

    public String getOptTaskProjUid() {
        return optTaskProjUid;
    }

    public void setOptTaskProjUid(String optTaskProjUid) {
        this.optTaskProjUid = optTaskProjUid;
    }

    public String getOptTaskProcUid() {
        return optTaskProcUid;
    }

    public void setOptTaskProcUid(String optTaskProcUid) {
        this.optTaskProcUid = optTaskProcUid;
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

    @Override
    public String toString() {
        return "PmsOptTask{" +
                "optTaskUid='" + optTaskUid + '\'' +
                ", optTaskOptProjUid='" + optTaskOptProjUid + '\'' +
                ", optTaskTaskUid='" + optTaskTaskUid + '\'' +
                ", optTaskProjUid='" + optTaskProjUid + '\'' +
                ", optTaskProcUid='" + optTaskProcUid + '\'' +
                ", optTaskPlanStartDate=" + optTaskPlanStartDate +
                ", optTaskPlanFinishDate=" + optTaskPlanFinishDate +
                ", optTaskPlanDur=" + optTaskPlanDur +
                '}';
    }
}
