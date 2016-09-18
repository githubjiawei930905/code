package com.epeibao.controller.app.vehiclemaintenance;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.epeibao.controller.BaseController;
import com.epeibao.po.VehicleMaintenance;
import com.epeibao.service.ComprehensiveAssessmentService;
import com.epeibao.service.OrganizationMessageService;
import com.epeibao.service.VehicleMaintenanceService;
import com.epeibao.service.VehicleMessageService;
import com.epeibao.service.VehicleOriginalPhotoService;
import com.epeibao.service.impl.OrganizationMessageServiceImpl;
import com.epeibao.service.impl.VehicleMessageServiceImpl;
import com.epeibao.util.PicUploadUtil;

@Controller
@RequestMapping("/VehicleMaintenance")
public class VehicleMaintenanceController extends BaseController {
	private static Logger LOGGER = Logger
			.getLogger(VehicleMaintenanceController.class);
	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	@Autowired
	private VehicleOriginalPhotoService vehicleOriginalPhotoService;
	@Autowired
	private ComprehensiveAssessmentService comprehensiveAssessmentService;
	@Autowired
	private OrganizationMessageService organizationMessageService;
	@Autowired
	private VehicleMessageService vehicleMessageService;

	/**
	 * APP首次登陆，显示图片类型
	 * 
	 * @param info
	 *            (包括车牌号，通过车牌号查询最后批次的图片数量及类型)
	 * @return
	 */
	// @RequestMapping(value = "/firstVisit", produces =
	// "text/html;charset=UTF-8")
	// @ResponseBody
	// public String firstVisit(String info) {
	//
	// // { "token": "",
	// // "func_id": "",
	// // "params": {
	// // "car_num":"车牌号" }
	// // }
	//
	// try {
	//
	// if (!StringUtils.isEmpty(info)) {
	//
	// // 解析json，获取车牌号
	// JSONObject json = JSON.parseObject(info);
	// String params = json.getString("params");
	// JSONObject param = JSON.parseObject(params);
	// String busNumber = param.getString("car_num");
	// try {
	// busNumber = isMessy(busNumber);
	// } catch (UnsupportedEncodingException e) {
	// e.printStackTrace();
	// }
	// List<LinkedHashMap<String, String>> list = vehicleOriginalPhotoService
	// .getPhotoType(busNumber);
	// return add("10000", "成功",
	// "{\"model\": " + JSON.toJSONString(list) + " }");
	// } else {
	// return add("10001", "传入的参数异常", "{}");
	// }
	// } catch (Exception e) {
	// LOGGER.error(e);
	// return add("10002", "服务器异常", "{}");
	// }
	//
	// // 获取最后的批次号
	// // int maxBatchId = vehicleOriginalPhotoService.getMaxBatchId();
	// // return String.valueOf(maxBatchId);
	// }

