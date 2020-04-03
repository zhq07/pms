package com.buaa.pms.model;

import java.sql.Date;

public class PmsAllocatePlace {

    private String apUid;
    private String apPlaceUid;
    private String apPlaceId;
    private String apPlaceName;
    private String apOrgUid;
    private String apOrgName;
    private String apProjUid;
    private String apProjName;
    private String apProcUid;
    private String apProcName;
    private String apTaskUid;
    private String apTaskName;
    private String apResPlanUid;
    private String apResReqUid;
    private Date apStartDate;
    private Date apFinishDate;
    private Float apReqAmount;
    private Integer apWorkDur;
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

    public String getApPlaceId() {
        return apPlaceId;
    }

    public void setApPlaceId(String apPlaceId) {
        this.apPlaceId = apPlaceId;
    }

    public String getApPlaceName() {
        return apPlaceName;
    }

    public void setApPlaceName(String apPlaceName) {
        this.apPlaceName = apPlaceName;
    }

    public String getApOrgUid() {
        return apOrgUid;
    }

    public void setApOrgUid(String apOrgUid) {
        this.apOrgUid = apOrgUid;
    }

    public String getApOrgName() {
        return apOrgName;
    }

    public void setApOrgName(String apOrgName) {
        this.apOrgName = apOrgName;
    }

    public String getApProjUid() {
        return apProjUid;
    }

    public void setApProjUid(String apProjUid) {
        this.apProjUid = apProjUid;
    }

    public String getApProjName() {
        return apProjName;
    }

    public void setApProjName(String apProjName) {
        this.apProjName = apProjName;
    }

    public String getApProcUid() {
        return apProcUid;
    }

    public void setApProcUid(String apProcUid) {
        this.apProcUid = apProcUid;
    }

    public String getApProcName() {
        return apProcName;
    }

    public void setApProcName(String apProcName) {
        this.apProcName = apProcName;
    }

    public String getApTaskUid() {
        return apTaskUid;
    }

    public void setApTaskUid(String apTaskUid) {
        this.apTaskUid = apTaskUid;
    }

    public String getApTaskName() {
        return apTaskName;
    }

    public void setApTaskName(String apTaskName) {
        this.apTaskName = apTaskName;
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

    public Date getApStartDate() {
        return apStartDate;
    }

    public void setApStartDate(Date apStartDate) {
        this.apStartDate = apStartDate;
    }

    public Date getApFinishDate() {
        return apFinishDate;
    }

    public void setApFinishDate(Date apFinishDate) {
        this.apFinishDate = apFinishDate;
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

    public Integer getApIsEffective() {
        return apIsEffective;
    }

    public void setApIsEffective(Integer apIsEffective) {
        this.apIsEffective = apIsEffective;
    }

    @Override
    public String toString() {
        return "PmsAllocatePlace{" +
                "apUid='" + apUid + '\'' +
                ", apPlaceUid='" + apPlaceUid + '\'' +
                ", apPlaceId='" + apPlaceId + '\'' +
                ", apPlaceName='" + apPlaceName + '\'' +
                ", apOrgUid='" + apOrgUid + '\'' +
                ", apOrgName='" + apOrgName + '\'' +
                ", apProjUid='" + apProjUid + '\'' +
                ", apProjName='" + apProjName + '\'' +
                ", apProcUid='" + apProcUid + '\'' +
                ", apProcName='" + apProcName + '\'' +
                ", apTaskUid='" + apTaskUid + '\'' +
                ", apTaskName='" + apTaskName + '\'' +
                ", apResPlanUid='" + apResPlanUid + '\'' +
                ", apResReqUid='" + apResReqUid + '\'' +
                ", apStartDate=" + apStartDate +
                ", apFinishDate=" + apFinishDate +
                ", apReqAmount=" + apReqAmount +
                ", apWorkDur=" + apWorkDur +
                ", apIsEffective=" + apIsEffective +
                '}';
    }
}
