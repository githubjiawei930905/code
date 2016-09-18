package com.epeibao.service;

import java.util.LinkedHashMap;
import java.util.List;

import com.epeibao.po.Message;

public interface MessageService {

	/**
	 * 添加消息
	 * @param message
	 * @throws Exception
	 */
	public void saveMessage(Message message,String state)throws Exception;
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
	public List<LinkedHashMap<String, String>> findByUserId(String userid,Integer page)throws Exception;public Message findByMessageId(String messageId)throws Exception;
	/**
	 *保存并修改
	 * @throws Exception
	 */
	public void saveUpdateMessage(Message message)throws Exception;
	/**
	 * 查找全部
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, String>> findAll(int page,List<String> list)throws Exception;
}
