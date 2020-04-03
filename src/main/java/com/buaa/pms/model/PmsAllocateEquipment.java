package com.buaa.pms.model;

import java.sql.Date;

public class PmsAllocateEquipment {

    private String aeUid;
    private String aeEquipUid;
    private String aeEquipId;
    private String aeEquipName;
    private String aeOrgUid;
    private String aeOrgName;
    private String aeProjUid;
    private String aeProjName;
    private String aeProcUid;
    private String aeProcName;
    private String aeTaskUid;
    private String aeTaskName;
    private String aeResPlanUid;
    private String aeResReqUid;
    private Date aeStartDate;
    private Date aeFinishDate;
    private Integer aeWorkDur;
    private Integer aeIsEffective;

    public String getAeUid() {
        return aeUid;
    }

    public void setAeUid(String aeUid) {
        this.aeUid = aeUid;
    }

    public String getAeEquipUid() {
        return aeEquipUid;
    }

    public void setAeEquipUid(String aeEquipUid) {
        this.aeEquipUid = aeEquipUid;
    }

    public String getAeEquipId() {
        return aeEquipId;
    }

    public void setAeEquipId(String aeEquipId) {
        this.aeEquipId = aeEquipId;
    }

    public String getAeEquipName() {
        return aeEquipName;
    }

    public void setAeEquipName(String aeEquipName) {
        this.aeEquipName = aeEquipName;
    }

    public String getAeOrgUid() {
        return aeOrgUid;
    }

    public void setAeOrgUid(String aeOrgUid) {
        this.aeOrgUid = aeOrgUid;
    }

    public String getAeOrgName() {
        return aeOrgName;
    }

    public void setAeOrgName(String aeOrgName) {
        this.aeOrgName = aeOrgName;
    }

    public String getAeProjUid() {
        return aeProjUid;
    }

    public void setAeProjUid(String aeProjUid) {
        this.aeProjUid = aeProjUid;
    }

    public String getAeProjName() {
        return aeProjName;
    }

    public void setAeProjName(String aeProjName) {
        this.aeProjName = aeProjName;
    }

    public String getAeProcUid() {
        return aeProcUid;
    }

    public void setAeProcUid(String aeProcUid) {
        this.aeProcUid = aeProcUid;
    }

    public String getAeProcName() {
        return aeProcName;
    }

    public void setAeProcName(String aeProcName) {
        this.aeProcName = aeProcName;
    }

    public String getAeTaskUid() {
        return aeTaskUid;
    }

    public void setAeTaskUid(String aeTaskUid) {
        this.aeTaskUid = aeTaskUid;
    }

    public String getAeTaskName() {
        return aeTaskName;
    }

    public void setAeTaskName(String aeTaskName) {
        this.aeTaskName = aeTaskName;
    }

    public String getAeResPlanUid() {
        return aeResPlanUid;
    }

    public void setAeResPlanUid(String aeResPlanUid) {
        this.aeResPlanUid = aeResPlanUid;
    }

    public String getAeResReqUid() {
        return aeResReqUid;
    }

    public void setAeResReqUid(String aeResReqUid) {
        this.aeResReqUid = aeResReqUid;
    }

    public Date getAeStartDate() {
        return aeStartDate;
    }

    public void setAeStartDate(Date aeStartDate) {
        this.aeStartDate = aeStartDate;
    }

    public Date getAeFinishDate() {
        return aeFinishDate;
    }

    public void setAeFinishDate(Date aeFinishDate) {
        this.aeFinishDate = aeFinishDate;
    }

    public Integer getAeWorkDur() {
        return aeWorkDur;
    }

    public void setAeWorkDur(Integer aeWorkDur) {
        this.aeWorkDur = aeWorkDur;
    }

    public Integer getAeIsEffective() {
        return aeIsEffective;
    }

    public void setAeIsEffective(Integer aeIsEffective) {
        this.aeIsEffective = aeIsEffective;
    }

    @Override
    public String toString() {
        return "PmsAllocateEquipment{" +
                "aeUid='" + aeUid + '\'' +
                ", aeEquipUid='" + aeEquipUid + '\'' +
                ", aeEquipId='" + aeEquipId + '\'' +
                ", aeEquipName='" + aeEquipName + '\'' +
                ", aeOrgUid='" + aeOrgUid + '\'' +
                ", aeOrgName='" + aeOrgName + '\'' +
                ", aeProjUid='" + aeProjUid + '\'' +
                ", aeProjName='" + aeProjName + '\'' +
                ", aeProcUid='" + aeProcUid + '\'' +
                ", aeProcName='" + aeProcName + '\'' +
                ", aeTaskUid='" + aeTaskUid + '\'' +
                ", aeTaskName='" + aeTaskName + '\'' +
                ", aeResPlanUid='" + aeResPlanUid + '\'' +
                ", aeResReqUid='" + aeResReqUid + '\'' +
                ", aeStartDate=" + aeStartDate +
                ", aeFinishDate=" + aeFinishDate +
                ", aeWorkDur=" + aeWorkDur +
                ", aeIsEffective=" + aeIsEffective +
                '}';
    }
}
