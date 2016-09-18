package com.epeibao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.TrainAssessmentDao;
import com.epeibao.po.TrainAssessment;
import com.epeibao.service.TrainAssessmentService;

@Service
public class TrainAssessmentServiceImpl implements TrainAssessmentService {
	@Autowired
	private TrainAssessmentDao dao;
	/**
	 * 通过综合评测ID查询考核培训信息
	 * @return
	 * @throws Exception
	 */
	public TrainAssessment findByid(String id) throws Exception{
		return dao.findByid(id);
	}

}
