package com.buaa.pms.entity;

import java.sql.Date;

public class PmsAllocateHuman {

    private String ahUid;
    private String ahHumUid;
    private String ahHumId;
    private String ahHumName;
    private String ahOrgUid;
    private String ahOrgName;
    private String ahProjUid;
    private String ahProjName;
    private String ahProcUid;
    private String ahProcName;
    private String ahTaskUid;
    private String ahTaskName;
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

    public String getAhHumId() {
        return ahHumId;
    }

    public void setAhHumId(String ahHumId) {
        this.ahHumId = ahHumId;
    }

    public String getAhHumName() {
        return ahHumName;
    }

    public void setAhHumName(String ahHumName) {
        this.ahHumName = ahHumName;
    }

    public String getAhOrgUid() {
        return ahOrgUid;
    }

    public void setAhOrgUid(String ahOrgUid) {
        this.ahOrgUid = ahOrgUid;
    }

    public String getAhOrgName() {
        return ahOrgName;
    }

    public void setAhOrgName(String ahOrgName) {
        this.ahOrgName = ahOrgName;
    }

    public String getAhProjUid() {
        return ahProjUid;
    }

    public void setAhProjUid(String ahProjUid) {
        this.ahProjUid = ahProjUid;
    }

    public String getAhProjName() {
        return ahProjName;
    }

    public void setAhProjName(String ahProjName) {
        this.ahProjName = ahProjName;
    }

    public String getAhProcUid() {
        return ahProcUid;
    }

    public void setAhProcUid(String ahProcUid) {
        this.ahProcUid = ahProcUid;
    }

    public String getAhProcName() {
        return ahProcName;
    }

    public void setAhProcName(String ahProcName) {
        this.ahProcName = ahProcName;
    }

    public String getAhTaskUid() {
        return ahTaskUid;
    }

    public void setAhTaskUid(String ahTaskUid) {
        this.ahTaskUid = ahTaskUid;
    }

    public String getAhTaskName() {
        return ahTaskName;
    }

    public void setAhTaskName(String ahTaskName) {
        this.ahTaskName = ahTaskName;
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
                ", ahHumId='" + ahHumId + '\'' +
                ", ahHumName='" + ahHumName + '\'' +
                ", ahOrgUid='" + ahOrgUid + '\'' +
                ", ahOrgName='" + ahOrgName + '\'' +
                ", ahProjUid='" + ahProjUid + '\'' +
                ", ahProjName='" + ahProjName + '\'' +
                ", ahProcUid='" + ahProcUid + '\'' +
                ", ahProcName='" + ahProcName + '\'' +
                ", ahTaskUid='" + ahTaskUid + '\'' +
                ", ahTaskName='" + ahTaskName + '\'' +
                ", ahResPlanUid='" + ahResPlanUid + '\'' +
                ", ahResReqUid='" + ahResReqUid + '\'' +
                ", ahStartDate=" + ahStartDate +
                ", ahFinishDate=" + ahFinishDate +
                ", ahWorkDur=" + ahWorkDur +
                ", ahIsEffective=" + ahIsEffective +
                '}';
    }
}
