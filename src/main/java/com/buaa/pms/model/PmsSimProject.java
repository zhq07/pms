package com.buaa.pms.model;

import java.sql.Date;

public class PmsSimProject {

    private String simProjUid;
    private String simProjName;
    private String simProjProjUid;
    private String simProjProjName;
    private String simProjProcUid;
    private String simProjProcName;
    private Date simProjEarlyStartDate;
    private Date simProjLatefinishDate;
    private Date simProjStartDate;
    private Date simProjFinishDate;
    private Integer simProjDur;
    private Integer simProjMode;
    private Date simProjCreate;

    public String getSimProjUid() {
        return simProjUid;
    }

    public void setSimProjUid(String simProjUid) {
        this.simProjUid = simProjUid;
    }

    public String getSimProjName() {
        return simProjName;
    }

    public void setSimProjName(String simProjName) {
        this.simProjName = simProjName;
    }

    public String getSimProjProjUid() {
        return simProjProjUid;
    }

    public void setSimProjProjUid(String simProjProjUid) {
        this.simProjProjUid = simProjProjUid;
    }

    public String getSimProjProjName() {
        return simProjProjName;
    }

    public void setSimProjProjName(String simProjProjName) {
        this.simProjProjName = simProjProjName;
    }

    public String getSimProjProcUid() {
        return simProjProcUid;
    }

    public void setSimProjProcUid(String simProjProcUid) {
        this.simProjProcUid = simProjProcUid;
    }

    public String getSimProjProcName() {
        return simProjProcName;
    }

    public void setSimProjProcName(String simProjProcName) {
        this.simProjProcName = simProjProcName;
    }

    public Date getSimProjEarlyStartDate() {
        return simProjEarlyStartDate;
    }

    public void setSimProjEarlyStartDate(Date simProjEarlyStartDate) {
        this.simProjEarlyStartDate = simProjEarlyStartDate;
    }

    public Date getSimProjLatefinishDate() {
        return simProjLatefinishDate;
    }

    public void setSimProjLatefinishDate(Date simProjLatefinishDate) {
        this.simProjLatefinishDate = simProjLatefinishDate;
    }

    public Date getSimProjStartDate() {
        return simProjStartDate;
    }

    public void setSimProjStartDate(Date simProjStartDate) {
        this.simProjStartDate = simProjStartDate;
    }

    public Date getSimProjFinishDate() {
        return simProjFinishDate;
    }

    public void setSimProjFinishDate(Date simProjFinishDate) {
        this.simProjFinishDate = simProjFinishDate;
    }

    public Integer getSimProjDur() {
        return simProjDur;
    }

    public void setSimProjDur(Integer simProjDur) {
        this.simProjDur = simProjDur;
    }

    public Integer getSimProjMode() {
        return simProjMode;
    }

    public void setSimProjMode(Integer simProjMode) {
        this.simProjMode = simProjMode;
    }

    public Date getSimProjCreate() {
        return simProjCreate;
    }

    public void setSimProjCreate(Date simProjCreate) {
        this.simProjCreate = simProjCreate;
    }

    @Override
    public String toString() {
        return "PmsSimProj{" +
                "simProjUid='" + simProjUid + '\'' +
                ", simProjName='" + simProjName + '\'' +
                ", simProjProjUid='" + simProjProjUid + '\'' +
                ", simProjProjName='" + simProjProjName + '\'' +
                ", simProjProcUid='" + simProjProcUid + '\'' +
                ", simProjProcName='" + simProjProcName + '\'' +
                ", simProjEarlyStartDate=" + simProjEarlyStartDate +
                ", simProjLatefinishDate=" + simProjLatefinishDate +
                ", simProjStartDate=" + simProjStartDate +
                ", simProjFinishDate=" + simProjFinishDate +
                ", simProjDur=" + simProjDur +
                ", simProjMode=" + simProjMode +
                ", simProjCreate=" + simProjCreate +
                '}';
    }
}
