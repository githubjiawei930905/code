package com.epeibao.po;

import java.util.Date;

public class Testquestioninformation {
    private String coursewareid;

    private String testquestiondescribe;

    private Double standardindex;

    private Byte questionnumber;

    private Date buildtime;

    private Date revisetime;

    public String getCoursewareid() {
        return coursewareid;
    }

    public void setCoursewareid(String coursewareid) {
        this.coursewareid = coursewareid == null ? null : coursewareid.trim();
    }

    public String getTestquestiondescribe() {
        return testquestiondescribe;
    }

    public void setTestquestiondescribe(String testquestiondescribe) {
        this.testquestiondescribe = testquestiondescribe == null ? null : testquestiondescribe.trim();
    }

    public Double getStandardindex() {
        return standardindex;
    }

    public void setStandardindex(Double standardindex) {
        this.standardindex = standardindex;
    }

    public Byte getQuestionnumber() {
        return questionnumber;
    }

    public void setQuestionnumber(Byte questionnumber) {
        this.questionnumber = questionnumber;
    }

    public Date getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Date buildtime) {
        this.buildtime = buildtime;
    }

    public Date getRevisetime() {
        return revisetime;
    }

    public void setRevisetime(Date revisetime) {
        this.revisetime = revisetime;
    }
}