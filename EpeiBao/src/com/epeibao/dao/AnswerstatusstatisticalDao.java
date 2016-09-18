package com.epeibao.dao;

import com.epeibao.po.Answerstatusstatistical;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AnswerstatusstatisticalDao {
    
	/**
	 * 添加答题情况
	 * @param answerstatusstatistical
	 * @throws Exception
	 */
	public void insertAnswerstatusstatistical(Answerstatusstatistical answerstatusstatistical)throws Exception;
	/**
	 * 修改答题情况
	 * @param answerstatusstatistical
	 * @throws Exception
	 */
	public void updateAnswerstatusstatistical(Answerstatusstatistical answerstatusstatistical)throws Exception;
	/**
	 * 删除答题情况
	 * @param ComprehensiveAssessmentId
	 * @throws Exception
	 */
	public void deleteAnswerstatusstatistical(String AnswerStatusStatisticalId)throws Exception;
	/**
	 * 查找答题情况
	 * @param ComprehensiveAssessmentId
	 * @return
	 * @throws ExceptionfindByState
	 */
	public Answerstatusstatistical findById(String AnswerStatusStatisticalId)throws Exception;
	/**
	 * 查找答题情况
	 * @param ComprehensiveAssessmentId
	 * @return
	 * @throws ExceptionfindByState
	 */
	public List<Answerstatusstatistical> findByState(@Param("ComprehensiveAssessmentId")String ComprehensiveAssessmentId,@Param("ifvedioeligible")int ifvedioeligible)throws Exception;
}