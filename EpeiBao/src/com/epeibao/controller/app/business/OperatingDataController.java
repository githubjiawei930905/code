package com.epeibao.controller.app.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.epeibao.controller.BaseController;
import com.epeibao.po.Usermessage;
import com.epeibao.service.OrganizationMessageService;
import com.epeibao.service.UserMessageService;
/**
 * 综合运营数据
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/OperateData")
public class OperatingDataController extends BaseController {

	private static final long serialVersionUID = 1L;
	private static Logger LOGGER = Logger
			.getLogger(OperatingDataController.class);
	@Autowired
	private OrganizationMessageService service;

	/**
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "/loginUser", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loginUser(String info) {
		
		
		
		
		/*
		 * 请求：
{"token":"",
"func_id":"",
"params":{"ParentOrganizationID":"AAA01",
	  "time":"2016-09",
          "page":1,
          "level":1
          }
}

相应：
{"organization":"组织"，
"organizationid":"组织id"，
"validcarnum":"采集车数"，
"alltimesofmonth":"总运次"，
"avgincomeofmonth":"平均收入"，
"mileageofmonth":"月行驶里程"，
"avgnull"："平均空驶率"
}

		 * 
		 * */
		try {
			if (!StringUtils.isEmpty(info)) {
				JSONObject json = JSON.parseObject(info);
				String params = json.getString("params");
				JSONObject param = JSON.parseObject(params);
				String ParentOrganizationID = param.getString("ParentOrganizationID");
				String time = param.getString("time");	
				String page = param.getString("page");	
				String level = param.getString("level");
				List<LinkedHashMap<String, String>> list = service.getOrganizationIDSByParentOrganizationID(ParentOrganizationID);
				return add("10000", "成功", JSON.toJSONString(list));
				
				
			}
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10002", "服务器异常", "{}");
		}
		return info;
		
	}
}
