package com.epeibao.po;

/**
 * 综合评测实体类
 * 
 * @author Admin
 * 
 */
public class ComprehensiveAssessment {

	private String comprehensiveAssessmentID; // 综合测评ID=司机ID+审阅时间+审阅批次
	private String driverID; // 司机ID（监督卡号）
	private String taximeterDeadline; // 计价器截止时间
	private String nextBackToCompanyTime; // 下次会公司时间
	private int ifVehicleMaintenanceAssessment; // 车况保养审核是否通过
	private int ifPaymentAssessment; // 缴费是否正常
	private int ifExamine;// 培训考核是否通过
	private int ifDataAcquisition; // 数据采集是否完成
	private int ifComprehensiveAssessment; // 是否通过当前审批
	
	public String getComprehensiveAssessmentID() {
		return comprehensiveAssessmentID;
	}
	public void setComprehensiveAssessmentID(String comprehensiveAssessmentID) {
		this.comprehensiveAssessmentID = comprehensiveAssessmentID;
	}
	public String getDriverID() {
		return driverID;
	}
	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}
	public String getTaximeterDeadline() {
		return taximeterDeadline;
	}
	public void setTaximeterDeadline(String taximeterDeadline) {
		this.taximeterDeadline = taximeterDeadline;
	}
	public String getNextBackToCompanyTime() {
		return nextBackToCompanyTime;
	}
	public void setNextBackToCompanyTime(String nextBackToCompanyTime) {
		this.nextBackToCompanyTime = nextBackToCompanyTime;
	}
	public int getIfVehicleMaintenanceAssessment() {
		return ifVehicleMaintenanceAssessment;
	}
	public void setIfVehicleMaintenanceAssessment(int ifVehicleMaintenanceAssessment) {
		this.ifVehicleMaintenanceAssessment = ifVehicleMaintenanceAssessment;
	}
	public int getIfPaymentAssessment() {
		return ifPaymentAssessment;
	}
	public void setIfPaymentAssessment(int ifPaymentAssessment) {
		this.ifPaymentAssessment = ifPaymentAssessment;
	}
	public int getIfExamine() {
		return ifExamine;
	}
	public void setIfExamine(int ifExamine) {
		this.ifExamine = ifExamine;
	}
	public int getIfDataAcquisition() {
		return ifDataAcquisition;
	}
	public void setIfDataAcquisition(int ifDataAcquisition) {
		this.ifDataAcquisition = ifDataAcquisition;
	}
	public int getIfComprehensiveAssessment() {
		return ifComprehensiveAssessment;
	}
	public void setIfComprehensiveAssessment(int ifComprehensiveAssessment) {
		this.ifComprehensiveAssessment = ifComprehensiveAssessment;
	}

	
}
