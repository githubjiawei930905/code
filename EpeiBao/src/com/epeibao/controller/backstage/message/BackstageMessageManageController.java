package com.epeibao.controller.backstage.message;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epeibao.po.Message;
import com.epeibao.service.MessageService;
import com.epeibao.service.UserMessageService;

@Controller
@RequestMapping("/backstage/message")
public class BackstageMessageManageController {

	private static final long serialVersionUID = 1L;
	private static Logger LOGGER = Logger
			.getLogger(BackstageMessageManageController.class);
	@Autowired
	private UserMessageService userMessageService;
	@Autowired
	private MessageService messageService;
	
	@RequestMapping("/addMessage")
	public String  addMessage(String userid,String title,String gotoUser,String content,String gotouserstatus,String expiredofvalidity,Integer Messagelevel){
		try {
			Message message = new Message();
			// 发布时间
			SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
			String time = smp.format(new Date());
			message.setMessageid(UUID.randomUUID().toString());
			// 发件人id
			message.setComeuserid(userid);
			// 发给谁
			message.setUserid(gotoUser);
			// 消息状态
			message.setMessagestatus((byte) 1);
			// 消息级别
			message.setMessagelevel((byte) Messagelevel.intValue());
			message.setMessagetitle(title);
			// 消息内容
			message.setMessagedescribe(content);
			// 消息时间
			message.setBuildtime(smp.parse(time));
			//发向谁  1，司机  2.管理员
			message.setGotouserstatus(gotouserstatus);
			//有效时间
			message.setExpiredofvalidity(smp.parse(expiredofvalidity));
			messageService.saveMessage(message,"1");
			return "";
		} catch (Exception e) {
			LOGGER.equals(e);
			return "";
		}
	}
	
	@RequestMapping("/Message")
	public String  Message(){
		try {
			
			return "/epeibao/message/message";
		} catch (Exception e) {
			LOGGER.equals(e);
			return "";
		}
	}

}
