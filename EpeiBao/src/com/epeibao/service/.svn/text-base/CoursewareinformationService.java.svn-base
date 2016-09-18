package com.epeibao.service;

import com.epeibao.po.Coursewareinformation;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CoursewareinformationService {

	/**
	 * 添加培训材料
	 * @param coursewareinformation
	 * @throws Exception
	 */
	public void saveCoursewareinformation(Coursewareinformation coursewareinformation)throws Exception;
	/**
	 * 修改培训材料
	 * @param coursewareinformation
	 * @throws Exception
	 */
	public void updateCoursewareinformation(Coursewareinformation coursewareinformation)throws Exception;
	/**
	 * 删除培训材料
	 * @param CoursewareId
	 * @throws Exception
	 */
	public void deleteCoursewareinformation(String CoursewareId)throws Exception;
	/**
	 * 按id 查找培训材料
	 * @param CoursewareId
	 * @return
	 * @throws Exception
	 */
	public Coursewareinformation findByid(String CoursewareId)throws Exception;
	/**
	 * 随机出来培训材料
	 * @return
	 * @throws Exception
	 */
	public List<Coursewareinformation> findSuiji()throws Exception;
}