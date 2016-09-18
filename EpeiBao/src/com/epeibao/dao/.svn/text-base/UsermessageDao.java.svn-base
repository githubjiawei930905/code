package com.epeibao.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.epeibao.po.Usermessage;

public interface UsermessageDao {
	/**
	 * 添加用户信息
	 * 
	 * @param usermessage
	 * @throws Exception
	 */
	public void insertUserMessage(Usermessage usermessage) throws Exception;

	/**
	 * 修改用户信息
	 * 
	 * @param usermessage
	 * @throws Exception
	 */
	public void updateUserMessage(Usermessage usermessage) throws Exception;

	/**
	 * 删除用户信息
	 * 
	 * @param userid
	 * @throws Exception
	 */
	public void deleteUserMessage(String userid) throws Exception;

	/**
	 * 通过userid查找用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public Usermessage findByUserId(String userid) throws Exception;

	/**
	 * 用户认证
	 * 
	 * @param login
	 * @return
	 * @throws Exception
	 */
	public Usermessage login(String loginID) throws Exception;

	/**
	 * 通过登录账号查找司机
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public LinkedHashMap<String, String> findByLoginId(String loginId)
			throws Exception;

	/**
	 * 通过手机号查找用户
	 * 
	 * @param phoneNumber
	 * @return
	 * @throws Exception
	 */
	public Usermessage findByTelephone(String phoneNumber) throws Exception;

	/**
	 * ͨ组织下的所有用户
	 * 
	 * @param organizationid
	 * @return
	 * @throws Exception
	 */
	public List<Usermessage> findMohuByOrganizationId(String organizationid)
			throws Exception;

	/**
	 * ͨ组织下的所有用户
	 * 
	 * @param organizationid
	 * @return
	 * @throws Exception
	 */
	public List<Usermessage> findByOrganizationId(String organizationid)
			throws Exception;

	/**
	 * 查找父组织id
	 * 
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public LinkedHashMap<String, String> findParentOrganizationID(String userid)
			throws Exception;

	/**
	 * 根据LoginID查询用户权限
	 * 
	 * @param loginID
	 * @return
	 * @throws Exception
	 */
	public LinkedHashMap<String, String> getJurisdictionLevelByLoginId(
			String loginID) throws Exception;

	/**
	 * 根据LoginID查询用户ID，用户名，用户组织名称
	 * 
	 * @param loginID
	 * @return
	 * @throws Exception
	 */
	public LinkedHashMap<String, String> getUserMessage(String loginID)
			throws Exception;

	/**
	 * 查找消息读取状态的人
	 * 
	 * @param loginID
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, String>> findMessageByDuquState(
			@Param("messageid") String messageid,
			@Param("ProcessType") Integer ProcessType,
			@Param("page") Integer page) throws Exception;

	/**
	 * 查找车牌号下的人
	 * 
	 * @param loginID
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, String>> findByBusNumber(String busNumber)
			throws Exception;
}