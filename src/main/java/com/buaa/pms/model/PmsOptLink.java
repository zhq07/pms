package com.buaa.pms.model;

public class PmsOptLink {

    private String optLinkUid;
    private String optLinkOptProjUid;
    private String optLinkOptProjName;
    private String optLinkProjUid;
    private String optLinkProjName;
    private String optLinkProcUid;
    private String optLinkProcName;

    public String getOptLinkUid() {
        return optLinkUid;
    }

    public void setOptLinkUid(String optLinkUid) {
        this.optLinkUid = optLinkUid;
    }

    public String getOptLinkOptProjUid() {
        return optLinkOptProjUid;
    }

    public void setOptLinkOptProjUid(String optLinkOptProjUid) {
        this.optLinkOptProjUid = optLinkOptProjUid;
    }

    public String getOptLinkOptProjName() {
        return optLinkOptProjName;
    }

    public void setOptLinkOptProjName(String optLinkOptProjName) {
        this.optLinkOptProjName = optLinkOptProjName;
    }

    public String getOptLinkProjUid() {
        return optLinkProjUid;
    }

    public void setOptLinkProjUid(String optLinkProjUid) {
        this.optLinkProjUid = optLinkProjUid;
    }

    public String getOptLinkProjName() {
        return optLinkProjName;
    }

    public void setOptLinkProjName(String optLinkProjName) {
        this.optLinkProjName = optLinkProjName;
    }

    public String getOptLinkProcUid() {
        return optLinkProcUid;
    }

    public void setOptLinkProcUid(String optLinkProcUid) {
        this.optLinkProcUid = optLinkProcUid;
    }

    public String getOptLinkProcName() {
        return optLinkProcName;
    }

    public void setOptLinkProcName(String optLinkProcName) {
        this.optLinkProcName = optLinkProcName;
    }

    @Override
    public String toString() {
        return "OptLink{" +
                "optLinkUid='" + optLinkUid + '\'' +
                ", optLinkOptProjUid='" + optLinkOptProjUid + '\'' +
                ", optLinkOptProjName='" + optLinkOptProjName + '\'' +
                ", optLinkProjUid='" + optLinkProjUid + '\'' +
                ", optLinkProjName='" + optLinkProjName + '\'' +
                ", optLinkProcUid='" + optLinkProcUid + '\'' +
                ", optLinkProcName='" + optLinkProcName + '\'' +
                '}';
    }
}
