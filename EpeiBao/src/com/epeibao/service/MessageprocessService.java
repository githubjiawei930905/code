package com.epeibao.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.epeibao.po.Messageprocess;
import com.epeibao.po.Usermessage;

public interface MessageprocessService {

	 /**
	    * 添加消息处理
	    * @param messageprocess
	    * @throws Exception
	    */
		public void saveMesagsageprocess(Messageprocess messageprocess)throws Exception;
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
		public LinkedHashMap<String, String> findByid(String recordid)throws Exception;
		
		/**
		 * 通过消息id 查看 消息处理
		 * @param messageid
		 * @return
		 * @throws Exception
		 */
		public Messageprocess findBymessageid(String messageid)throws Exception;
		/**
		 * 查找是否有已读信息
		 * @param userid
		 * @return
		 */
		public List<Messageprocess>  findByState(String userid,Integer ProcessType)throws Exception;
		
		/**
		 * 查找用户所有的消息
		 * @param userid
		 * @return
		 * @throws Exception
		 */
		public List<LinkedHashMap<String, String>> findByUserId(String userid,Integer page)throws Exception;
		
		/**
		 * 查照消息处理
		 * @param recordid
		 * @return
		 * @throws Exception
		 */
		public Messageprocess findByRecordid(String recordid)throws Exception;
		/**
		 * 消息读取状态
		 * @param userid
		 * @param MessageStatus
		 * @return
		 * @throws Exception
		 */
		public List<Messageprocess> findByMessageState(String messageid,Integer ProcessType)throws Exception;
		
}
