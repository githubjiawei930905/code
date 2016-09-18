package com.epeibao.controller.app.message;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.epeibao.controller.BaseController;
import com.epeibao.po.Commentinformation;
import com.epeibao.po.Message;
import com.epeibao.po.Messageprocess;
import com.epeibao.po.OrganizationMessage;
import com.epeibao.po.Usermessage;
import com.epeibao.service.CommentinformationService;
import com.epeibao.service.MessageService;
import com.epeibao.service.MessageprocessService;
import com.epeibao.service.OrganizationMessageService;
import com.epeibao.service.UserMessageService;
import com.epeibao.service.impl.CommentinformationServiceImpl;

@Controller
@RequestMapping("/message")
public class MessageManageController extends BaseController {

	private static final long serialVersionUID = 1L;
	private static Logger LOGGER = Logger
			.getLogger(MessageManageController.class);
	@Autowired
	private MessageService messageService;
	@Autowired
	private MessageprocessService messageprocessService;
	@Autowired
	private CommentinformationService commentinformationService;
	@Autowired
	private UserMessageService userMessageService;
	@Autowired
	private OrganizationMessageService organizationMessageService;

	// 查找用户所有的消息
	@RequestMapping(value = "/queryMessage", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryMessage(String info) {
		try {
			if (info != null && !info.equals("")) {
				JSONObject json = JSON.parseObject(info);
				String token = json.getString("token");
				String params = json.getString("params");
				JSONObject param = JSON.parseObject(params);
				String userid = param.getString("userid");
				Integer page = param.getInteger("page");
				if (userid != null && !"".equals(userid)) {
					List<LinkedHashMap<String, String>> message = messageprocessService.findByUserId(userid, page);
					return add("10000", "成功", JSON.toJSONString(message,
							SerializerFeature.WriteMapNullValue));
				}

				return add("10001", "传入的数据不能为null", "{}");
			}
			return add("10002", "请传来json数据", "{}");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e);
			return add("10003", "服务器异常", "{}");
		}
	}

