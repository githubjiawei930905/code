package com.epeibao.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.QuestionmessageDao;
import com.epeibao.po.Questionmessage;
import com.epeibao.service.QuestionmessageService;
@Service
public class QuestionmessageServiceImpl implements QuestionmessageService {

	@Autowired
	private QuestionmessageDao dao;

	@Override
	public void saveQuestionmessage(Questionmessage questionmessage)
			throws Exception {
		dao.insertQuestionmessage(questionmessage);
	}

	@Override
	public void updateQuestionmessage(Questionmessage questionmessage)
			throws Exception {
		dao.updateQuestionmessage(questionmessage);
	}

	@Override
	public void deleteQuestionmessage(String questionid) throws Exception {
		dao.deleteQuestionmessage(questionid);
	}

	@Override
	public Questionmessage findById(String questionid) throws Exception {
		
		return dao.findById(questionid);
	}

	@Override
	public List<Questionmessage> findRandomcompanyQuestionmessage(
			String organizationId, LinkedList<String> list) throws Exception {
		
		return dao.findRandomcompanyQuestionmessage(organizationId, list);
	}

	@Override
	public List<Questionmessage> findRandomCommonQuestionmessage(
			String organizationId, LinkedList<String> list) throws Exception {
		
		return dao.findRandomCommonQuestionmessage(organizationId, list);
	}


}
