package com.epeibao.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.epeibao.po.ComprehensiveAssessment;
import com.epeibao.po.OperatingData;

/**
 * 车辆运营接口
 * @author Admin
 *
 */
public interface OperatingDataDao {
	
	/**
	 * 添加车辆单条运营记录
	 * @param driverID  司机监督卡号
	 * @return
	 * @throws Exception
	 */
	public void saveOperatingDataOne(OperatingData operatingData) throws Exception;
	
	
	/**
	 * 批量添加车辆运营信息
	 * @param list
	 * @returnList<OperatingData>
	 * @throws Exception
	 */
	public  void addOperatingDataDaoAll(List<OperatingData> list) throws Exception;
	
	/**
	 * 通过综合评测ID查询运营记录的相关信息
	 */
	public List<LinkedHashMap<String, Object>> findByCompreId(String comprehensiveAssessmentID) throws Exception;
	
	/**
	 * 根据车牌号或司机姓名查询运营信息
	 */
	public List<LinkedHashMap<String, Object>> findByBusNum(String busNum)  throws Exception;

}
