package com.buaa.pms.entity;

import java.sql.Date;

public class PmsAllocateEquipment {

    private String aeUid;
    private String aeEquipUid;
    private String aeOrgUid;
    private String aeProjUid;
    private String aeProcUid;
    private String aeTaskUid;
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

    public String getAeOrgUid() {
        return aeOrgUid;
    }

    public void setAeOrgUid(String aeOrgUid) {
        this.aeOrgUid = aeOrgUid;
    }

    public String getAeProjUid() {
        return aeProjUid;
    }

    public void setAeProjUid(String aeProjUid) {
        this.aeProjUid = aeProjUid;
    }

    public String getAeProcUid() {
        return aeProcUid;
    }

    public void setAeProcUid(String aeProcUid) {
        this.aeProcUid = aeProcUid;
    }

    public String getAeTaskUid() {
        return aeTaskUid;
    }

    public void setAeTaskUid(String aeTaskUid) {
        this.aeTaskUid = aeTaskUid;
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
                ", aeOrgUid='" + aeOrgUid + '\'' +
                ", aeProjUid='" + aeProjUid + '\'' +
                ", aeProcUid='" + aeProcUid + '\'' +
                ", aeTaskUid='" + aeTaskUid + '\'' +
                ", aeResPlanUid='" + aeResPlanUid + '\'' +
                ", aeResReqUid='" + aeResReqUid + '\'' +
                ", aeStartDate=" + aeStartDate +
                ", aeFinishDate=" + aeFinishDate +
                ", aeWorkDur=" + aeWorkDur +
                ", aeIsEffective=" + aeIsEffective +
                '}';
    }
}
