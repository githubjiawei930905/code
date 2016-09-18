package com.epeibao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.epeibao.dao.RolemessageDao;
import com.epeibao.po.Rolemessage;
import com.epeibao.service.RolemessageService;
@Service
public class RolemessageServiceImpl implements RolemessageService {

	@Autowired
	private RolemessageDao dao;
	@Override
	public void saveRolemessage(Rolemessage rolemessage) throws Exception {
		dao.insertRolemessage(rolemessage);
	}

	@Override
	public void updateRolemessage(Rolemessage rolemessage) throws Exception {
		dao.updateRolemessage(rolemessage);
	}

	@Override
	public void deleteRolemessage(String roleid) throws Exception {
		dao.deleteRolemessage(roleid);
	}

	@Override
	public Rolemessage findById(String roleid) throws Exception {
		
		return dao.findById(roleid);
	}

}
