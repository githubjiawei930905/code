package com.epeibao.dao;

import com.epeibao.po.Questionmessage;

import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface QuestionmessageDao {

	/**
	 * 添加问题信息
	 * @param questionmessage
	 * @throws Exception
	 */
	public void insertQuestionmessage(Questionmessage questionmessage)throws Exception;
	/**
	 * 修改问题信息
	 * @param questionmessage
	 * @throws Exception
	 */
	public void updateQuestionmessage(Questionmessage questionmessage)throws Exception;
	/**
	 * 删除问题信息
	 * @param questionid
	 * @throws Exception
	 */
	public void deleteQuestionmessage(String questionid)throws Exception;
	/**
	 * 查找问题信息
	 * @param questionid
	 * @return
	 * @throws Exception
	 */
	public Questionmessage findById(String questionid)throws Exception;
	/**
	 * 查找材料下的企业题库
	 * @return
	 * @throws Exception
	 */
	public List<Questionmessage> findRandomcompanyQuestionmessage(@Param("organizationId")String organizationId,@Param("list")LinkedList<String> list)throws Exception;
	/**
	 * 查找材料下的公共题库
	 * @return
	 * @throws Exception
	 */
	public List<Questionmessage> findRandomCommonQuestionmessage(@Param("organizationId")String organizationId,@Param("list")LinkedList<String> list)throws Exception;
}