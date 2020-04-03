package com.buaa.pms.model;

public class PmsTaskResReq {

    private String resReqUid;
    private String resReqPlanUid;
    private String resReqProjUid;
    private String resReqProcUid;
    private String resReqTaskUid;
    private Integer resReqResType;
    private String resReqResUid;
    private String resReqResId;
    private String resReqResName;
    private Float resReqResAmount;

    public String getResReqUid() {
        return resReqUid;
    }

    public void setResReqUid(String resReqUid) {
        this.resReqUid = resReqUid;
    }

    public String getResReqPlanUid() {
        return resReqPlanUid;
    }

    public void setResReqPlanUid(String resReqPlanUid) {
        this.resReqPlanUid = resReqPlanUid;
    }

    public String getResReqProjUid() {
        return resReqProjUid;
    }

    public void setResReqProjUid(String resReqProjUid) {
        this.resReqProjUid = resReqProjUid;
    }

    public String getResReqProcUid() {
        return resReqProcUid;
    }

    public void setResReqProcUid(String resReqProcUid) {
        this.resReqProcUid = resReqProcUid;
    }

    public String getResReqTaskUid() {
        return resReqTaskUid;
    }

    public void setResReqTaskUid(String resReqTaskUid) {
        this.resReqTaskUid = resReqTaskUid;
    }

    public Integer getResReqResType() {
        return resReqResType;
    }

    public void setResReqResType(Integer resReqResType) {
        this.resReqResType = resReqResType;
    }

    public String getResReqResUid() {
        return resReqResUid;
    }

    public void setResReqResUid(String resReqResUid) {
        this.resReqResUid = resReqResUid;
    }

    public String getResReqResId() {
        return resReqResId;
    }

    public void setResReqResId(String resReqResId) {
        this.resReqResId = resReqResId;
    }

    public String getResReqResName() {
        return resReqResName;
    }

    public void setResReqResName(String resReqResName) {
        this.resReqResName = resReqResName;
    }

    public Float getResReqResAmount() {
        return resReqResAmount;
    }

    public void setResReqResAmount(Float resReqResAmount) {
        this.resReqResAmount = resReqResAmount;
    }

    @Override
    public String toString() {
        return "PmsTaskResReq{" +
                "resReqUid='" + resReqUid + '\'' +
                ", resReqPlanUid='" + resReqPlanUid + '\'' +
                ", resReqProjUid='" + resReqProjUid + '\'' +
                ", resReqProcUid='" + resReqProcUid + '\'' +
                ", resReqTaskUid='" + resReqTaskUid + '\'' +
                ", resReqResType=" + resReqResType +
                ", resReqResUid='" + resReqResUid + '\'' +
                ", resReqResId='" + resReqResId + '\'' +
                ", resReqResName='" + resReqResName + '\'' +
                ", resReqResAmount=" + resReqResAmount +
                '}';
    }
}
