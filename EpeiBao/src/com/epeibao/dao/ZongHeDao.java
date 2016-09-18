package com.epeibao.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface ZongHeDao {

	//手机端查询
	/**
	 * 查询总公司
	 * @param parentCompanyID
	 * @param page 当前页数
	 * @param time 查询时间
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, Object>> findByParentCompanyID(@Param("city")String city,
			@Param("page")Integer page,@Param("time")String time,@Param("repeat")Integer repeat) throws Exception;

	
	/**
	 * 查询分公司
	 * @param childCompanyID
	 * @param page
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, Object>> findByChildCompanyID(@Param("childCompanyID")String childCompanyID,
			@Param("page")Integer page,@Param("time")String time,@Param("repeat")Integer repeat) throws Exception;
	
	/**
	 * 查询大队
	 * @param vehicleTeamID
	 * @param page
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, Object>> findByVehicleTeamID(@Param("vehicleTeamID")String vehicleTeamID,
			@Param("page")Integer page,@Param("time")String time,@Param("repeat")Integer repeat) throws Exception;
	
	/**
	 * 查询中队
	 * @param vehicleZhongTeamID
	 * @param page
	 * @param time
	 * @return VehicleGroupID
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, Object>> findByVehicleZhongTeamID(@Param("vehicleZhongTeamID")String vehicleZhongTeamID,
			@Param("page")Integer page,@Param("time")String time,@Param("repeat")Integer repeat) throws Exception;
	
	/**
	 * 查询小队
	 * @param vehicleGroupID
	 * @param page
	 * @param time
	 * @return 
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, Object>> findByVehicleGroupID(@Param("vehicleGroupID")String vehicleGroupID,
			@Param("page")Integer page,@Param("time")String time,@Param("repeat")Integer repeat) throws Exception;
	
	/**
	 * 根据查询小队ID 查询对应的车辆信息
	 * @param vehicleGroupID
	 * @param page
	 * @param time
	 * @param repeat
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, Object>> findBusNum(@Param("vehicleGroupID")String vehicleGroupID,
			@Param("page")Integer page,@Param("time")String time) throws Exception;
	
	/**
	 * 查询双包车对应的车有多少 辆四项都通过的人数    取 最后一列的最大值 
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String,Object>> findBusNumerNum(@Param("id")String id,@Param("level")int level) throws Exception;
	
	/**
	 * 手机端根据车牌号或姓名查询综合信息
	 * @param str 
	 * @param page 
	 * @return
	 */
	public List<LinkedHashMap<String, Object>> findByNameOrBusnumPhone(@Param("driverName")String driverName,@Param("busNumber")String busNumber,
			@Param("page")Integer page,@Param("time")String time,@Param("ognaizetionId")String ognaizetionId,@Param("level")Integer level) throws Exception;
	
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
	public List<LinkedHashMap<String, Object>>  findByCity(@Param("sheng")String sheng,
			@Param("page")Integer page,@Param("time")String time,@Param("repeat")Integer repeat)  throws Exception;
	
	/**
	 * 根据组织ID查询儿子和孙子的级别
	 * @param organizationID
	 * @return
	 * @throws Exception
	 */
	public List<Integer> findLevel(String organizationID) throws Exception;

}
