package com.epeibao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.AnswerstatusstatisticalDao;
import com.epeibao.po.Answerstatusstatistical;
import com.epeibao.service.AnswerstatusstatisticalService;
@Service
public class AnswerstatusstatisticalServiceImpl implements AnswerstatusstatisticalService{

	@Autowired
	private AnswerstatusstatisticalDao dao;
	@Override
	public void saveAnswerstatusstatistical(
			Answerstatusstatistical answerstatusstatistical) throws Exception {
		dao.insertAnswerstatusstatistical(answerstatusstatistical);
	}

	@Override
	public void updateAnswerstatusstatistical(
			Answerstatusstatistical answerstatusstatistical) throws Exception {
		dao.updateAnswerstatusstatistical(answerstatusstatistical);
		
	}

	@Override
	public void deleteAnswerstatusstatistical(String AnswerStatusStatisticalId)
			throws Exception {
		dao.deleteAnswerstatusstatistical(AnswerStatusStatisticalId);
		
	}

	@Override
	public Answerstatusstatistical findById(String AnswerStatusStatisticalId)
			throws Exception {
		
		return dao.findById(AnswerStatusStatisticalId);
	}

	@Override
	public List<Answerstatusstatistical> findByState(
			String ComprehensiveAssessmentId,int ifvedioeligible) throws Exception {
		
		return dao.findByState(ComprehensiveAssessmentId,ifvedioeligible);
	}

	
}
