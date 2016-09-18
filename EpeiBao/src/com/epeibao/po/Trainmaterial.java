package com.epeibao.po;

public class Trainmaterial {
    private String trainmaterialid;

    private String organizationid;

    private String commonalitycoursewareid;

    private String companycoursewareid;

    public String getTrainmaterialid() {
        return trainmaterialid;
    }

    public void setTrainmaterialid(String trainmaterialid) {
        this.trainmaterialid = trainmaterialid == null ? null : trainmaterialid.trim();
    }

    public String getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(String organizationid) {
        this.organizationid = organizationid == null ? null : organizationid.trim();
    }

    public String getCommonalitycoursewareid() {
        return commonalitycoursewareid;
    }

    public void setCommonalitycoursewareid(String commonalitycoursewareid) {
        this.commonalitycoursewareid = commonalitycoursewareid == null ? null : commonalitycoursewareid.trim();
    }

    public String getCompanycoursewareid() {
        return companycoursewareid;
    }

    public void setCompanycoursewareid(String companycoursewareid) {
        this.companycoursewareid = companycoursewareid == null ? null : companycoursewareid.trim();
    }
}