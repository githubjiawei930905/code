package com.epeibao.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.epeibao.po.Commentinformation;

public interface CommentinformationService {

	/**
	 *添加评论 
	 * @param commentinformation
	 * @throws Exception
	 */
	void saveCommentinformation(Commentinformation commentinformation)throws Exception;
	/**
	 * 修改评论
	 * @throws Exception
	 */
	void updateCommentinformation(Commentinformation commentinformation)throws Exception;
	/**
	 * 删除评论
	 * @throws Exception
	 */
	void deleteCommentinformation(String commentid)throws Exception;
	/**
	 * 查找评论
	 * @return
	 * @throws Exception
	 */
	Commentinformation findById(String commentid)throws Exception;
	/**
	 * 消息下的所有评论（onetoone）
	 * @param messageid
	 * @return
	 * @throws Exception
	 */
	List<LinkedHashMap<String, String>> findByMessageId(String messageid,Integer page)throws Exception;
	/**
	 * 查找消息下的所有评论（onetomany）
	 * @param messageid
	 * @return
	 * @throws ExceptionfindByAll
	 */
	List<LinkedHashMap<String, String>> findByAll(String messageid,Integer page)throws Exception;
	/**
	 * 消息下的所有评论（onetomany）的评论数
	 * @param messageid
	 * @return
	 * @throws 
	 */
	int findByAllCount(String MessageId)throws Exception;
}
