package com.epeibao.po;


/**
 * 车辆运营实体类
 * @author Admin
 *
 */
public class OperatingData {
	private int operatingDataID;
	private String comprehensiveAssessmentID;   //综合测评ID
	private String busNumber; //车牌号
	private String boardingTime;   //上车时间
	private String alightingTime;  //下车时间
	private int travlledDistance;   //行驶里程
	private String waitTime;  //等候时间
	private int deadheadKilometres;   //空驶里程
	private int dealtype;  //交易类型
	private int amountReceivable;  //应收金额
	private int ifSend;  //是否上传
	private int ifSuccessCollection;  //是否采集成功  （0--未采集  1--已采集 2--已采集、不完全 
	
	private String collectDate;   //采集时间
	
	
	
	public String getCollectDate() {
		return collectDate;
	}
	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}
	public int getIfSend() {
		return ifSend;
	}
	public void setIfSend(int ifSend) {
		this.ifSend = ifSend;
	}
	public int getOperatingDataID() {
		return operatingDataID;
	}
	public void setOperatingDataID(int operatingDataID) {
		this.operatingDataID = operatingDataID;
	}
	public String getComprehensiveAssessmentID() {
		return comprehensiveAssessmentID;
	}
	public void setComprehensiveAssessmentID(String comprehensiveAssessmentID) {
		this.comprehensiveAssessmentID = comprehensiveAssessmentID;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getBoardingTime() {
		return boardingTime;
	}
	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}
	public String getAlightingTime() {
		return alightingTime;
	}
	public void setAlightingTime(String alightingTime) {
		this.alightingTime = alightingTime;
	}
	public int getTravlledDistance() {
		return travlledDistance;
	}
	public void setTravlledDistance(int travlledDistance) {
		this.travlledDistance = travlledDistance;
	}
	public String getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}
	public int getDeadheadKilometres() {
		return deadheadKilometres;
	}
	public void setDeadheadKilometres(int deadheadKilometres) {
		this.deadheadKilometres = deadheadKilometres;
	}
	public int getDealtype() {
		return dealtype;
	}
	public void setDealtype(int dealtype) {
		this.dealtype = dealtype;
	}
	public int getAmountReceivable() {
		return amountReceivable;
	}
	public void setAmountReceivable(int amountReceivable) {
		this.amountReceivable = amountReceivable;
	}
	public int getIfSuccessCollection() {
		return ifSuccessCollection;
	}
	public void setIfSuccessCollection(int ifSuccessCollection) {
		this.ifSuccessCollection = ifSuccessCollection;
	}
	
	
	
	
}
