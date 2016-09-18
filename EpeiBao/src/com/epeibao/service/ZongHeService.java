package com.epeibao.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZongHeService {
	
	/**
	 * 查询总公司
	 * @param parentCompanyID
	 * @param page 当前页数
	 * @param time 查询时间
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, Object>> findByParentCompanyID(String parentCompanyID,
			Integer page,String time,Integer repeat) throws Exception;
	
	/**
	 * 查询分公司
	 * @param childCompanyID
	 * @param page
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, Object>> findByChildCompanyID(String childCompanyID,
			Integer page,String time,Integer repeat) throws Exception;
	
	/**
	 * 查询大队
	 * @param vehicleTeamID
	 * @param page
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, Object>> findByVehicleTeamID(String vehicleTeamID,
			Integer page,String time,Integer repeat) throws Exception;
	
	/**
	 * 查询中队
	 * @param vehicleZhongTeamID
	 * @param page
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, Object>> findByVehicleZhongTeamID(String vehicleZhongTeamID,
			Integer page,String time,Integer repeat) throws Exception;
	
	/**
	 * 查询小队
	 * @param vehicleGroupID
	 * @param page
	 * @param time
	 * @return 
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, Object>> findByVehicleGroupID(String vehicleGroupID,
			Integer page,String time,Integer repeat) throws Exception;
	
	/**
	 * 根据查询小队ID 查询对应的车辆信息
	 * @param vehicleGroupID
	 * @param page
	 * @param time
	 * @param repeat
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, Object>> findBusNum(String vehicleGroupID,
			Integer page,String time) throws Exception;
	
	/**
	 * 查询双包车对应的车有多少 辆四项都通过的人数    取 最后一列的最大值 
	 * @return
	 * @throws Exception
	 */
	public  int findBusNumerNum(String id,int level) throws Exception;
	
	/**
	 * 手机端根据车牌号或姓名查询综合信息
	 * @param str 
	 * @param page 
	 * @return
	 */
	public List<LinkedHashMap<String, Object>> findByNameOrBusnumPhone(String str,
			Integer page,String time,String ognaizetionId,Integer level) throws Exception;

	/**
	 * 根据父组织ID查看公司老总名
	 * @param organizationID
	 * @return
	 * @throws Exception
	 */
	public String findOrganizationIDByName(String organizationID) throws Exception;
	
	
	/**
	 * 根据车牌号查询对应的公司
	 * @param busnum
	 * @return
	 * @throws Exception
	 */
	public LinkedHashMap<String, String> findByBusnum(String busnum) throws Exception;
	
	/**
	 * 根据省查市的信息
	 * @param sheng
	 * @param page
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, Object>>  findByCity(String sheng,
			Integer page,String time,Integer repeat)  throws Exception;
	
	/**
	 * 根据组织ID查询儿子和孙子的级别
	 * @param organizationID
	 * @return
	 * @throws Exception
	 */
	public List<Integer> findLevel(String organizationID) throws Exception;

}
