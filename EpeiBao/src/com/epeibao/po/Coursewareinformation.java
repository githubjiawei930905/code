package com.epeibao.po;

import java.util.Date;

public class Coursewareinformation {
    private String coursewareid;

    private String testquestionid;

    private String userid;

    private String coursewarename;

    private String coursewaretype;

    private String coursewarepath;

    private String abstractinfo;

    private Date buildtime;

    private Date revisetime;

    private String noteinfo;

    public String getCoursewareid() {
        return coursewareid;
    }

    public void setCoursewareid(String coursewareid) {
        this.coursewareid = coursewareid == null ? null : coursewareid.trim();
    }

    public String getTestquestionid() {
        return testquestionid;
    }

    public void setTestquestionid(String testquestionid) {
        this.testquestionid = testquestionid == null ? null : testquestionid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getCoursewarename() {
        return coursewarename;
    }

    public void setCoursewarename(String coursewarename) {
        this.coursewarename = coursewarename == null ? null : coursewarename.trim();
    }

    public String getCoursewaretype() {
        return coursewaretype;
    }

    public void setCoursewaretype(String coursewaretype) {
        this.coursewaretype = coursewaretype == null ? null : coursewaretype.trim();
    }

    public String getCoursewarepath() {
        return coursewarepath;
    }

    public void setCoursewarepath(String coursewarepath) {
        this.coursewarepath = coursewarepath == null ? null : coursewarepath.trim();
    }

    public String getAbstractinfo() {
        return abstractinfo;
    }

    public void setAbstractinfo(String abstractinfo) {
        this.abstractinfo = abstractinfo == null ? null : abstractinfo.trim();
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

    public String getNoteinfo() {
        return noteinfo;
    }

    public void setNoteinfo(String noteinfo) {
        this.noteinfo = noteinfo == null ? null : noteinfo.trim();
    }
}