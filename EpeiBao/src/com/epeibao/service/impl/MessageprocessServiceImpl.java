package com.epeibao.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.MessageprocessDao;
import com.epeibao.po.Messageprocess;
import com.epeibao.po.Usermessage;
import com.epeibao.service.MessageprocessService;

@Service
public class MessageprocessServiceImpl implements MessageprocessService {

	@Autowired
	private MessageprocessDao dao;

	@Override
	public void saveMesagsageprocess(Messageprocess messageprocess)
			throws Exception {
		dao.insertMesagsageprocess(messageprocess);
	}

	@Override
	public void updateMessageprocess(Messageprocess messageprocess)
			throws Exception {
		dao.updateMessageprocess(messageprocess);
	}

	@Override
	public void deleteMessageprocess(String recordid) throws Exception {
		dao.deleteMessageprocess(recordid);
	}

	@Override
	public LinkedHashMap<String, String> findByid(String recordid) throws Exception {

		return dao.findByid(recordid);
	}

	@Override
	public Messageprocess findBymessageid(String messageid) throws Exception {

		return dao.findBymessageid(messageid);
	}

	@Override
	public List<Messageprocess> findByState(String userid, Integer ProcessType)
			throws Exception {

		return dao.findByState(userid, ProcessType);
	}

	@Override
	public List<LinkedHashMap<String, String>> findByUserId(String userid,
			Integer page) throws Exception {
		
		return dao.findByUserId(userid, page);
	}

	@Override
	public Messageprocess findByRecordid(String recordid) throws Exception {
		
		return dao.findByRecordid(recordid);
	}

	@Override
	public List<Messageprocess> findByMessageState(String messageid,
			Integer ProcessType) throws Exception {
	
		return dao.findByMessageState(messageid, ProcessType);
	}

}
