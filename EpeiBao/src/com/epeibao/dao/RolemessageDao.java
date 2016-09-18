package com.epeibao.dao;

import com.epeibao.po.Rolemessage;


public interface RolemessageDao {
	/**
	 * 添加角色
	 * @param rolemessage
	 * @throws Exception
	 */
	public void insertRolemessage(Rolemessage rolemessage)throws Exception;
	/**
	 * 修改角色
	 * @param rolemessage
	 * @throws Exception
	 */
	public void updateRolemessage(Rolemessage rolemessage)throws Exception;
	/**
	 * 删除角色
	 * @param roleid
	 * @throws Exception
	 */
	public void deleteRolemessage(String roleid)throws Exception;
	/**
	 * 查找角色
	 * @param roleid
	 * @return
	 * @throws Exception
	 */
	public Rolemessage findById(String roleid)throws Exception;
}