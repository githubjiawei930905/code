package com.epeibao.controller.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.epeibao.controller.BaseController;
import com.epeibao.service.DriverInformationService;
import com.epeibao.service.ZongHeService;

@Controller
@RequestMapping("/service")
public class ZongHeController extends BaseController {

	private static final Logger LOGGER = Logger.getLogger(OpratingDataBizController.class);

	@Autowired
	private ZongHeService zongHeService;
	

	@Autowired
	private DriverInformationService driverInformationService;


	//查询分公司的信息  
	@RequestMapping(value = "/zongHeChild", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String ChildCompanyID(String info){
		List<LinkedHashMap<String, Object>> list =null;
		try {
			JSONObject json = JSON.parseObject(info);
			String params = json.getString("params");
			JSONObject param = JSON.parseObject(params);
			String childCompanyID = param.getString("childCompanyID");
			int page =param.getInteger("page");
			String time=param.getString("time");
			int level=param.getInteger("level");

			String name =zongHeService.findOrganizationIDByName(childCompanyID);
			int num =zongHeService.findBusNumerNum(childCompanyID,level);
			list = zongHeService.findByChildCompanyID(childCompanyID, page, time,num);
			
			List<Integer> levels = zongHeService.findLevel(childCompanyID);
			Integer child = 0;
			Integer son = 0;
			if(levels.size()==2){
				child = levels.get(0);
				son = levels.get(1);
				return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\",\"child\":"+child+",\"son\""+son+"}");
			}else if(levels.size()==1){
				child = levels.get(0);
				return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\",\"child\":"+child+"}");
			}
 			return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\"}");
		} catch (Exception e) {
			e.printStackTrace();
			return add("10003", "服务器异常", "{}");
		}
	}

	//查询大队
	@RequestMapping(value = "/zongHeVehicleTeam", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String VehicleTeamID(String info){
		List<LinkedHashMap<String, Object>> list =null;
		try {
			JSONObject json = JSON.parseObject(info);
			String params = json.getString("params");
			JSONObject param = JSON.parseObject(params);
			String vehicleTeamID = param.getString("vehicleTeamID");
			int page =param.getInteger("page");
			String time=param.getString("time");
			int level=param.getInteger("level");

			int num =zongHeService.findBusNumerNum(vehicleTeamID,level);
			String name =zongHeService.findOrganizationIDByName(vehicleTeamID);

			list = zongHeService.findByVehicleTeamID(vehicleTeamID, page, time,num);
			
			List<Integer> levels = zongHeService.findLevel(vehicleTeamID);
			Integer child = 0;
			Integer son = 0;
			if(levels.size()==2){
				child = levels.get(0);
				son = levels.get(1);
				return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\",\"child\":"+child+",\"son\""+son+"}");
			}else if(levels.size()==1){
				child = levels.get(0);
				return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\",\"child\":"+child+"}");
			}
 

			return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\"}");
		} catch (Exception e) {
			e.printStackTrace();
			return add("10003", "服务器异常", "{}");
		}
	}

	//查询中队
	@RequestMapping(value = "/zongHeVehicleZhongTeamID", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String VehicleZhongTeamID(String info){
		List<LinkedHashMap<String, Object>> list =null;
		try {
			JSONObject json = JSON.parseObject(info);
			String params = json.getString("params");
			JSONObject param = JSON.parseObject(params);
			String vehicleZhongTeamID = param.getString("vehicleZhongTeamID");
			int page =param.getInteger("page");
			String time=param.getString("time");
			int level =param.getInteger("level");
			int num =zongHeService.findBusNumerNum(vehicleZhongTeamID,level);
			String name =zongHeService.findOrganizationIDByName(vehicleZhongTeamID);
			list = zongHeService.findByVehicleZhongTeamID(vehicleZhongTeamID, page, time,num);
			
			List<Integer> levels = zongHeService.findLevel(vehicleZhongTeamID);
			Integer child = 0;
			Integer son = 0;
			if(levels.size()==2){
				child = levels.get(0);
				son = levels.get(1);
				return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\",\"child\":"+child+",\"son\""+son+"}");
			}else if(levels.size()==1){
				child = levels.get(0);
				return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\",\"child\":"+child+"}");
			}
			return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\"}");
		} catch (Exception e) {
			e.printStackTrace();
			return add("10003", "服务器异常", "{}");
		}
	}

	//查询小队
	@RequestMapping(value = "/zongHeVehicleGroupID", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String vehicleGroupID(String info){
		List<LinkedHashMap<String, Object>> list =null;
		try {
			JSONObject json = JSON.parseObject(info);
			String params = json.getString("params");
			JSONObject param = JSON.parseObject(params);
			String vehicleGroupID = param.getString("vehicleGroupID");
			int page =param.getInteger("page");
			String time=param.getString("time");
			int level =param.getInteger("level");
			int num =zongHeService.findBusNumerNum(vehicleGroupID,level);
			list = zongHeService.findByVehicleGroupID(vehicleGroupID, page, time,num);
			String name =zongHeService.findOrganizationIDByName(vehicleGroupID);
			
			List<Integer> levels = zongHeService.findLevel(vehicleGroupID);
			Integer child = 0;
			Integer son = 0;
			if(levels.size()==2){
				child = levels.get(0);
				son = levels.get(1);
				return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\",\"child\":"+child+",\"son\""+son+"}");
			}else if(levels.size()==1){
				child = levels.get(0);
				return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\",\"child\":"+child+"}");
			}
			return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\"}");
		} catch (Exception e) {
			e.printStackTrace();
			return add("10003", "服务器异常", "{}");
		}
	}

	//查询司机信息
	@RequestMapping(value = "/zongHeBusInfo", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String BusNumInfo(String info){
		List<LinkedHashMap<String, Object>> list =null;
		try {
			JSONObject json = JSON.parseObject(info);
			String params = json.getString("params");
			JSONObject param = JSON.parseObject(params);
			String vehicleGroupID = param.getString("vehicleGroupID");
			int page =param.getInteger("page");
			String time=param.getString("time");
			list = zongHeService.findBusNum(vehicleGroupID, page, time);
			String name =zongHeService.findOrganizationIDByName(vehicleGroupID);
			
			List<Integer> levels = zongHeService.findLevel(vehicleGroupID);
			Integer child = 0;
			Integer son = 0;
			if(levels.size()==2){
				child = levels.get(0);
				son = levels.get(1);
				return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\",\"child\":"+child+",\"son\""+son+"}");
			}else if(levels.size()==1){
				child = levels.get(0);
				return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\",\"child\":"+child+"}");
			}
			
			return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\"}");
		} catch (Exception e) {
			e.printStackTrace();
			return add("10003", "服务器异常", "{}");
		}
	}

	//手机端 根据姓名或车牌号查询
	//根据车牌号查询司机的详细综合信息
	@RequestMapping(value = "/zongheNameOrBusnum", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findByNameOrBusnumPhone(String info){
		List<LinkedHashMap<String, Object>> list =null;
		try {
			JSONObject json = JSON.parseObject(info);
			String params = json.getString("params");
			JSONObject param = JSON.parseObject(params);
			String str = param.getString("str");
			str = isMessy(str);
			int page =param.getInteger("page");
			String time=param.getString("time");
			String ognaizetionId =param.getString("ognaizetionId");
			int level =param.getInteger("level");
			list = zongHeService.findByNameOrBusnumPhone(str, page, time,ognaizetionId,level);

			//return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+"}");
			LinkedHashMap<String, String> linked = zongHeService.findByBusnum(str);
			//return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"allCompany\""+linked.toString()+"}");
			return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"allCompany\":{\"parentCompanyName\":\""+linked.get("parentCompanyName")+"\",\"childCompanyName\":\""+linked.get("childCompanyName")+"\",\"vehicleTeamName\":\""
					+linked.get("vehicleTeamName")+"\",\"vehicleZhongTeamName\":\""+linked.get("vehicleZhongTeamName")+"\",\"vehicleGroupName\":\""+linked.get("vehicleGroupName")+"\"}}");
		} catch (Exception e) {
			e.printStackTrace();
			return add("10003", "服务器异常", "{}");
		}
	}



	//查看所有的市信息
	@RequestMapping(value = "/zongheCity", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String city(String info){
		List<LinkedHashMap<String, Object>> list =null;
		try {
			JSONObject json = JSON.parseObject(info);
			String params = json.getString("params");
			JSONObject param = JSON.parseObject(params);
			String province = param.getString("province");
			int page =param.getInteger("page");
			String time=param.getString("time");
			int num =zongHeService.findBusNumerNum(province,0);
			String name =zongHeService.findOrganizationIDByName("--------------------------");
			list = zongHeService.findByCity(province, page, time, num);
			return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\"}");
		} catch (Exception e) {
			e.printStackTrace();
			return add("10003", "服务器异常", "{}");
		}
	}

	//查询市下总公司的信息
	@RequestMapping(value = "/zongHeParent", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String ParentCompanyID(String info){
		List<LinkedHashMap<String, Object>> list =null;
		try {
			JSONObject json = JSON.parseObject(info);
			String params = json.getString("params");
			JSONObject param = JSON.parseObject(params);
			String cityid = param.getString("cityid");
			int page =param.getInteger("page");
			String time=param.getString("time");

			int num =zongHeService.findBusNumerNum(cityid,0);
			list = zongHeService.findByParentCompanyID(cityid, page,time,num);
			String name =zongHeService.findOrganizationIDByName("--------------------------");
			return add("10000", "成功","{\"result\""+":"+""+JSON.toJSONString(list)+",\"username\":\""+name+"\"}");
		} catch (Exception e) {
			e.printStackTrace();
			return add("10003", "服务器异常", "{}");
		}
	}






	@RequestMapping(value = "/test1", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public void aa() throws Exception{
		List<Integer> levels = zongHeService.findLevel("AAA01BBB01CCC05");
		Integer child =0;
		Integer son = 0;
		if(levels.size()==2){
			child = levels.get(0);
			son = levels.get(1);
		}else if(levels.size()==1){
			child = levels.get(0);
		}
		System.out.println(child+"\t"+son);
	}


}