	// 查找特定id 的消息
	@RequestMapping(value = "/getMessage", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getMessage(String info) {
		try {
			if (info != null && !info.equals("")) {
				JSONObject json = JSON.parseObject(info);
				String token = json.getString("token");
				String params = json.getString("params");
				JSONObject param = JSON.parseObject(params);
				String recordid = param.getString("recordid");
				if (recordid != null && !"".equals(recordid)) {
					LinkedHashMap<String, String> message = messageprocessService.findByid(recordid);
					return add("10000", "成功", JSON.toJSONString(message,
							SerializerFeature.WriteMapNullValue));
				}
				return add("10001", "传入的数据不能为null", "{}");
			}

			return add("10002", "请传来json数据", "{}");
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10003", "服务器异常", "{}");
		}
	}

	// 改变为已读消息
	@RequestMapping(value = "/changerMessage", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String changerMessage(String info) {
		try {
			if (info != null && !info.equals("")) {
				JSONObject json = JSON.parseObject(info);
				String token = json.getString("token");
				String params = json.getString("params");
				JSONObject param = JSON.parseObject(params);
				String recordid = param.getString("recordid");
				if (recordid != null && !"".equals(recordid)) {
					Messageprocess messageprocess = messageprocessService
							.findByRecordid(recordid);
					messageprocess.setProcesstype((byte) 1);
					messageprocess.setProcesstime(new Date());
					messageprocessService.updateMessageprocess(messageprocess);
					return add("10000", "成功", JSON.toJSONString(messageprocess,
							SerializerFeature.WriteMapNullValue));
				}

				return add("10001", "传入的数据不能为null", "{}");
			}

			return add("10002", "请传来json数据", "{}");
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10003", "服务器异常", "{}");
		}
	}

	// 查找是否有已读信息
	@RequestMapping(value = "/querLookMessage", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String querLookMessage(String info) {
		try {
			if (info != null && !info.equals("")) {
				JSONObject json = JSON.parseObject(info);
				String token = json.getString("token");
				String params = json.getString("params");
				JSONObject param = JSON.parseObject(params);
				String userid = param.getString("userid");

				if (userid != null && !userid.equals("")) {
					// 查找已读的信息
					List<Messageprocess> message = messageprocessService
							.findByState(userid, 0);
					if (message != null && message.size() > 0) {
						return add("10000", "成功", "{" + "\"yidu\"" + ":"
								+ true + "}");
					}
					return add("10000", "成功", "{" + "\"yidu\"" + ":" + false
							+ "}");
				}

				return add("10001", "传入的数据不能为null", "{}");
			}

			return add("10002", "请传来json数据", "{}");
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10003", "服务器异常", "{}");
		}
	}

	// 添加评论
	@RequestMapping(value = "/addComment", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addComment(String info) {
		try {
			if (info != null && !info.equals("")) {
				JSONObject json = JSON.parseObject(info);
				String token = json.getString("token");
				String params = json.getString("params");
				JSONObject param = JSON.parseObject(params);
				// 评论人id
				String userid = param.getString("userid");
				// 消息id
				String recordid = param.getString("recordid");
				// 消息内容
				String commentcontent = param.getString("commentcontent");
				// 转变成UTF-8编码。。防止传来的值乱码
				commentcontent = isMessy(commentcontent);
				
				if (userid != null && !userid.equals("") &&  recordid != null && !recordid.equals("")) {
					Commentinformation comment = new Commentinformation();
					comment.setCommentid(UUID.randomUUID().toString());
					comment.setCommentstatus((byte) 1);
					SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
					String time = smp.format(new Date());
					comment.setCommenttime(smp.parse(time));
					comment.setMessageid(recordid);
					comment.setUserid(userid);
					comment.setCommentcontent(commentcontent);
					commentinformationService.saveCommentinformation(comment);
					return add("10000", "成功", "{}");
				}

				return add("10001", "传入的数据不能为null", "{}");
			}

			return add("10002", "请传来json数据", "{}");
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10003", "服务器异常", "{}");
		}
	}

	// 查看消息下的评论
	@RequestMapping(value = "/queryComment", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryComment(String info) {
		try {
			if (info != null && !info.equals("")) {
				JSONObject json = JSON.parseObject(info);
				String token = json.getString("token");
				String params = json.getString("params");
				JSONObject param = JSON.parseObject(params);
				// 消息id
				String recordid = param.getString("recordid");
				Integer page = param.getInteger("page");
				if (recordid != null && !recordid.equals("")) {
					List<LinkedHashMap<String, String>> list = commentinformationService
							.findByMessageId(recordid,page);
					return add("10000", "成功", JSON.toJSONString(list,
							SerializerFeature.WriteMapNullValue));
				}

				return add("10001", "传入的数据不能为null", "{}");
			}

			return add("10002", "请传来json数据", "{}");
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10003", "服务器异常", "{}");
		}
	}

	// 司机发送消息
	@RequestMapping(value = "/addMessage", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addMessage(String info) {
		try {
			if (info != null && !info.equals("")) {
				JSONObject json = JSON.parseObject(info);
				String token = json.getString("token");
				String params = json.getString("params");
				JSONObject param = JSON.parseObject(params);
				String userid = param.getString("userid");
				String messagedescribe = param.getString("content");
				String title = param.getString("title");
				messagedescribe = isMessy(messagedescribe);
				if (userid != null && !userid.equals("")
						&& messagedescribe != null
						&& !messagedescribe.equals("")) {
					Message message = new Message();
					// 发布时间
					SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
					String time = smp.format(new Date());
					message.setMessageid(UUID.randomUUID().toString());
					// 发件人id
					message.setComeuserid(userid);
					LinkedHashMap<String, String> map = userMessageService
							.findParentOrganizationID(userid);
					// 发给谁
					message.setUserid(map.get("userid"));

					// 消息状态
					message.setMessagestatus((byte) 5);
					// 消息级别
					message.setMessagelevel((byte) 3);
					//消息标题
					title = isMessy(title);
					message.setMessagetitle(title);
					// 消息内容
					message.setMessagedescribe(messagedescribe);
					// 消息时间
					message.setBuildtime(smp.parse(time));
					
					messageService.saveMessage(message,"0");
					return add("10000", "消息发送成功", "{}");
				}

				return add("10001", "传入的数据不能为null", "{}");
			}

			return add("10002", "请传来json数据", "{}");
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10003", "服务器异常", "{}");
		}
	}
	
	// 审核消息
		@RequestMapping(value = "/auditMessage", produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String auditMessage(String info) {
			try {
				if (info != null && !info.equals("")) {
					JSONObject json = JSON.parseObject(info);
					String token = json.getString("token");
					String params = json.getString("params");
					JSONObject param = JSON.parseObject(params);
					String messageId = param.getString("messageId");
					String state = param.getString("state");
					if (messageId != null && !messageId.equals("")  &&
							state != null && !state.equals("")) {
						//消息不通过
						if(state.equals("3")){
							Message message =  messageService.findByMessageId(messageId);
							 message.setMessagestatus((byte)3);
							 messageService.updataMessage(message);
							 return add("10000", "消息设置成功", "{}");
						}
						//消息通过
						if(state.equals("2")){
							Message message =  messageService.findByMessageId(messageId);
							 message.setMessagestatus((byte)5);
							 messageService.saveUpdateMessage(message);
							 return add("10000", "消息设置成功", "{}");
						}
						return add("10004", "状态码清传过来，必须是2,3", "{}");
					}

					return add("10001", "传入的数据不能为null", "{}");
				}

				return add("10002", "请传来json数据", "{}");
			} catch (Exception e) {
				LOGGER.error(e);
				return add("10003", "服务器异常", "{}");
			}
		}
		// 管理员发送消息
		@RequestMapping(value = "/insertMessage", produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String insertMessage(String info) {
			try {
				if (info != null && !info.equals("")) {
					JSONObject json = JSON.parseObject(info);
					String token = json.getString("token");
					String params = json.getString("params");
					JSONObject param = JSON.parseObject(params);
					String userid = param.getString("userid");
					String gotoUserid = param.getString("gotoUserid");
					String messagedescribe = param.getString("content");
					String title = param.getString("title");
					int messagelevel = param.getIntValue("messagelevel");
					String gotouserstatus = param.getString("gotouserstatus");
					String expiredofvalidity = param.getString("expiredofvalidity");
					
					messagedescribe = isMessy(messagedescribe);
					if (userid != null && !userid.equals("")
							&& messagedescribe != null
							&& !messagedescribe.equals("")) {
						Message message = new Message();
						// 发布时间
						SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
						String time = smp.format(new Date());
						message.setMessageid(UUID.randomUUID().toString());
						// 发件人id
						message.setComeuserid(userid);
						
						// 发给谁
						message.setUserid(gotoUserid);

						// 消息状态
						message.setMessagestatus((byte) 1);
						// 消息级别
						message.setMessagelevel((byte) messagelevel);
						//消息标题
						title = isMessy(title);
						message.setMessagetitle(title);
						// 消息内容
						message.setMessagedescribe(messagedescribe);
						// 消息时间
						message.setBuildtime(smp.parse(time));
						//发向谁  1，司机  2.管理员
						message.setGotouserstatus(gotouserstatus);
						//有效时间
						message.setExpiredofvalidity(smp.parse(expiredofvalidity));
						messageService.saveMessage(message,"1");
						return add("10000", "消息发送成功", "{}");
					}

					return add("10001", "传入的数据不能为null", "{}");
				}

				return add("10002", "请传来json数据", "{}");
			} catch (Exception e) {
				LOGGER.error(e);
				return add("10003", "服务器异常", "{}");
			}
		}
		// 查看下级的所有组织
		@RequestMapping(value = "/queryOrganization", produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String queryOrganization(String info) {
			try {
				if (info != null && !info.equals("")) {
					JSONObject json = JSON.parseObject(info);
					String token = json.getString("token");
					String params = json.getString("params");
					JSONObject param = JSON.parseObject(params);
					String organizationid = param.getString("organizationid");
					if (organizationid != null && !organizationid.equals("")) {
						//获取组织下的所有组织名字 和id
						List<LinkedHashMap<String, String>>   map= organizationMessageService.getByOrganizationId(organizationid);
						return add("10000", "查看所有组织成功",JSON.toJSONString(map,SerializerFeature.WriteMapNullValue));
					}

					return add("10001", "传入的数据不能为null", "{}");
				}

				return add("10002", "请传来json数据", "{}");
			} catch (Exception e) {
				LOGGER.error(e);
				return add("10003", "服务器异常", "{}");
			}
		}
		//管理员查看所有消息
		@RequestMapping(value = "/queryAll", produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String queryAll(String info) {
			try {
				if (info != null && !info.equals("")) {
					JSONObject json = JSON.parseObject(info);
					String token = json.getString("token");
					String params = json.getString("params");
					JSONObject param = JSON.parseObject(params);
					Integer page = param.getInteger("page");
					String organizationid = param.getString("organizationId");
					if (organizationid != null && !organizationid.equals("") &&
							page != null && !page.equals("") ) {
						//List<String> listStr = organizationMessageService.findByUserId(organizationid,"管理者");
						List<String> listStr = new  ArrayList<String>();
						listStr.add(organizationid);
						List<LinkedHashMap<String, String>> list = messageService.findAll(page,listStr);	
						if(list!=null && list.size()>0){
							
							for(int i = 0; list.size()> 0 && i<list.size();i++){
								LinkedHashMap<Object, Object> map = new LinkedHashMap<Object, Object>();
								list.get(i).put("yiduSize",messageprocessService.findByMessageState(list.get(i).get("MessageID"), 1).size()+"");
								list.get(i).put("weiduSize", messageprocessService.findByMessageState(list.get(i).get("MessageID"), 0).size()+"");
								list.get(i).put("commentCount",commentinformationService.findByAllCount(list.get(i).get("MessageID"))+"");
							}
						}
						return add("10000", "查看所有消息成功", JSON.toJSONString(list,SerializerFeature.WriteMapNullValue));
					}
					return add("10001", "传入的数据不能为null", "{}");
				}

				return add("10002", "请传来json数据", "{}");
			} catch (Exception e) {
				LOGGER.error(e);
				return add("10003", "服务器异常", "{}");
			}
		}
		
		// 管理员查看所有消息的评论
		@RequestMapping(value = "/queryAllComment", produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String queryAllComment(String info) {
			try {
				if (info != null && !info.equals("")) {
					JSONObject json = JSON.parseObject(info);
					String token = json.getString("token");
					String params = json.getString("params");
					JSONObject param = JSON.parseObject(params);
					Integer page = param.getInteger("page");
					String MessageId = param.getString("MessageId");
					if (MessageId != null && !MessageId.equals("") &&
							page != null && !page.equals("") ) {
						//查找消息下的所有评论
						List<LinkedHashMap<String, String>> list = commentinformationService.findByAll(MessageId, page);
						return add("10000", "查看所有评论成功", JSON.toJSONString(list,SerializerFeature.WriteMapNullValue));
					}
					return add("10001", "传入的数据不能为null", "{}");
				}

				return add("10002", "请传来json数据", "{}");
			} catch (Exception e) {
				LOGGER.error(e);
				return add("10003", "服务器异常", "{}");
			}
		}
		
		// 管理员查看未读消息的人
		@RequestMapping(value = "/queryWeiduMessage", produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String queryWeiduMessage(String info) {
			try {
				if (info != null && !info.equals("")) {
					JSONObject json = JSON.parseObject(info);
					String token = json.getString("token");
					String params = json.getString("params");
					JSONObject param = JSON.parseObject(params);
					String MessageId = param.getString("MessageId");
					Integer page = param.getInteger("page");
					if (MessageId != null && !MessageId.equals("") ) {
						//查找未读消息的人
						List<LinkedHashMap<String, String>> list = userMessageService.findMessageByDuquState(MessageId, 0,page);
						List<LinkedHashMap<String, String>> Busnumberlist = new LinkedList<LinkedHashMap<String, String>>();
						for(int i = 0; i<list.size() && list.size()>0;i++){
							LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
							StringBuffer organizationName= new StringBuffer();
							OrganizationMessage message = organizationMessageService.findById(list.get(i).get("ProvinceID"));
							if(message!=null){
								organizationName.append(message.getOrganizationName());
							}
							message =  organizationMessageService.findById(list.get(i).get("CityID"));
							if(message!=null){
								organizationName.append(message.getOrganizationName());
							}
							message = organizationMessageService.findById(list.get(i).get("ParentCompanyID"));
							if(message!=null){
								organizationName.append(message.getOrganizationName());
							}
							message = organizationMessageService.findById(list.get(i).get("ChildCompanyID"));
							if(message!=null){
								organizationName.append(message.getOrganizationName());
							}
							message =  organizationMessageService.findById(list.get(i).get("VehicleTeamID"));
							if(message!=null){
								organizationName.append(message.getOrganizationName());
							}
							message =  organizationMessageService.findById(list.get(i).get("VehicleGroupID"));
							if(message!=null){
								organizationName.append(message.getOrganizationName());
							}
							map.put("organizationName", organizationName.toString());
							map.put("BusNumber", list.get(i).get("BusNumber"));
							Busnumberlist.add(map);
						}
						
						return add("10000", "成功", JSON.toJSONString(Busnumberlist,SerializerFeature.WriteMapNullValue));
					}
					return add("10001", "传入的数据不能为null", "{}");
				}

				return add("10002", "请传来json数据", "{}");
			} catch (Exception e) {
				LOGGER.error(e);
				return add("10003", "服务器异常", "{}");
			}
		}
		// 管理员查看未读消息的人
		@RequestMapping(value = "/queryWeiduMessageBusNumber", produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String queryWeiduMessageBusNumber(String info) {
			try {
				if (info != null && !info.equals("")) {
					JSONObject json = JSON.parseObject(info);
					String token = json.getString("token");
					String params = json.getString("params");
					JSONObject param = JSON.parseObject(params);
					String busNumber = param.getString("busNumber");
					busNumber = isMessy(busNumber);
					if (busNumber != null && !busNumber.equals("") ) {
						//查找未读消息的人
						List<LinkedHashMap<String, String>> list = userMessageService.findByBusNumber(busNumber);
						return add("10000", "成功", JSON.toJSONString(list,SerializerFeature.WriteMapNullValue));
					}
					return add("10001", "传入的数据不能为null", "{}");
				}

				return add("10002", "请传来json数据", "{}");
			} catch (Exception e) {
				LOGGER.error(e);
				return add("10003", "服务器异常", "{}");
			}
		}
		// 管理员修改消息
		@RequestMapping(value = "/updateMessage", produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String updateMessage(String info) {
			try {
				if (info != null && !info.equals("")) {
					JSONObject json = JSON.parseObject(info);
					String token = json.getString("token");
					String params = json.getString("params");
					JSONObject param = JSON.parseObject(params);
					String userid = param.getString("userid");
					String gotoUserid = param.getString("gotoUserid");
					String messagedescribe = param.getString("content");
					String title = param.getString("title");
					int messagelevel = param.getIntValue("messagelevel");
					String gotouserstatus = param.getString("gotouserstatus");
					String expiredofvalidity = param.getString("expiredofvalidity");
					String messageid = param.getString("messageId");
					messagedescribe = isMessy(messagedescribe);
					if (userid != null && !userid.equals("")
							&& messagedescribe != null
							&& !messagedescribe.equals("")) {
						// 发布时间
						SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
						String time = smp.format(new Date());
						Message message = messageService.findByMessageId(messageid);
						// 发件人id
						message.setComeuserid(userid);
						// 发给谁
						message.setUserid(gotoUserid);
						// 消息状态
						message.setMessagestatus((byte) 1);
						// 消息级别
						message.setMessagelevel((byte) messagelevel);
						//消息标题
						title = isMessy(title);
						message.setMessagetitle(title);
						// 消息内容
						message.setMessagedescribe(messagedescribe);
						// 消息时间
						message.setBuildtime(smp.parse(time));
						//发向谁  1，司机  2.管理员
						message.setGotouserstatus(gotouserstatus);
						//有效时间
						message.setExpiredofvalidity(smp.parse(expiredofvalidity));
						messageService.updataMessage(message);
						return add("10000", "消息修改成功", "{}");
					}

					return add("10001", "传入的数据不能为null", "{}");
				}

				return add("10002", "请传来json数据", "{}");
			} catch (Exception e) {
				LOGGER.error(e);
				return add("10003", "服务器异常", "{}");
					}
			}
		//删除消息
		@RequestMapping(value = "/deleteMessage", produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String deleteMessage(String info) {
			try {
				if (info != null && !info.equals("")) {
					JSONObject json = JSON.parseObject(info);
					String token = json.getString("token");
					String params = json.getString("params");
					JSONObject param = JSON.parseObject(params);
					String messageid = param.getString("messageId");
					if (messageid != null && !messageid.equals("")) {
						Message message = messageService.findByMessageId(messageid);
					
						message.setMessagestatus((byte) 4);
						
						messageService.updataMessage(message);
						return add("10000", "删除成功", "{}");
					}

					return add("10001", "传入的数据不能为null", "{}");
				}

				return add("10002", "请传来json数据", "{}");
			} catch (Exception e) {
				LOGGER.error(e);
				return add("10003", "服务器异常", "{}");
					}
		}
		//删除评论
		@RequestMapping(value = "/deleteComment", produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String deleteComment(String info) {
			try {
				if (info != null && !info.equals("")) {
					JSONObject json = JSON.parseObject(info);
					String token = json.getString("token");
					String params = json.getString("params");
					JSONObject param = JSON.parseObject(params);
					String commentId = param.getString("commentId");
					if (commentId != null && !commentId.equals("")) {
						Commentinformation commentinformation =  commentinformationService.findById(commentId);
						commentinformation.setCommentstatus((byte)2);
						commentinformationService.updateCommentinformation(commentinformation);
						return add("10000", "删除成功", "{}");
					}

					return add("10001", "传入的数据不能为null", "{}");
				}

				return add("10002", "请传来json数据", "{}");
			} catch (Exception e) {
				LOGGER.error(e);
				return add("10003", "服务器异常", "{}");
					}
		}
}
