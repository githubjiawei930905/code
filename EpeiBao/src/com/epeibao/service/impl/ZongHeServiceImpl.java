package com.epeibao.service.impl;


import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.ZongHeDao;
import com.epeibao.service.DriverInformationService;
import com.epeibao.service.ZongHeService;
@Service
public class ZongHeServiceImpl implements ZongHeService {

	@Autowired
	private ZongHeDao dao;
	@Autowired
	private DriverInformationService driverInformationService;
	

	/**
	 * 查询总公司
	 * @param parentCompanyID
	 * @param page 当前页数
	 * @param time 查询时间
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<LinkedHashMap<String, Object>> findByParentCompanyID(String parentCompanyID,
			Integer page,String time,Integer repeat) throws Exception{
		return dao.findByParentCompanyID(parentCompanyID, page, time,repeat);

	}

	/**
	 * 查询分公司
	 * @param childCompanyID
	 * @param page
	 * @param time
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<LinkedHashMap<String, Object>> findByChildCompanyID(String childCompanyID,
			Integer page,String time,Integer repeat) throws Exception{
		return dao.findByChildCompanyID(childCompanyID, page, time,repeat);
	}

	/**
	 * 查询大队
	 * @param vehicleTeamID
	 * @param page
	 * @param time
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<LinkedHashMap<String, Object>> findByVehicleTeamID(String vehicleTeamID,
			Integer page,String time,Integer repeat) throws Exception{
		return dao.findByVehicleTeamID(vehicleTeamID, page, time,repeat);
	}

	/**
	 * 查询中队
	 * @param vehicleZhongTeamID
	 * @param page
	 * @param time
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<LinkedHashMap<String, Object>> findByVehicleZhongTeamID(String vehicleZhongTeamID,
			Integer page,String time,Integer repeat) throws Exception{
		return dao.findByVehicleZhongTeamID(vehicleZhongTeamID, page, time,repeat);
	}

	/**
	 * 查询小队
	 * @param vehicleGroupID
	 * @param page
	 * @param time
	 * @return 
	 * @throws Exception
	 */
	@Override
	public List<LinkedHashMap<String, Object>> findByVehicleGroupID(String vehicleGroupID,
			Integer page,String time,Integer repeat) throws Exception{
		return dao.findByVehicleGroupID(vehicleGroupID, page, time,repeat);
	}


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
			Integer page,String time) throws Exception{
		return dao.findBusNum(vehicleGroupID, page, time);
	}


	/**
	 * 查询双包车对应的车有多少 辆四项都通过的人数    取 最后一列的最大值 
	 * @return
	 * @throws Exception
	 */
	public int findBusNumerNum(String id,int level) throws Exception{
		int n=0;
		int num1=0;
		int num2=0;
		List<LinkedHashMap<String,Object>> list = dao.findBusNumerNum(id, level);
		for (int i = 0; i < list.size(); i++) {
			LinkedHashMap<String,Object> linked1 = list.get(i);
			String rows= linked1.get("rows").toString();
			num1 = Integer.parseInt(rows);
			if(i>0){
				LinkedHashMap<String,Object> linked2 = list.get(i-1);
				String rows1= linked2.get("rows").toString();
				num2 = Integer.parseInt(rows1);
				if(num1>num2){
					n=num1;
				}else{
					n=num2;
				}
			}else{
				n=num1;
			}
		}	
		return n;
	}

	/**
	 * 手机端根据车牌号或姓名查询综合信息
	 * @param str 
	 * @param page 
	 * @return
	 */
	public List<LinkedHashMap<String, Object>> findByNameOrBusnumPhone(String str,
			Integer page,String time,String ognaizetionId,Integer level) throws Exception{
		List<LinkedHashMap<String, Object>> list = dao.findByNameOrBusnumPhone("", str, page, time,ognaizetionId,level);
		List<LinkedHashMap<String, Object>> list1 =dao.findByNameOrBusnumPhone(str, "", page, time,ognaizetionId,level);
		
		for (int i = 0; i < list1.size(); i++) {
			LinkedHashMap<String, Object> linked =list1.get(i);
			list.add(linked);
		}
		return list;
	}
	
	/**
	 * 根据父组织ID查看公司老总名
	 * @param organizationID
	 * @return
	 * @throws Exception
	 */
	public String findOrganizationIDByName(String organizationID) throws Exception{
		return dao.findOrganizationIDByName(organizationID);
	}
	
	
	/**
	 * 根据车牌号查询对应的公司
	 * @param busnum
	 * @return
	 * @throws Exception
	 */
	public LinkedHashMap<String, String> findByBusnum(String busnum) throws Exception{
		return dao.findByBusnum(busnum);
	}
	
	/**
	 * 根据省查市的信息
	 * @param sheng
	 * @param page
	 * @param time
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<LinkedHashMap<String, Object>>  findByCity(String sheng,
			Integer page,String time,Integer repeat)  throws Exception{		
		return dao.findByCity(sheng, page, time,repeat);
	}
	
	/**
	 * 根据组织ID查询儿子和孙子的级别
	 * @param organizationID
	 * @return
	 * @throws Exception
	 */
	public List<Integer> findLevel(String organizationID) throws Exception{
		return dao.findLevel(organizationID);
	}



}
