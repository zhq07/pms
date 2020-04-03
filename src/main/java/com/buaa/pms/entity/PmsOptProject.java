package com.buaa.pms.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class PmsOptProject {

    private String optProjUid;
    private String optProjName;
    private Date optProjStartDate;
    private Date optProjFinishDate;
    private Integer optProjApply;
    private Timestamp optProjCreate;
    private Timestamp optProjApplyTime;

    public String getOptProjUid() {
        return optProjUid;
    }

    public void setOptProjUid(String optProjUid) {
        this.optProjUid = optProjUid;
    }

    public String getOptProjName() {
        return optProjName;
    }

    public void setOptProjName(String optProjName) {
        this.optProjName = optProjName;
    }

    public Date getOptProjStartDate() {
        return optProjStartDate;
    }

    public void setOptProjStartDate(Date optProjStartDate) {
        this.optProjStartDate = optProjStartDate;
    }

    public Date getOptProjFinishDate() {
        return optProjFinishDate;
    }

    public void setOptProjFinishDate(Date optProjFinishDate) {
        this.optProjFinishDate = optProjFinishDate;
    }

    public Integer getOptProjApply() {
        return optProjApply;
    }

    public void setOptProjApply(Integer optProjApply) {
        this.optProjApply = optProjApply;
    }

    public Timestamp getOptProjCreate() {
        return optProjCreate;
    }

    public void setOptProjCreate(Timestamp optProjCreate) {
        this.optProjCreate = optProjCreate;
    }

    public Timestamp getOptProjApplyTime() {
        return optProjApplyTime;
    }

    public void setOptProjApplyTime(Timestamp optProjApplyTime) {
        this.optProjApplyTime = optProjApplyTime;
    }

    @Override
    public String toString() {
        return "PmsOptProject{" +
                "optProjUid='" + optProjUid + '\'' +
                ", optProjName='" + optProjName + '\'' +
                ", optProjStartDate=" + optProjStartDate +
                ", optProjFinishDate=" + optProjFinishDate +
                ", optProjApply=" + optProjApply +
                ", optProjCreate=" + optProjCreate +
                ", optProjApplyTime=" + optProjApplyTime +
                '}';
    }
}
