package com.epeibao.po;

import java.util.Date;

public class Commentprocess {
    private String commentprocessid;

    private String userid;

    private String commentid;

    private Byte operatetype;

    private Date commentprocesstime;

    public String getCommentprocessid() {
        return commentprocessid;
    }

    public void setCommentprocessid(String commentprocessid) {
        this.commentprocessid = commentprocessid == null ? null : commentprocessid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid == null ? null : commentid.trim();
    }

    public Byte getOperatetype() {
        return operatetype;
    }

    public void setOperatetype(Byte operatetype) {
        this.operatetype = operatetype;
    }

    public Date getCommentprocesstime() {
        return commentprocesstime;
    }

    public void setCommentprocesstime(Date commentprocesstime) {
        this.commentprocesstime = commentprocesstime;
    }
}