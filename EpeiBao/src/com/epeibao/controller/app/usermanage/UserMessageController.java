package com.epeibao.controller.app.usermanage;

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
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.epeibao.controller.BaseController;
import com.epeibao.po.Usermessage;
import com.epeibao.service.UserMessageService;

@Controller
@RequestMapping("/UserMessage")
public class UserMessageController extends BaseController {

	private static final long serialVersionUID = 1L;
	private static Logger LOGGER = Logger
			.getLogger(UserMessageController.class);
	@Autowired
	private UserMessageService userMessageService;

	/**
	 * 登录认证֤
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "/loginUser", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loginUser(String info) {
		try {
			JSONObject json = JSON.parseObject(info);
			String token = json.getString("token");
			String params = json.getString("params");
			JSONObject param = JSON.parseObject(params);
			String loginId = param.getString("user");
			String loginPassWrod = param.getString("pwd");
			// state 状态1表示 司机，2表示企业小秘书管理层
			String state = param.getString("state");
			Usermessage usermessage = userMessageService.login(loginId);
			if (usermessage != null) {
				if (loginPassWrod.equals(usermessage.getLoginpassword())) {
					if ("1".equals(state)) {
						LinkedHashMap<String, String> DriverUser = userMessageService
								.findByLoginId(loginId);
						return add("10000", "成功", JSON.toJSONString(DriverUser,
								SerializerFeature.WriteMapNullValue));
					} else {
						Map<String,Object> map = new LinkedHashMap<>();
						// 管理层登录成功
						LinkedHashMap<String, String> list = userMessageService
								.getUserMessage(loginId);
						LinkedHashMap<String, String> jur = userMessageService
								.getJurisdictionLevelByLoginId(loginId);
						map.put("userMessage", list);
						map.put("jurisdiction", jur);
						return add("10000", "成功", JSON.toJSONString(map));
					}
				}
				return add("10001", "密码错误", "{}");
			}
			return add("10002", "账号不存在", "{}");
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10003", "服务器异常", "{}");
		}
	}

	// 修改密码
	@RequestMapping(value = "/updatePassword", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updatePassword(String info) {
		try {
			JSONObject json = JSON.parseObject(info);
			String token = json.getString("token");
			String params = json.getString("params");
			JSONObject param = JSON.parseObject(params);
			String newpassword = param.getString("newpassword");
			String oldPassWrod = param.getString("oldpassWrod");
			String userid = param.getString("userid");
			Usermessage usermessage = userMessageService.findByUserId(userid);
			if (usermessage != null) {
				if (oldPassWrod.equals(usermessage.getLoginpassword())) {
					usermessage.setLoginpassword(newpassword);
					userMessageService.updateUserMessage(usermessage);
					return add("10000", "修改成功", "{}");
				}
				return add("10001", "密码错误", "{}");
			}
			return add("10002", "账号不存在", "{}");
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10003", "服务器异常", "{}");
		}
	}

	// 短信验证成功直接修改密码
	@RequestMapping(value = "/changerPassword", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String changerPassword(String info) {
		try {
			JSONObject json = JSON.parseObject(info);
			String token = json.getString("token");
			String params = json.getString("params");
			JSONObject param = JSON.parseObject(params);
			String newpassword = param.getString("newpassword");
			String userid = param.getString("userid");
			Usermessage usermessage = userMessageService.findByUserId(userid);
			if (usermessage != null) {
				usermessage.setLoginpassword(newpassword);
				userMessageService.updateUserMessage(usermessage);
				return add("10000", "修改成功", "{}");
			}
			return add("10002", "账号不存在", "{}");
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10003", "服务器异常", "{}");
		}
	}
}
