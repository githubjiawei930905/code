package com.epeibao.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.epeibao.po.DriverInformation;

public interface DriverInformationDao {
	
	/**
	 * 根据监督卡号查询司机信息
	 * @param driverId
	 * @return
	 * @throws Exception
	 */
	public DriverInformation driverIdFindByBusNumer(String driverId) throws Exception;
	
	/**
	 * 根据司机姓名或车牌号模糊查询司机信息
	 */
	public List<DriverInformation> findByNameOrBusNum(DriverInformation driverInformation) throws Exception;
	
	
	/**
	 * 根据司机姓名或车牌号模糊查询司机信息
	 */
	public List<DriverInformation> findByNameOrBusNum1(@Param("name")String name,@Param("busnum")String busnum) throws Exception;

}
