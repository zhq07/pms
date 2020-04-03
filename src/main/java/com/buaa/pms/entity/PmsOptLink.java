package com.buaa.pms.entity;

public class PmsOptLink {

    private String optLinkUid;
    private String optLinkOptProjUid;
    private String optLinkProjUid;
    private String optLinkProcUid;

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

    public String getOptLinkProjUid() {
        return optLinkProjUid;
    }

    public void setOptLinkProjUid(String optLinkProjUid) {
        this.optLinkProjUid = optLinkProjUid;
    }

    public String getOptLinkProcUid() {
        return optLinkProcUid;
    }

    public void setOptLinkProcUid(String optLinkProcUid) {
        this.optLinkProcUid = optLinkProcUid;
    }

    @Override
    public String toString() {
        return "PmsOptLink{" +
                "optLinkUid='" + optLinkUid + '\'' +
                ", optLinkOptProjUid='" + optLinkOptProjUid + '\'' +
                ", optLinkProjUid='" + optLinkProjUid + '\'' +
                ", optLinkProcUid='" + optLinkProcUid + '\'' +
                '}';
    }
}
