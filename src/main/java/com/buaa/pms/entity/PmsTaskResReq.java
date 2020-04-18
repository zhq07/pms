package com.buaa.pms.entity;

public class PmsTaskResReq {

    private String resReqUid;
    private String resReqId;
    private String resReqPlanUid;
    private String resReqTaskUid;
    private String resReqProjUid;
    private String resReqProcUid;
    private Integer resReqResType;
    private String resReqResUid;
    private Integer resReqResWork;
    private Float resReqResAmount;

    public String getResReqUid() {
        return resReqUid;
    }

    public void setResReqUid(String resReqUid) {
        this.resReqUid = resReqUid;
    }

    public String getResReqId() {
        return resReqId;
    }

    public void setResReqId(String resReqId) {
        this.resReqId = resReqId;
    }

    public String getResReqPlanUid() {
        return resReqPlanUid;
    }

    public void setResReqPlanUid(String resReqPlanUid) {
        this.resReqPlanUid = resReqPlanUid;
    }

    public String getResReqTaskUid() {
        return resReqTaskUid;
    }

    public void setResReqTaskUid(String resReqTaskUid) {
        this.resReqTaskUid = resReqTaskUid;
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

    public Integer getResReqResWork() {
        return resReqResWork;
    }

    public void setResReqResWork(Integer resReqResWork) {
        this.resReqResWork = resReqResWork;
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
                ", resReqId='" + resReqId + '\'' +
                ", resReqPlanUid='" + resReqPlanUid + '\'' +
                ", resReqTaskUid='" + resReqTaskUid + '\'' +
                ", resReqProjUid='" + resReqProjUid + '\'' +
                ", resReqProcUid='" + resReqProcUid + '\'' +
                ", resReqResType=" + resReqResType +
                ", resReqResUid='" + resReqResUid + '\'' +
                ", resReqResWork=" + resReqResWork +
                ", resReqResAmount=" + resReqResAmount +
                '}';
    }
}
