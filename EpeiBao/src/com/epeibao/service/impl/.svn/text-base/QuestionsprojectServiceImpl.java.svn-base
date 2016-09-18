package com.epeibao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.QuestionsprojectDao;
import com.epeibao.po.Questionsproject;
import com.epeibao.service.QuestionsprojectService;

@Service
public class QuestionsprojectServiceImpl implements QuestionsprojectService{

	@Autowired
	private QuestionsprojectDao dao;
	@Override
	public void saveQuestinsProject(Questionsproject questionsproject)
			throws Exception {
	dao.insertQuestinsProject(questionsproject);
	}

	@Override
	public void updateQuestinsProject(Questionsproject questionsproject)
			throws Exception {
		dao.updateQuestinsProject(questionsproject);
		
	}

	@Override
	public void deleteQuestinsProject(String questinsProjectid)
			throws Exception {
		dao.deleteQuestinsProject(questinsProjectid);
	}

	@Override
	public Questionsproject findByid(String questinsProjectid) throws Exception {
		
		return dao.findByid(questinsProjectid);
	}

	@Override
	public List<Questionsproject> findByorganizationid(String organizationid)
			throws Exception {
		
		return dao.findByorganizationid(organizationid);
	}

}
