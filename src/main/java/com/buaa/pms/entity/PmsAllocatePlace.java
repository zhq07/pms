package com.buaa.pms.entity;

import java.sql.Timestamp;

public class PmsAllocatePlace {

    private String apUid;
    private String apPlaceUid;
    private String apOrgUid;
    private String apProjUid;
    private String apProcUid;
    private String apTaskUid;
    private String apResPlanUid;
    private String apResReqUid;
    private Timestamp apStartDateTime;
    private Timestamp apFinishDateTime;
    private Float apReqAmount;
    private Integer apWorkDur;
    private Integer apWorkModel;
    private Integer apIsEffective;

    public String getApUid() {
        return apUid;
    }

    public void setApUid(String apUid) {
        this.apUid = apUid;
    }

    public String getApPlaceUid() {
        return apPlaceUid;
    }

    public void setApPlaceUid(String apPlaceUid) {
        this.apPlaceUid = apPlaceUid;
    }

    public String getApOrgUid() {
        return apOrgUid;
    }

    public void setApOrgUid(String apOrgUid) {
        this.apOrgUid = apOrgUid;
    }

    public String getApProjUid() {
        return apProjUid;
    }

    public void setApProjUid(String apProjUid) {
        this.apProjUid = apProjUid;
    }

    public String getApProcUid() {
        return apProcUid;
    }

    public void setApProcUid(String apProcUid) {
        this.apProcUid = apProcUid;
    }

    public String getApTaskUid() {
        return apTaskUid;
    }

    public void setApTaskUid(String apTaskUid) {
        this.apTaskUid = apTaskUid;
    }

    public String getApResPlanUid() {
        return apResPlanUid;
    }

    public void setApResPlanUid(String apResPlanUid) {
        this.apResPlanUid = apResPlanUid;
    }

    public String getApResReqUid() {
        return apResReqUid;
    }

    public void setApResReqUid(String apResReqUid) {
        this.apResReqUid = apResReqUid;
    }

    public Timestamp getApStartDateTime() {
        return apStartDateTime;
    }

    public void setApStartDateTime(Timestamp apStartDateTime) {
        this.apStartDateTime = apStartDateTime;
    }

    public Timestamp getApFinishDateTime() {
        return apFinishDateTime;
    }

    public void setApFinishDateTime(Timestamp apFinishDateTime) {
        this.apFinishDateTime = apFinishDateTime;
    }

    public Float getApReqAmount() {
        return apReqAmount;
    }

    public void setApReqAmount(Float apReqAmount) {
        this.apReqAmount = apReqAmount;
    }

    public Integer getApWorkDur() {
        return apWorkDur;
    }

    public void setApWorkDur(Integer apWorkDur) {
        this.apWorkDur = apWorkDur;
    }

    public Integer getApWorkModel() {
        return apWorkModel;
    }

    public void setApWorkModel(Integer apWorkModel) {
        this.apWorkModel = apWorkModel;
    }

    public Integer getApIsEffective() {
        return apIsEffective;
    }

    public void setApIsEffective(Integer apIsEffective) {
        this.apIsEffective = apIsEffective;
    }
}
