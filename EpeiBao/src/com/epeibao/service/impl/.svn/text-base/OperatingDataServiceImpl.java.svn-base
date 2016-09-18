package com.epeibao.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tool.VehicleMessageList;

import com.epeibao.dao.OperatingDataDao;
import com.epeibao.po.OperatingData;
import com.epeibao.service.ComprehensiveAssessmentService;
import com.epeibao.service.DriverInformationService;
import com.epeibao.service.OperatingDataServive;

@Service
public class OperatingDataServiceImpl implements OperatingDataServive {

	@Autowired
	private OperatingDataDao dao;

	@Autowired
	private ComprehensiveAssessmentService comprehensiveAssessmentService;
	@Autowired
	private DriverInformationService driverInformationService;

	private VehicleMessageList vehicleMessageList = new VehicleMessageList();

	@Override
	/**
	 * 添加单条运营信息记录
	 */
	public void saveOperatingData(OperatingData operatingData) throws Exception {
		dao.saveOperatingDataOne(operatingData);
	}

	public List<OperatingData> addOperatingDataAll(List<OperatingData> list,
			String driverId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void saveOperatingData(String driverId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOperatingDataAll2(String driverId, String pathA2)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOperatingDataAll9(String driverId, String pathA9)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LinkedHashMap<String, Object>> findByCompreId(
			String comprehensiveAssessmentID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
