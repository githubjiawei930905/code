package com.epeibao.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.OrganizationMessageDao;
import com.epeibao.po.OrganizationMessage;
import com.epeibao.service.OrganizationMessageService;

@Service
public class OrganizationMessageServiceImpl implements
		OrganizationMessageService {

	@Autowired
	private OrganizationMessageDao dao;

	@Override
	public void saveOrganizationMessage(OrganizationMessage organizationMessage)
			throws Exception {
		dao.insertOrganizationMessage(organizationMessage);
	}

	@Override
	public void updateOrganizationMessage(
			OrganizationMessage organizationMessage) throws Exception {
		dao.updateOrganizationMessage(organizationMessage);
	}

	@Override
	public void deleteOrganizationMessage(String organizationid)
			throws Exception {
		dao.deleteOrganizationMessage(organizationid);
	}

	@Override
	public OrganizationMessage findById(String organizationid) throws Exception {
		return dao.findById(organizationid);
	}

	@Override
	public String getPhototypeRuleByOrganizationID(String organizationID) {
		return dao.getPhototypeRuleByOrganizationID(organizationID);
	}

	@Override
	public List<String> findByOrganizationId(String organizationid, String name)
			throws Exception {

		return dao.findByOrganizationId(organizationid, name);
	}

	@Override
	public List<LinkedHashMap<String, String>> getByOrganizationId(
			String organizationid) throws Exception {

		return dao.getByOrganizationId(organizationid);
	}

	@Override
	public List<String> findByUserId(String organizationid, String name)
			throws Exception {

		return dao.findByUserId(organizationid, name);
	}

	@Override
	public List<LinkedHashMap<String, String>> getOrganizationIDSByParentOrganizationID(
			String parentOrganizationID) throws Exception {
		return dao
				.getOrganizationIDSByParentOrganizationID(parentOrganizationID);
	}

}
