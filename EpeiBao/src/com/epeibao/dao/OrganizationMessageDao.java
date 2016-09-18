package com.epeibao.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.epeibao.po.OrganizationMessage;

/**
 * 组织信息接口
 * 
 * @author Admin
 * 
 */
public interface OrganizationMessageDao {

	/**
	 * 添加组织信息
	 * 
	 * @param organizationMessage
	 * @throws Exception
	 */
	public void insertOrganizationMessage(
			OrganizationMessage organizationMessage) throws Exception;

	/**
	 * 修改组织信息
	 * 
	 * @param organizationMessage
	 * @throws Exception
	 */
	public void updateOrganizationMessage(
			OrganizationMessage organizationMessage) throws Exception;

	/**
	 * 根据组织id删除组织信息
	 * 
	 * @param organizationid
	 * @throws Exception
	 */
	public void deleteOrganizationMessage(String organizationid)
			throws Exception;

	/**
	 * 根据组织id查找组织下的所有组织id
	 * 
	 * @param organizationid
	 * @return
	 * @throws Exception
	 */
	public List<String> findByOrganizationId(
			@Param("organizationid") String organizationid,
			@Param("name") String name) throws Exception;

	/**
	 * 根据组织id查找组织下的所有用户
	 * 
	 * @param organizationid
	 * @return
	 * @throws Exception
	 */
	public List<String> findByUserId(
			@Param("organizationid") String organizationid,
			@Param("name") String name) throws Exception;

	/**
	 * 根据组织id查找组织下的所有组织id
	 * 
	 * @param organizationid
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, String>> getByOrganizationId(
			String organizationid) throws Exception;

	/**
	 * 根据组织id查找组织信息
	 * 
	 * @param organizationid
	 * @return
	 * @throws Exception
	 */
	public OrganizationMessage findById(String organizationid) throws Exception;

	/**
	 * 根据公司ID查询图片上传规则
	 * 
	 * @param CompanyID
	 * @return
	 */
	String getPhototypeRuleByOrganizationID(String organizationID);

	/**
	 * 根据组织ID查询所有子组织ID
	 * @param ParentOrganizationID 父组织ID
	 * @return
	 */
	List<LinkedHashMap<String, String>>  getOrganizationIDSByParentOrganizationID(String parentOrganizationID)throws Exception;
}