	/**
	 * 上传及向服务器添加图片
	 * 
	 * @param info
	 *            (添加车牌号)
	 * @return
	 */
	@RequestMapping(value = "/picupload", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String vehicleInsert(HttpServletRequest request, String driverId,
			String busNumber, String photoType, String picName, String picText) {
		try {
			// 根据司机ID获取综合测评ID
			String comprehensiveAssessmentID = comprehensiveAssessmentService
					.driverIdByComprehensiveAssessmentID(driverId);
			// 图片在服务器上存放的文件夹
			String dir = File.separator + "fileupload" + File.separator
					+ new SimpleDateFormat("yyyy-MM").format(new Date());
			// 图片在服务器上的绝对路径
			String path = request.getServletContext().getRealPath(dir);

			// 创建保存图片的文件夹，按年月命名
			if (!StringUtils.isBlank(picName) && !StringUtils.isBlank(picText)
					&& picName.indexOf(".") != -1) {
				// 图片名称：拆分名称与扩展名后加当前时间
				String name = picName.substring(0, picName.lastIndexOf("."))
						+ System.currentTimeMillis()
						+ picName.substring(picName.lastIndexOf("."));
				// 保存图片
				PicUploadUtil.saveOrUpdatePictrue(picText, path, name);
				// 图片在服务器端的地址
				String photoData = dir + File.separator + name;
				// 根据批次和类型查询图片审核状态，判断是否重复上传（未上传时状态是？）
				// int ifAssessment = vehicleMaintenanceService
				// .getVeMaintenanceForIfAssessment(
				// comprehensiveAssessmentID,
				// Integer.parseInt(photoType));
				// if (ifAssessment == 1) {
				// return add("10002", "请勿重复上传", "{}");
				// } else if (ifAssessment == 0) {
				// // 上传未通过，删除历史照片
				// File file = new File(path);
				// file.delete();
				// return add("10003", "请勿重复上传", "{}");
				// }
				// 添加车辆保养记录
				VehicleMaintenance maintenance = new VehicleMaintenance(
						comprehensiveAssessmentID, busNumber,
						Integer.parseInt(photoType), photoData, 0, new Date());
				vehicleMaintenanceService.insertVehicleMaintenance(maintenance);
				return add("10000", "图片上传成功", "{}");
			} else {
				return add("10001", "传入参数异常", "{}");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10002", "服务器异常", "{}");
		}

	}

	/*	*//**
	 * 客户端清理缓存后重新请求服务器获取当前批次图片
	 * 
	 * @param info
	 * @return
	 */
	/*
	 * @RequestMapping(value = "/getpic", produces = "text/html;charset=UTF-8")
	 * 
	 * @ResponseBody public String getpic(String info) { // { "token": "", //
	 * "func_id": "", // "params": { // "driver_id": "司机ID（监督卡号）", // "set":
	 * "0"(0代表查询本批次，1代表查询最近6个批次) // } // } //
	 * http://localhost:8080/EpeiBao/VehicleMaintenance
	 * /getpic.do?info={%20%22token
	 * %22:%20%22%22,%20%22func_id%22:%20%22%22,%20%20
	 * %22params%22:%20{%20%22driver_id
	 * %22:%20%22%E5%8F%B8%E6%9C%BAID%EF%BC%88%E7
	 * %9B%91%E7%9D%A3%E5%8D%A1%E5%8F%B7
	 * %EF%BC%89%22,%20%22set%22:%20%220%22%20}} try { System.out.println(info);
	 * if (!StringUtils.isEmpty(info)) { // 解析json，获取司机Id JSONObject json =
	 * JSON.parseObject(info); String params = json.getString("params");
	 * JSONObject param = JSON.parseObject(params); String driver_id =
	 * param.getString("driver_id"); String set = param.getString("set");
	 * Map<String, List<Map<String, Object>>> smap = new LinkedHashMap<>();
	 * List<Map<String, Object>> slist = new ArrayList<>(); //sMap<String,
	 * Object> numMap = new LinkedHashMap<>(); if (set.equals("0")) {
	 * Map<String, Object> numMap = new LinkedHashMap<>(); // 根据司机ID获取综合测评ID
	 * String comprehensiveAssessmentID = comprehensiveAssessmentService
	 * .driverIdByComprehensiveAssessmentID(driver_id);
	 * List<LinkedHashMap<String, String>> list = vehicleMaintenanceService
	 * .getVeMaintenanceByComprehensiveAssessmentID(comprehensiveAssessmentID);
	 * 
	 * 
	 * numMap.put("piciNum", comprehensiveAssessmentID); numMap.put("pici",
	 * list); slist.add(numMap); smap.put("piclist", slist);
	 * 
	 * return add("10000", "成功", JSON.toJSONString(smap)); } else if
	 * (set.equals("1")) {
	 * 
	 * List<String> comprehensiveAssessmentIDs = comprehensiveAssessmentService
	 * .findByDriverIdDesc(driver_id);
	 * 
	 * for (int i = 0; i < 6; i++) { Map<String, Object> numMap = new
	 * LinkedHashMap<>(); List<LinkedHashMap<String, String>> list =
	 * vehicleMaintenanceService
	 * .getVeMaintenanceByComprehensiveAssessmentID(comprehensiveAssessmentIDs
	 * .get(0)); numMap.put("piciNum", comprehensiveAssessmentIDs.get(0));
	 * numMap.put("pici", list); slist.add(numMap); smap.put("piclist", slist);
	 * 
	 * } return add("10000", "成功", JSON.toJSONString(smap)); } else { return
	 * add("10001", "请传入类型参数", "{}"); } } else { return add("10001", "传入参数为空",
	 * "{}"); } } catch (Exception e) { LOGGER.error(e); return add("10002",
	 * "服务器异常", "{}"); } }
	 */

	/**
	 * 客户端清理缓存后重新请求服务器获取当前批次图片 （根据传入的车牌号查询）
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "/getpic", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getpic(String info) {
		// { "token": "",
		// "func_id": "",
		// "params": {
		// "driver_id": "司机ID（监督卡号）",
		// "bus_number": "车牌号",
		// "set": "0"(0代表查询本批次，1代表查询最近6个批次)
		// }
		// }
		// http://localhost:8080/EpeiBao/VehicleMaintenance/getpic.do?info={%20%22token%22:%20%22%22,%20%22func_id%22:%20%22%22,%20%20%22params%22:%20{%20%22driver_id%22:%20%22%E5%8F%B8%E6%9C%BAID%EF%BC%88%E7%9B%91%E7%9D%A3%E5%8D%A1%E5%8F%B7%EF%BC%89%22,%20%22set%22:%20%220%22%20}}
		try {
			System.out.println(info);
			if (!StringUtils.isEmpty(info)) {
				// 解析json，获取司机Id
				JSONObject json = JSON.parseObject(info);
				String params = json.getString("params");
				JSONObject param = JSON.parseObject(params);
				String driver_id = param.getString("driver_id");
				String bus_number = param.getString("bus_number");
				try {
					bus_number = isMessy(bus_number);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				String set = param.getString("set");
				Map<String, List<Map<String, Object>>> smap = new LinkedHashMap<>();
				List<Map<String, Object>> slist = new ArrayList<>();
				if (set.equals("0")) {
					Map<String, Object> numMap = new LinkedHashMap<>();
					// 根据司机ID获取综合测评ID
					String comprehensiveAssessmentID = comprehensiveAssessmentService
							.driverIdByComprehensiveAssessmentID(driver_id);
					List<LinkedHashMap<String, String>> list = vehicleMaintenanceService
							.getVeMaintenanceByBusNumber(
									comprehensiveAssessmentID, bus_number);
					numMap.put("piciNum", comprehensiveAssessmentID);
					numMap.put("pici", list);
					slist.add(numMap);
					smap.put("piclist", slist);

					return add("10000", "成功", JSON.toJSONString(smap));
				} else if (set.equals("1")) {

					List<String> comprehensiveAssessmentIDs = comprehensiveAssessmentService
							.findByDriverIdDesc(driver_id);

					for (int i = 0; i < 6; i++) {
						Map<String, Object> numMap = new LinkedHashMap<>();
						List<LinkedHashMap<String, String>> list = vehicleMaintenanceService
								.getVeMaintenanceByComprehensiveAssessmentID(comprehensiveAssessmentIDs
										.get(0));
						numMap.put("piciNum", comprehensiveAssessmentIDs.get(0));
						numMap.put("pici", list);
						slist.add(numMap);
						smap.put("piclist", slist);

					}
					return add("10000", "成功", JSON.toJSONString(smap));
				} else {
					return add("10001", "请传入类型参数", "{}");
				}
			} else {
				return add("10001", "传入参数为空", "{}");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10002", "服务器异常", "{}");
		}
	}

	@RequestMapping(value = "/firstVisit", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String firstVisit(String info) {
		try {
			// { "token": "",
			// "func_id": "",
			// "params": {
			// "car_num":"车牌号" }
			// }

			if (!StringUtils.isEmpty(info)) {
				JSONObject json = JSON.parseObject(info);
				String params = json.getString("params");
				JSONObject param = JSON.parseObject(params);
				String busNumber = param.getString("car_num");
				try {
					busNumber = isMessy(busNumber);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				String companyID = vehicleMessageService
						.getCompanyIDByBusNumber(busNumber);
				if (companyID != null) {
					companyID = companyID.substring(0, 5);
				} else {
					return add("10001", "传入的参数异常", "{}");
				}
				String phototypeRule = organizationMessageService
						.getPhototypeRuleByOrganizationID(companyID);

				String[] split = phototypeRule.split("，");
				List<LinkedHashMap<String, String>> list = new ArrayList<>();
				for (int i = 0; i < split.length; i++) {
					LinkedHashMap<String, String> map = new LinkedHashMap<>();
					map.put("photoType", split[i]);
					list.add(map);
				}
				return add("10000", "成功",
						"{\"model\": " + JSON.toJSONString(list) + " }");
			} else {
				return add("10001", "传入的参数异常", "{}");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			e.printStackTrace();
			return add("10002", "服务器异常", "{}");
		}

	}

}
