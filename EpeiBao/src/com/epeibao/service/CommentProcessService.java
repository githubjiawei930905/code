package com.epeibao.service;

import com.epeibao.po.Commentprocess;

public interface CommentProcessService {

	/**
	 * 添加消息处理
	 * @param commentprocess
	 * @throws Exception
	 */
	void saveCommentprocess(Commentprocess commentprocess)throws Exception;
	/**
	 * 修改消息处理
	 * @param commentprocess
	 * @throws Exception
	 */
	void updataCommentprocess(Commentprocess commentprocess)throws Exception;
	/**
	 * 删除消息处理
	 * @param CommentProcessId
	 * @throws Exception
	 */
	void deleteCommentprocess(String CommentProcessId)throws Exception;
	/**
	 * 查找休息处理
	 * @param CommentProcessId
	 * @return
	 * @throws Exception
	 */
	Commentprocess findById(String CommentProcessId)throws Exception;
}
