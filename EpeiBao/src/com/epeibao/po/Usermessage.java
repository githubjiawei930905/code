package com.epeibao.po;

import java.io.Serializable;
import java.util.Date;

public class Usermessage implements Serializable{
	//�û�id
    private String userid;
    //��֯id
    private String organizationid;
    //��¼�˺�
    private String loginid;
    //��¼����
    private String loginpassword;
    //�û�����
    private String username;
    //�ֻ���
    private String phonenumber;
    //uuid
    private String uuid;
    //��¼ʱ��
    private Date logintime;
    //�ϴε�¼ʱ��
    private Date lastlogintime;
    //��¼����ʱ��
    private Date logexpiredtime;
    //Token
    private String token;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(String organizationid) {
        this.organizationid = organizationid == null ? null : organizationid.trim();
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid == null ? null : loginid.trim();
    }

    public String getLoginpassword() {
        return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword == null ? null : loginpassword.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Date getLogexpiredtime() {
        return logexpiredtime;
    }

    public void setLogexpiredtime(Date logexpiredtime) {
        this.logexpiredtime = logexpiredtime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}