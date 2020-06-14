package com.buaa.pms.entity;

import java.sql.Timestamp;

public class PmsAllocateEquipment {

    private String aeUid;
    private String aeEquipUid;
    private String aeOrgUid;
    private String aeProjUid;
    private String aeProcUid;
    private String aeTaskUid;
    private String aeResPlanUid;
    private String aeResReqUid;
    private Timestamp aeStartDateTime;
    private Timestamp aeFinishDateTime;
    private Integer aeWorkDur;
    private Integer aeWorkModel;
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

    public Timestamp getAeStartDateTime() {
        return aeStartDateTime;
    }

    public void setAeStartDateTime(Timestamp aeStartDateTime) {
        this.aeStartDateTime = aeStartDateTime;
    }

    public Timestamp getAeFinishDateTime() {
        return aeFinishDateTime;
    }

    public void setAeFinishDateTime(Timestamp aeFinishDateTime) {
        this.aeFinishDateTime = aeFinishDateTime;
    }

    public Integer getAeWorkDur() {
        return aeWorkDur;
    }

    public void setAeWorkDur(Integer aeWorkDur) {
        this.aeWorkDur = aeWorkDur;
    }

    public Integer getAeWorkModel() {
        return aeWorkModel;
    }

    public void setAeWorkModel(Integer aeWorkModel) {
        this.aeWorkModel = aeWorkModel;
    }

    public Integer getAeIsEffective() {
        return aeIsEffective;
    }

    public void setAeIsEffective(Integer aeIsEffective) {
        this.aeIsEffective = aeIsEffective;
    }
}
