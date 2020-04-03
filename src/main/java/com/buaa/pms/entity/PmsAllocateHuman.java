package com.buaa.pms.entity;

import java.sql.Date;

public class PmsAllocateHuman {

    private String ahUid;
    private String ahHumUid;
    private String ahOrgUid;
    private String ahProjUid;
    private String ahProcUid;
    private String ahTaskUid;
    private String ahResPlanUid;
    private String ahResReqUid;
    private Date ahStartDate;
    private Date ahFinishDate;
    private Integer ahWorkDur;
    private Integer ahIsEffective;

    public String getAhUid() {
        return ahUid;
    }

    public void setAhUid(String ahUid) {
        this.ahUid = ahUid;
    }

    public String getAhHumUid() {
        return ahHumUid;
    }

    public void setAhHumUid(String ahHumUid) {
        this.ahHumUid = ahHumUid;
    }

    public String getAhOrgUid() {
        return ahOrgUid;
    }

    public void setAhOrgUid(String ahOrgUid) {
        this.ahOrgUid = ahOrgUid;
    }

    public String getAhProjUid() {
        return ahProjUid;
    }

    public void setAhProjUid(String ahProjUid) {
        this.ahProjUid = ahProjUid;
    }

    public String getAhProcUid() {
        return ahProcUid;
    }

    public void setAhProcUid(String ahProcUid) {
        this.ahProcUid = ahProcUid;
    }

    public String getAhTaskUid() {
        return ahTaskUid;
    }

    public void setAhTaskUid(String ahTaskUid) {
        this.ahTaskUid = ahTaskUid;
    }

    public String getAhResPlanUid() {
        return ahResPlanUid;
    }

    public void setAhResPlanUid(String ahResPlanUid) {
        this.ahResPlanUid = ahResPlanUid;
    }

    public String getAhResReqUid() {
        return ahResReqUid;
    }

    public void setAhResReqUid(String ahResReqUid) {
        this.ahResReqUid = ahResReqUid;
    }

    public Date getAhStartDate() {
        return ahStartDate;
    }

    public void setAhStartDate(Date ahStartDate) {
        this.ahStartDate = ahStartDate;
    }

    public Date getAhFinishDate() {
        return ahFinishDate;
    }

    public void setAhFinishDate(Date ahFinishDate) {
        this.ahFinishDate = ahFinishDate;
    }

    public Integer getAhWorkDur() {
        return ahWorkDur;
    }

    public void setAhWorkDur(Integer ahWorkDur) {
        this.ahWorkDur = ahWorkDur;
    }

    public Integer getAhIsEffective() {
        return ahIsEffective;
    }

    public void setAhIsEffective(Integer ahIsEffective) {
        this.ahIsEffective = ahIsEffective;
    }

    @Override
    public String toString() {
        return "PmsAllocateHuman{" +
                "ahUid='" + ahUid + '\'' +
                ", ahHumUid='" + ahHumUid + '\'' +
                ", ahOrgUid='" + ahOrgUid + '\'' +
                ", ahProjUid='" + ahProjUid + '\'' +
                ", ahProcUid='" + ahProcUid + '\'' +
                ", ahTaskUid='" + ahTaskUid + '\'' +
                ", ahResPlanUid='" + ahResPlanUid + '\'' +
                ", ahResReqUid='" + ahResReqUid + '\'' +
                ", ahStartDate=" + ahStartDate +
                ", ahFinishDate=" + ahFinishDate +
                ", ahWorkDur=" + ahWorkDur +
                ", ahIsEffective=" + ahIsEffective +
                '}';
    }
}
