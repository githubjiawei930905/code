package com.epeibao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.VehicleMessageDao;
import com.epeibao.po.VehicleMessage;
import com.epeibao.service.VehicleMessageService;

@Service
public class VehicleMessageServiceImpl implements VehicleMessageService {

	@Autowired
	private VehicleMessageDao dao;

	@Override
	public void insertVehicleMessage(VehicleMessage vehicleMessage) {
		dao.insertVehicleMessage(vehicleMessage);
	}

	@Override
	public void deleteVehicleMessage(String busNumber) {
		dao.deleteVehicleMessage(busNumber);
	}

	@Override
	public void updateVehicleMessage(VehicleMessage vehicleMessage) {
		dao.updateVehicleMessage(vehicleMessage);
	}

	@Override
	public VehicleMessage selectVehicleMessageByBusNumber(String busNumber) {
		return dao.selectVehicleMessageByBusNumber(busNumber);
	}

	@Override
	public List<VehicleMessage> selectVehicleMessagies() {
		return dao.selectVehicleMessagies();
	}

	@Override
	public String getCompanyIDByBusNumber(String busNumber) {
		return dao.getCompanyIDByBusNumber(busNumber);
	}

}
