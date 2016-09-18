package com.epeibao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.FeedbackDao;
import com.epeibao.po.Feedback;
import com.epeibao.service.FeedbackService;
@Service
public class FeedbackServcieImpl implements FeedbackService {
	@Autowired
	private  FeedbackDao feedbackDao; 
	@Override
	public void saveFeedback(Feedback feedback) throws Exception {
		feedbackDao.insertFeedback(feedback);
	}

	@Override
	public void updateFeedback(Feedback feedback) throws Exception {
		feedbackDao.updateFeedback(feedback);
	}

	@Override
	public void deleteFeedback(String feedBackId) throws Exception {
		feedbackDao.deleteFeedback(feedBackId);
	}

	@Override
	public Feedback findById(String feedBackId) throws Exception {
		
		return feedbackDao.findById(feedBackId);
	}

	@Override
	public List<Feedback> findByUserid(String userId, int page)
			throws Exception {
		
		return feedbackDao.findByUserid(userId, page);
	}

	@Override
	public List<Feedback> findAll(int page) throws Exception {
		
		return feedbackDao.findAll(page);
	}

}
