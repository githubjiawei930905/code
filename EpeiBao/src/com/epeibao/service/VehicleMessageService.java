package com.epeibao.service;

import java.util.List;

import com.epeibao.po.VehicleMessage;

public interface VehicleMessageService {
	/**
	 * 
	 * @param vehicleMessage
	 */
	void insertVehicleMessage(VehicleMessage vehicleMessage);

	/**
	 * 删除车辆信息
	 * 
	 * @param busNumber
	 */
	void deleteVehicleMessage(String busNumber);

	/**
	 * 修改车辆信息
	 * 
	 * @param vehicleMessage
	 */
	void updateVehicleMessage(VehicleMessage vehicleMessage);

	/**
	 * 按车牌号（ID）查询车辆信息
	 * 
	 * @param busNumber
	 */
	VehicleMessage selectVehicleMessageByBusNumber(String busNumber);

	/**
	 * 查询全部车辆信息
	 */
	List<VehicleMessage> selectVehicleMessagies();
	/**
	 * 根据车牌号查询总公司ID
	 * @param busNumber
	 * @return
	 */
	String getCompanyIDByBusNumber(String busNumber);

}
