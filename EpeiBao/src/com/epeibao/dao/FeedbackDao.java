package com.epeibao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.epeibao.po.Feedback;

public interface FeedbackDao {
   
	/**
	 * 添加反馈意见
	 * @param feedback
	 * @throws Exception
	 */
	void insertFeedback(Feedback feedback)throws Exception;
	/**
	 * 修改反馈意见
	 * @param feedback
	 * @throws Exception
	 */
	void updateFeedback(Feedback feedback)throws Exception;
	/**
	 * 删除反馈意见
	 * @param feedBackId
	 * @throws Exception
	 */
	void deleteFeedback(String feedBackId)throws Exception;
	/**
	 * 用反馈id 查找反馈意见
	 * @param feedBackId
	 * @return
	 * @throws Exception
	 */
	Feedback findById(String feedBackId)throws Exception;
	/**
	 * 该用户的反馈意见
	 * @param userId
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<Feedback> findByUserid(@Param("userId")String userId,@Param("page")int page)throws Exception;
	/**
	 * 查找全部的反馈意见
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<Feedback> findAll(int page )throws Exception;
}