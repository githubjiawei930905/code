package com.epeibao.po;

/**
 * 组织信息实体类
 * @author Admin
 *
 */
public class OrganizationMessage {
	
	private String organizationID;//组织id
	
	private String parentOrganizationID;//父组织id
	
	private String organizationName;// 组织名称
	
	private int organizationLevel;//组织级别
	
	private String officerNumber;//单位立户号
	
	private String servicePhoneNumber; // 服务电话
	
	private String ownerID;//业主编号
	
	private String phototypeRule;//公司对应的照片规则
	
    private String questionsprojectid; // 培训规则
	
	public String getOrganizationID() {
		return organizationID;
	}
	public void setOrganizationID(String organizationID) {
		this.organizationID = organizationID;
	}
	public String getParentOrganizationID() {
		return parentOrganizationID;
	}
	public void setParentOrganizationID(String parentOrganizationID) {
		this.parentOrganizationID = parentOrganizationID;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public int getOrganizationLevel() {
		return organizationLevel;
	}
	public void setOrganizationLevel(int organizationLevel) {
		this.organizationLevel = organizationLevel;
	}
	public String getOfficerNumber() {
		return officerNumber;
	}
	public void setOfficerNumber(String officerNumber) {
		this.officerNumber = officerNumber;
	}
	public String getServicePhoneNumber() {
		return servicePhoneNumber;
	}
	public void setServicePhoneNumber(String servicePhoneNumber) {
		this.servicePhoneNumber = servicePhoneNumber;
	}
	public String getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}
	public String getPhototypeRule() {
		return phototypeRule;
	}
	public void setPhototypeRule(String phototypeRule) {
		this.phototypeRule = phototypeRule;
	}
	
	 public String getQuestionsprojectid() {
	        return questionsprojectid;
	    }

	    public void setQuestionsprojectid(String questionsprojectid) {
	        this.questionsprojectid = questionsprojectid == null ? null : questionsprojectid.trim();
	    }

}
