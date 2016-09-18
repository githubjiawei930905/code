package com.epeibao.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.epeibao.po.DriverInformation;

public interface DriverInformationService {
	/**
	 * 根据监督卡号查询车牌号
	 * @param driverId
	 * @return
	 * @throws Exception
	 */
	public String driverIdFindByBusNum(String driverId) throws Exception;
	
	/**
	 * 根据司机姓名或车牌号模糊查询司机信息
	 */
	public List<DriverInformation> findByNameOrBusNum(DriverInformation driverInformation) throws Exception;
	
	/**
	 * 通过司机监督监督卡号查询得到最近一次的综合评测ID
	 */
	public List<String> findByDriverId(DriverInformation driverInformation)  throws Exception;
	
	/**
	 * 根据司机姓名或车牌号模糊查询所有综合评测ID
	 */
	public List<String> findByNameOrBusNum1(String name,String busnum) throws Exception;

}
