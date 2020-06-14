package com.buaa.pms.entity;

import java.sql.Timestamp;

public class PmsAllocateHuman {

    private String ahUid;
    private String ahHumUid;
    private String ahOrgUid;
    private String ahProjUid;
    private String ahProcUid;
    private String ahTaskUid;
    private String ahResPlanUid;
    private String ahResReqUid;
    private Timestamp ahStartDateTime;
    private Timestamp ahFinishDateTime;
    private Integer ahWorkDur;
    private Integer ahWorkModel;
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

    public Timestamp getAhStartDateTime() {
        return ahStartDateTime;
    }

    public void setAhStartDateTime(Timestamp ahStartDateTime) {
        this.ahStartDateTime = ahStartDateTime;
    }

    public Timestamp getAhFinishDateTime() {
        return ahFinishDateTime;
    }

    public void setAhFinishDateTime(Timestamp ahFinishDateTime) {
        this.ahFinishDateTime = ahFinishDateTime;
    }

    public Integer getAhWorkDur() {
        return ahWorkDur;
    }

    public void setAhWorkDur(Integer ahWorkDur) {
        this.ahWorkDur = ahWorkDur;
    }

    public Integer getAhWorkModel() {
        return ahWorkModel;
    }

    public void setAhWorkModel(Integer ahWorkModel) {
        this.ahWorkModel = ahWorkModel;
    }

    public Integer getAhIsEffective() {
        return ahIsEffective;
    }

    public void setAhIsEffective(Integer ahIsEffective) {
        this.ahIsEffective = ahIsEffective;
    }
}
