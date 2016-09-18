package com.epeibao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.DriverInformationDao;
import com.epeibao.po.DriverInformation;
import com.epeibao.service.ComprehensiveAssessmentService;
import com.epeibao.service.DriverInformationService;

@Service
public class DriverInformationServiceImpl implements DriverInformationService {

	@Autowired
	DriverInformationDao dao;
	@Autowired
	private ComprehensiveAssessmentService comprehensiveAssessmentService;
	@Override
	/**
	 * 根据司机监督卡号返回车牌号
	 */
	public String driverIdFindByBusNum(String driverId)
			throws Exception {		
		DriverInformation driverInformation= dao.driverIdFindByBusNumer(driverId);
		return  driverInformation.getBusNumber();
	}
	
	/**
	 * 根据司机姓名或车牌号模糊查询司机信息
	 */
	public List<DriverInformation> findByNameOrBusNum(DriverInformation driverInformation) throws Exception{
		return dao.findByNameOrBusNum(driverInformation);
	}
	
	/**
	 * 通过司机监督监督卡号查询得到最近一次的综合评测ID（通过对象查询）
	 */
	public List<String> findByDriverId(DriverInformation driverInformation)  throws Exception{
		List<DriverInformation> list = findByNameOrBusNum(driverInformation);
		List<String> li =new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			li.add(list.get(i).getDriverID());
		}
		return li;
	}
	
	/**
	 * 根据司机姓名或车牌号模糊查询司机监督卡号对应得综合评测ID
	 */
	public List<String> findByNameOrBusNum1(String name,String busnum) throws Exception{
		List<DriverInformation> list = dao.findByNameOrBusNum1(name, busnum);
		List<String> li =new ArrayList<String>();
		
		for (int i = 0; i < list.size(); i++) {
			String comid=comprehensiveAssessmentService.driverIdByComprehensiveAssessmentID(list.get(i).getDriverID());
			li.add(comid);
		}
		return li;
	}


}
