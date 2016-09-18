package com.epeibao.po;

/**
 * 车辆基本信息实体类
 * 
 * @author Admin
 * 
 */
public class VehicleMessage {
	private String busNumber;// 车牌号
	private String vehicleType;// 车辆类型
	private String vehicleColor;// 车辆颜色
	private String terminalSIM_ID;// 终端SIM卡号
	private String companyID;// 公司ID

	public VehicleMessage() {
	}

	public VehicleMessage(String busNumber, String vehicleType,
			String vehicleColor, String terminalSIM_ID, String companyID,
			long vehiclePhoto1, long vehiclePhoto2, long vehiclePhoto3) {
		this.busNumber = busNumber;
		this.vehicleType = vehicleType;
		this.vehicleColor = vehicleColor;
		this.terminalSIM_ID = terminalSIM_ID;
		this.companyID = companyID;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public String getTerminalSIM_ID() {
		return terminalSIM_ID;
	}

	public void setTerminalSIM_ID(String terminalSIM_ID) {
		this.terminalSIM_ID = terminalSIM_ID;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

}
