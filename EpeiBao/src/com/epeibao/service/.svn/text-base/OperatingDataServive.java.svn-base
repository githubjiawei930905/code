package com.epeibao.service;

import java.util.LinkedHashMap;
import java.util.List;

import com.epeibao.po.OperatingData;

/**
 * 车辆运营接口
 * @author Admin
 *
 */
public interface OperatingDataServive {

	/**
	 * 添加车辆运营单条记录
	 * @param driverID  司机监督卡号
	 * @return
	 * @throws Exception
	 */
	public void saveOperatingData(String driverId) throws Exception;


	/**
	 * 批量添加车辆运营信息A2
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public  void addOperatingDataAll2(String driverId,String pathA2) throws Exception;

	/**
	 * 批量添加车辆运营信息A9
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public  void addOperatingDataAll9(String driverId,String pathA9) throws Exception;


	public void saveOperatingData(OperatingData operatingData) throws Exception;
	
	/**
	 * 通过综合评测ID查询运营记录信息
	 */
	public List<LinkedHashMap<String, Object>> findByCompreId(String comprehensiveAssessmentID) throws Exception;
}
