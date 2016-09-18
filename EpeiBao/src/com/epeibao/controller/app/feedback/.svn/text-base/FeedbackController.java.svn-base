package com.epeibao.controller.app.feedback;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.epeibao.controller.BaseController;
import com.epeibao.po.Feedback;
import com.epeibao.service.FeedbackService;
@Controller
@RequestMapping("/feedback")
public class FeedbackController extends BaseController {

	private static final long serialVersionUID = 1L;
	private static Logger LOGGER = Logger.getLogger(FeedbackController.class);
	@Autowired
	private FeedbackService feedbackService;
	
	//添加反馈信息
	@RequestMapping(value = "/addFeedBack", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addFeedBack(String info){
		try {
			JSONObject jsonObject = JSON.parseObject(info);
			String token = jsonObject.getString("token");
			String params = jsonObject.getString("params");
			JSONObject param = JSON.parseObject(params);
			//获取用户id
			String userId = param.getString("userId");
			String contentInfo = param.getString("content");
			if(!userId.equals("") && userId!=null &&
					!contentInfo.equals("") && contentInfo!=null) {
				//反馈信息实例
				Feedback feedback = new Feedback();
				feedback.setFeedbackid(UUID.randomUUID().toString());
				feedback.setCreatetime(new Date());
				feedback.setContentinfo(contentInfo);
				feedback.setUserid(userId);
				feedbackService.saveFeedback(feedback);
				return add("10000", "成功", "{\"结果\":\"success\"}");
			}
			
			return add("10001", "请把参数传过来", "{}");
		} catch (Exception e) {
			LOGGER.error(e);
			e.printStackTrace();
			return add("10003", "服务器异常", "{}");
		}
	}
}
