package com.epeibao.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.epeibao.po.Messageprocess;
import com.epeibao.po.Usermessage;


public interface MessageprocessDao {
   /**
    * 添加消息处理
    * @param messageprocess
    * @throws Exception
    */
	public void insertMesagsageprocess(Messageprocess messageprocess)throws Exception;
    
    /**
     * 批量添加消息处理
     * @param messageprocess
     * @throws Exception
     */
 	public void insertListMesagsageprocess(List<Messageprocess> list)throws Exception;
	/**
	 * 修改消息处理
	 * @param messageprocess
	 * @throws Exception
	 */
	public void updateMessageprocess(Messageprocess messageprocess)throws Exception;
	/**
	 * 删除消息处理
	 * @param recordid
	 * @throws Exception
	 */
	public void deleteMessageprocess(String recordid)throws Exception;
	
	/**
	 * 查照消息处理
	 * @param recordid
	 * @return
	 * @throws Exception
	 */
	public Messageprocess findByRecordid(String recordid)throws Exception;
	/**
	 * 查照消息处理
	 * @param recordid
	 * @return
	 * @throws Exception
	 */
	public LinkedHashMap<String, String> findByid(String recordid)throws Exception;
	/**
	 * 通过消息id 查看 消息处理
	 * @param messageid
	 * @return
	 * @throws Exception
	 */
	public Messageprocess findBymessageid(String messageid)throws Exception;
	/**
	 * 查找是否有未读消息
	 * @param userid
	 * @param MessageStatus
	 * @returnfindByMessageState
	 * @throws Exception
	 */
	public List<Messageprocess> findByState(@Param ("userid")String userid,@Param ("ProcessType")Integer ProcessType)throws Exception;

	/**
	 * 消息读取状态
	 * @param userid
	 * @param MessageStatus
	 * @return
	 * @throws Exception
	 */
	public List<Messageprocess> findByMessageState(@Param ("messageid")String messageid,@Param ("ProcessType")Integer ProcessType)throws Exception;

	/**
	 * 查找用户所有的消息
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, String>> findByUserId(@Param("userid")String userid,@Param("page")Integer page)throws Exception;
	
	
}