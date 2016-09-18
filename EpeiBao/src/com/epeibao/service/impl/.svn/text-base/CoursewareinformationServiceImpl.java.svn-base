package com.epeibao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.CoursewareinformationDao;
import com.epeibao.po.Coursewareinformation;
import com.epeibao.service.CoursewareinformationService;
@Service
public class CoursewareinformationServiceImpl implements CoursewareinformationService {

	@Autowired
	private CoursewareinformationDao dao;
	@Override
	public void saveCoursewareinformation(
			Coursewareinformation coursewareinformation) throws Exception {
		dao.insterCoursewareinformation(coursewareinformation);
		
	}

	@Override
	public void updateCoursewareinformation(
			Coursewareinformation coursewareinformation) throws Exception {
			dao.updateCoursewareinformation(coursewareinformation);
	}

	@Override
	public void deleteCoursewareinformation(String CoursewareId)
			throws Exception {
		dao.deleteCoursewareinformation(CoursewareId);
		
	}

	@Override
	public Coursewareinformation findByid(String CoursewareId) throws Exception {
	
		return dao.findByid(CoursewareId);
	}

	@Override
	public List<Coursewareinformation> findSuiji() throws Exception {
		
		return dao.findSuiji();
	}

}
