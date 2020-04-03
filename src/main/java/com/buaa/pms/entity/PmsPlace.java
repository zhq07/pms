package com.buaa.pms.entity;

public class PmsPlace {

    private String placeUid;
    private String placeId;
    private String placeName;
    private String placeOrgUid;
    private String placeOrgName;
    private Float placeArea;
    private String placeDesc;
    private Float placeUsage;
    private Integer placeStatus;
    private String placeCurrTaskUid;
    private String placeCurrTaskName;

    public String getPlaceUid() {
        return placeUid;
    }

    public void setPlaceUid(String placeUid) {
        this.placeUid = placeUid;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceOrgUid() {
        return placeOrgUid;
    }

    public void setPlaceOrgUid(String placeOrgUid) {
        this.placeOrgUid = placeOrgUid;
    }

    public String getPlaceOrgName() {
        return placeOrgName;
    }

    public void setPlaceOrgName(String placeOrgName) {
        this.placeOrgName = placeOrgName;
    }

    public Float getPlaceArea() {
        return placeArea;
    }

    public void setPlaceArea(Float placeArea) {
        this.placeArea = placeArea;
    }

    public String getPlaceDesc() {
        return placeDesc;
    }

    public void setPlaceDesc(String placeDesc) {
        this.placeDesc = placeDesc;
    }

    public Float getPlaceUsage() {
        return placeUsage;
    }

    public void setPlaceUsage(Float placeUsage) {
        this.placeUsage = placeUsage;
    }

    public Integer getPlaceStatus() {
        return placeStatus;
    }

    public void setPlaceStatus(Integer placeStatus) {
        this.placeStatus = placeStatus;
    }

    public String getPlaceCurrTaskUid() {
        return placeCurrTaskUid;
    }

    public void setPlaceCurrTaskUid(String placeCurrTaskUid) {
        this.placeCurrTaskUid = placeCurrTaskUid;
    }

    public String getPlaceCurrTaskName() {
        return placeCurrTaskName;
    }

    public void setPlaceCurrTaskName(String placeCurrTaskName) {
        this.placeCurrTaskName = placeCurrTaskName;
    }

    @Override
    public String toString() {
        return "PmsPlace{" +
                "placeUid='" + placeUid + '\'' +
                ", placeId='" + placeId + '\'' +
                ", placeName='" + placeName + '\'' +
                ", placeOrgUid='" + placeOrgUid + '\'' +
                ", placeOrgName='" + placeOrgName + '\'' +
                ", placeArea=" + placeArea +
                ", placeDesc='" + placeDesc + '\'' +
                ", placeUsage=" + placeUsage +
                ", placeStatus=" + placeStatus +
                ", placeCurrTaskUid='" + placeCurrTaskUid + '\'' +
                ", placeCurrTaskName='" + placeCurrTaskName + '\'' +
                '}';
    }
}
