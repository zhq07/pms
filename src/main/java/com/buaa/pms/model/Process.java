package com.buaa.pms.model;

import java.sql.Date;

public class Process {

    private String procUid;
    private String procId;
    private String procName;
    private String procProjUid;
    private String procProjName;
    private String procAuthor;
    private String procDescription;
    private Date procPlanStartDate;
    private Date procPlanFinishDate;
    private Integer procPlanDur;
    private Integer procState;

    public String getProcUid() {
        return procUid;
    }

    public void setProcUid(String procUid) {
        this.procUid = procUid;
    }

    public String getProcId() {
        return procId;
    }

    public void setProcId(String procId) {
        this.procId = procId;
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName;
    }

    public String getProcProjUid() {
        return procProjUid;
    }

    public void setProcProjUid(String procProjUid) {
        this.procProjUid = procProjUid;
    }

    public String getProcProjName() {
        return procProjName;
    }

    public void setProcProjName(String procProjName) {
        this.procProjName = procProjName;
    }

    public String getProcAuthor() {
        return procAuthor;
    }

    public void setProcAuthor(String procAuthor) {
        this.procAuthor = procAuthor;
    }

    public String getProcDescription() {
        return procDescription;
    }

    public void setProcDescription(String procDescription) {
        this.procDescription = procDescription;
    }

    public Date getProcPlanStartDate() {
        return procPlanStartDate;
    }

    public void setProcPlanStartDate(Date procPlanStartDate) {
        this.procPlanStartDate = procPlanStartDate;
    }

    public Date getProcPlanFinishDate() {
        return procPlanFinishDate;
    }

    public void setProcPlanFinishDate(Date procPlanFinishDate) {
        this.procPlanFinishDate = procPlanFinishDate;
    }

    public Integer getProcPlanDur() {
        return procPlanDur;
    }

    public void setProcPlanDur(Integer procPlanDur) {
        this.procPlanDur = procPlanDur;
    }

    public Integer getProcState() {
        return procState;
    }

    public void setProcState(Integer procState) {
        this.procState = procState;
    }

    @Override
    public String toString() {
        return "Process{" +
                "procUid='" + procUid + '\'' +
                ", procId='" + procId + '\'' +
                ", procName='" + procName + '\'' +
                ", procProjUid='" + procProjUid + '\'' +
                ", procProjName='" + procProjName + '\'' +
                ", procAuthor='" + procAuthor + '\'' +
                ", procDescription='" + procDescription + '\'' +
                ", procPlanStartDate=" + procPlanStartDate +
                ", procPlanFinishDate=" + procPlanFinishDate +
                ", procPlanDur=" + procPlanDur +
                ", procState=" + procState +
                '}';
    }
}
