package com.juli.elutong.po;

import java.util.Date;

public class Feedback {
    private String feedbackid;

    private String userid;

    private String contentinfo;

    private Date createtime;

    public String getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(String feedbackid) {
        this.feedbackid = feedbackid == null ? null : feedbackid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getContentinfo() {
        return contentinfo;
    }

    public void setContentinfo(String contentinfo) {
        this.contentinfo = contentinfo == null ? null : contentinfo.trim();
    }

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


}