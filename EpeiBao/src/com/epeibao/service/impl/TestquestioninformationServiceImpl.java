package com.epeibao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.TestquestioninformationDao;
import com.epeibao.po.Testquestioninformation;
import com.epeibao.service.TestquestioninformationService;
@Service
public class TestquestioninformationServiceImpl  implements TestquestioninformationService{

	@Autowired
	private TestquestioninformationDao dao;
	@Override
	public void saveTestquestioninformation(
			Testquestioninformation testquestioninformation) throws Exception {
		dao.insertTestquestioninformation(testquestioninformation);
	}

	@Override
	public void updateTestquestioninformation(
			Testquestioninformation testquestioninformation) throws Exception {
		dao.updateTestquestioninformation(testquestioninformation);
	}

	@Override
	public void deleteTestquestioninformationString(String testquestionid)
			throws Exception {
		dao.deleteTestquestioninformationString(testquestionid);
	}

	@Override
	public Testquestioninformation findById(String testquestionid)
			throws Exception {
		
		return dao.findById(testquestionid);
	}

}
