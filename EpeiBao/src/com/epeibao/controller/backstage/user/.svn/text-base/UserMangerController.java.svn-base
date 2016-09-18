package com.epeibao.controller.backstage.user;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epeibao.po.Usermessage;
import com.epeibao.service.UserMessageService;

@Controller
@RequestMapping("/backstage/user")
public class UserMangerController {

	private static final long serialVersionUID = 1L;
	private static Logger LOGGER = Logger
			.getLogger(UserMangerController.class);
	@Autowired
	private UserMessageService userMessageService;
	//去登录
	@RequestMapping("/gotoLogin")
	public  String gotoLogin(){
		return "/epeibao/index";
	}
	//登录认证
	@RequestMapping("/Login")
	public  String Login( HttpSession session ,String loginID){
		try {
			Usermessage usermessage = userMessageService.login(loginID);
			session.setAttribute("user", usermessage);
			return "/epeibao/main";
		} catch (Exception e) {
			
			LOGGER.error(e);
			return "";
		}
	}
	//信息总览
	@RequestMapping("/home")
	public  String home(){
		return "/epeibao/operationData/home";
	}
}
