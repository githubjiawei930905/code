package com.epeibao.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.MessageDao;
import com.epeibao.dao.MessageprocessDao;
import com.epeibao.dao.OrganizationMessageDao;
import com.epeibao.dao.UsermessageDao;
import com.epeibao.po.Message;
import com.epeibao.po.Messageprocess;
import com.epeibao.po.Usermessage;
import com.epeibao.service.MessageService;
import com.epeibao.service.OrganizationMessageService;
import com.epeibao.service.UserMessageService;
@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageDao dao;
	@Autowired
	private MessageprocessDao dao1;
	@Autowired
	private OrganizationMessageDao organizationMessageDao;
	@Autowired
	private UsermessageDao usermessageDao;
	@Override
	public void saveMessage(Message message,String state) throws Exception {
		dao.insertMessage(message);
		if(state.equals("0")){
			//给发送人做一个添加信息处理
			Messageprocess messageprocess = new Messageprocess();
			messageprocess.setRecordid(UUID.randomUUID().toString());
			messageprocess.setMessageid(message.getMessageid());
			messageprocess.setProcesstime(message.getBuildtime());
			messageprocess.setProcesstype((byte)0);
			messageprocess.setUserid(message.getUserid());
			dao1.insertMesagsageprocess(messageprocess);
			//给发送的人做一个添加信息处理
			messageprocess.setRecordid(UUID.randomUUID().toString());
			messageprocess.setUserid(message.getComeuserid());
			dao1.insertMesagsageprocess(messageprocess);
		}
//		else{
//			Usermessage usermessage = usermessageDao.findByTelephone(phoneNumber);
//			Messageprocess messageprocess = new Messageprocess();
//			messageprocess.setRecordid(UUID.randomUUID().toString());
//			messageprocess.setMessageid(message.getMessageid());
//			messageprocess.setProcesstime(message.getBuildtime());
//			messageprocess.setProcesstype((byte)0);
//			messageprocess.setUserid(message.getComeuserid());
//			dao1.insertMesagsageprocess(messageprocess);
//		}
	}

	@Override
	public void updataMessage(Message message) throws Exception {
		dao.updataMessage(message);
	}

	@Override
	public void deleteMessage(String MessageID) throws Exception {
		dao.deleteMessage(MessageID);
	}

	@Override
	public LinkedHashMap<String, String> findById(String MessageID) throws Exception {
		
		return dao.findById(MessageID);
	}

	
	public List<LinkedHashMap<String, String>> findByUserId(String userid,Integer page) throws Exception {
		
		return dao.findByUserId(userid,page);
	}

	@Override
	public Message findByMessageId(String messageId) throws Exception {
	
		return dao.findByMessageId(messageId);
	}

	@Override
	public void saveUpdateMessage(Message message) throws Exception {
		dao.updataMessage(message);
		//装消息处理
		List<Messageprocess> list = new LinkedList<Messageprocess>();
		//管理端
		if(message.getMessagestatus().equals("2")){
		//发送者 查找这个组织下的所有组织id
		List<String> organizationId = organizationMessageDao.findByOrganizationId(message.getUserid(),"管理者");
			//循环出所有的组织id
			for(int i = 0;organizationId.size()>0 && i<organizationId.size();i++ ){
				//查找组织下得所有用户
				List<Usermessage> user = usermessageDao.findByOrganizationId(organizationId.get(i));
				for(int j=0 ; user.size()>0 && j<user.size();j++){
					//给用户添加消息处理
					Messageprocess messageprocess = new Messageprocess();
					messageprocess.setRecordid(UUID.randomUUID().toString());
					messageprocess.setMessageid(message.getMessageid());
					messageprocess.setProcesstime(message.getBuildtime());
					messageprocess.setMessageid(message.getMessageid());
					messageprocess.setProcesstype((byte)0);
					messageprocess.setUserid(user.get(j).getUserid());
					list.add(messageprocess);
				}
			 }
		}else{
			//发送者 查找这个组织下的所有组织id
			List<String> organizationId = organizationMessageDao.findByOrganizationId(message.getUserid(),"司机");
				//循环出所有的组织id
				for(int i = 0;organizationId.size()>0 && i<organizationId.size();i++ ){
					//查找组织下得所有用户
					List<Usermessage> user = usermessageDao.findByOrganizationId(organizationId.get(i));
					for(int j=0 ; user.size()>0 && j<user.size();j++){
						//给用户添加消息处理
						Messageprocess messageprocess = new Messageprocess();
						messageprocess.setRecordid(UUID.randomUUID().toString());
						messageprocess.setMessageid(message.getMessageid());
						messageprocess.setProcesstime(message.getBuildtime());
						messageprocess.setMessageid(message.getMessageid());
						messageprocess.setProcesstype((byte)0);
						messageprocess.setUserid(user.get(j).getUserid());
						list.add(messageprocess);
					}
				 }	
				
			}
			
		
		//如果发送组织id 下面没有人就不要进去添加处理
		if(list.size()>0 && list!=null){
			dao1.insertListMesagsageprocess(list);
		}
		
	}

	@Override
	public List<LinkedHashMap<String, String>> findAll(int page,List<String> list) throws Exception {
		
		return dao.findAll(page,list);
	}





}
