package com.epeibao.dao;

import com.epeibao.po.Message;
import com.sun.mail.handlers.message_rfc822;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MessageDao {

	/**
	 * 添加消息
	 * @param message
	 * @throws Exception
	 */
	public void insertMessage(Message message)throws Exception;
	/**
	 * 修改消息
	 * @param message
	 * @throws Exception
	 */
	public void updataMessage(Message message)throws Exception;
	/**
	 * 删除消息
	 * @param MessageID
	 * @throws Exception
	 */
	public void deleteMessage(String MessageID)throws Exception;
	/**
	 * 用id查找消息
	 * @param MessageID
	 * @return
	 * @throws Exception
	 */
	public LinkedHashMap<String, String> findById(String MessageID) throws Exception;
	/**
	 * 查找用户所有的消息
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, String>> findByUserId(@Param("userid")String userid,@Param("page")Integer page)throws Exception;
	/**
	 * 查找消息
	 * @return
	 * @throws Exception
	 */
	public Message findByMessageId(String messageId)throws Exception;
	
	/**
	 * 查找全部
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, String>> findAll(@Param("page")int page ,@Param("list")List<String> list)throws Exception;
}