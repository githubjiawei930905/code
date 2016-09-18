package com.epeibao.dao;

import com.epeibao.po.TrainAssessment;

public interface TrainAssessmentDao {
	/**
	 * 通过综合评测ID查询考核培训信息
	 * @return
	 * @throws Exception
	 */
	public TrainAssessment findByid(String id) throws Exception;

}
