package com.buaa.pms.model;

import java.sql.Date;
import java.util.List;

public class ProjTableItem {

    private String projUid;
    private String projId;
    private String projName;
    private String projTaskUid;
    private String projTaskName;
    private String projParUid;
    private String projParName;
    private String projOrgUid;
    private String projOrgName;
    private String projManager;
    private String projDescription;
    private Date projPlanStartDate;
    private Date projPlanFinishDate;
    private Integer projPlanDur;
    private Date projEarlyStartDate;
    private Date projLateFinishDate;
    private Date projActStartDate;
    private Date projActFinishDate;
    private Integer projActDur;
    private Integer projWork;
    private Integer projCompWork;
    private Integer projRemWork;
    private Float projPctWork;
    private Integer projStatus;

    private List<ProjTableItem> children;

    public String getProjUid() {
        return projUid;
    }

    public void setProjUid(String projUid) {
        this.projUid = projUid;
    }

    public String getProjId() {
        return projId;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getProjTaskUid() {
        return projTaskUid;
    }

    public void setProjTaskUid(String projTaskUid) {
        this.projTaskUid = projTaskUid;
    }

    public String getProjTaskName() {
        return projTaskName;
    }

    public void setProjTaskName(String projTaskName) {
        this.projTaskName = projTaskName;
    }

    public String getProjParUid() {
        return projParUid;
    }

    public void setProjParUid(String projParProjUid) {
        this.projParUid = projParProjUid;
    }

    public String getProjParName() {
        return projParName;
    }

    public void setProjParName(String projParProjName) {
        this.projParName = projParProjName;
    }

    public String getProjOrgUid() {
        return projOrgUid;
    }

    public void setProjOrgUid(String projOrgUid) {
        this.projOrgUid = projOrgUid;
    }

    public String getProjOrgName() {
        return projOrgName;
    }

    public void setProjOrgName(String projOrgName) {
        this.projOrgName = projOrgName;
    }

    public String getProjManager() {
        return projManager;
    }

    public void setProjManager(String projManager) {
        this.projManager = projManager;
    }

    public String getProjDescription() {
        return projDescription;
    }

    public void setProjDescription(String projDescription) {
        this.projDescription = projDescription;
    }

    public Date getProjPlanStartDate() {
        return projPlanStartDate;
    }

    public void setProjPlanStartDate(Date projPlanStartDate) {
        this.projPlanStartDate = projPlanStartDate;
    }

    public Date getProjPlanFinishDate() {
        return projPlanFinishDate;
    }

    public void setProjPlanFinishDate(Date projPlanFinishDate) {
        this.projPlanFinishDate = projPlanFinishDate;
    }

    public Integer getProjPlanDur() {
        return projPlanDur;
    }

    public void setProjPlanDur(Integer projPlanDur) {
        this.projPlanDur = projPlanDur;
    }

    public Date getProjEarlyStartDate() {
        return projEarlyStartDate;
    }

    public void setProjEarlyStartDate(Date projEarlyStartDate) {
        this.projEarlyStartDate = projEarlyStartDate;
    }

    public Date getProjLateFinishDate() {
        return projLateFinishDate;
    }

    public void setProjLateFinishDate(Date projLateFinishDate) {
        this.projLateFinishDate = projLateFinishDate;
    }

    public Date getProjActStartDate() {
        return projActStartDate;
    }

    public void setProjActStartDate(Date projActStartDate) {
        this.projActStartDate = projActStartDate;
    }

    public Date getProjActFinishDate() {
        return projActFinishDate;
    }

    public void setProjActFinishDate(Date projActFinishDate) {
        this.projActFinishDate = projActFinishDate;
    }

    public Integer getProjActDur() {
        return projActDur;
    }

    public void setProjActDur(Integer projActDur) {
        this.projActDur = projActDur;
    }

    public Integer getProjWork() {
        return projWork;
    }

    public void setProjWork(Integer projWork) {
        this.projWork = projWork;
    }

    public Integer getProjCompWork() {
        return projCompWork;
    }

    public void setProjCompWork(Integer projCompWork) {
        this.projCompWork = projCompWork;
    }

    public Integer getProjRemWork() {
        return projRemWork;
    }

    public void setProjRemWork(Integer projRemWork) {
        this.projRemWork = projRemWork;
    }

    public Float getProjPctWork() {
        return projPctWork;
    }

    public void setProjPctWork(Float projPctWork) {
        this.projPctWork = projPctWork;
    }

    public Integer getProjStatus() {
        return projStatus;
    }

    public void setProjStatus(Integer projStatus) {
        this.projStatus = projStatus;
    }

    public List<ProjTableItem> getChildren() {
        return children;
    }

    public void setChildren(List<ProjTableItem> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ProjTableItem{" +
                "projUid='" + projUid + '\'' +
                ", projId='" + projId + '\'' +
                ", projName='" + projName + '\'' +
                ", projTaskUid='" + projTaskUid + '\'' +
                ", projTaskName='" + projTaskName + '\'' +
                ", projParProjUid='" + projParUid + '\'' +
                ", projParProjName='" + projParName + '\'' +
                ", projOrgUid='" + projOrgUid + '\'' +
                ", projOrgName='" + projOrgName + '\'' +
                ", projManager='" + projManager + '\'' +
                ", projDescription='" + projDescription + '\'' +
                ", projPlanStartDate=" + projPlanStartDate +
                ", projPlanFinishDate=" + projPlanFinishDate +
                ", projPlanDur=" + projPlanDur +
                ", projEarlyStartDate=" + projEarlyStartDate +
                ", projLateFinishDate=" + projLateFinishDate +
                ", projActStartDate=" + projActStartDate +
                ", projActFinishDate=" + projActFinishDate +
                ", projActDur=" + projActDur +
                ", projWork=" + projWork +
                ", projCompWork=" + projCompWork +
                ", projRemWork=" + projRemWork +
                ", projPctWork=" + projPctWork +
                ", projStatus=" + projStatus +
                ", children=" + children +
                '}';
    }
}
