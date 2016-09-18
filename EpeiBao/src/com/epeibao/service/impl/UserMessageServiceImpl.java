package com.epeibao.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.UsermessageDao;
import com.epeibao.po.Usermessage;
import com.epeibao.service.UserMessageService;
@Service
public class UserMessageServiceImpl implements UserMessageService {

	@Autowired
	private UsermessageDao dao;
	
	@Override
	public void saveUserMessage(Usermessage usermessage) throws Exception {
		dao.insertUserMessage(usermessage);
	}

	@Override
	public void updateUserMessage(Usermessage usermessage) throws Exception {
		dao.updateUserMessage(usermessage);
		
	}

	@Override
	public void deleteUserMessage(String userid) throws Exception {
		dao.deleteUserMessage(userid);
	}

	@Override
	public Usermessage findByUserId(String userid) throws Exception {
		
		return dao.findByUserId(userid);
	}

	@Override
	public LinkedHashMap<String, String> findByLoginId(String loginId) throws Exception {
		
		return dao.findByLoginId(loginId);
	}

	@Override
	public Usermessage findByTelephone(String phoneNumber) throws Exception {
		
		return dao.findByTelephone(phoneNumber);
	}

	@Override
	public List<Usermessage> findByOrganizationId(String organizationid)
			throws Exception {
		
		return dao.findByOrganizationId(organizationid);
	}

	@Override
	public Usermessage login(String loginID) throws Exception {
		
		return dao.login(loginID);
	}

	@Override
	public LinkedHashMap<String, String> findParentOrganizationID(String userid)
			throws Exception {
		
		return dao.findParentOrganizationID(userid);
	}

	@Override
	public LinkedHashMap<String, String> getJurisdictionLevelByLoginId(
			String loginID) throws Exception {
		return dao.getJurisdictionLevelByLoginId(loginID);
		
	}

	@Override
	public LinkedHashMap<String, String> getUserMessage(String loginID)
			throws Exception {
		return dao.getUserMessage(loginID);
	}

	@Override
	public List<LinkedHashMap<String, String>> findMessageByDuquState(String messageid,
			Integer ProcessType,Integer page) throws Exception {
	
		return dao.findMessageByDuquState(messageid, ProcessType,page);
	}

	@Override
	public List<LinkedHashMap<String, String>> findByBusNumber(String busNumber)
			throws Exception {
				
		
		return dao.findByBusNumber(busNumber);
	}

}
