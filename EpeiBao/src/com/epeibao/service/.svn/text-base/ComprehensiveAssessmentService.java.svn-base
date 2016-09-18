package com.epeibao.service;

import java.util.List;

import com.epeibao.po.ComprehensiveAssessment;

public interface ComprehensiveAssessmentService {

	/**
	 * 通过监督卡号差寻综合评测ID
	 */
	public String driverIdByComprehensiveAssessmentID(String driverId)
			throws Exception;

	/**
	 * 根据家督卡号返回考核是否通过
	 */
	public boolean isSucessful(String driverId) throws Exception;

	/**
	 * 添加综合测评
	 * 
	 * @param assessment
	 * @throws Exception
	 */
	public void saveComprehensiveAssessment(ComprehensiveAssessment assessment)
			throws Exception;

	/**
	 * 修改综合测评
	 * 
	 * @param assessment
	 * @throws Exception
	 */
	public void updateComprehensiveAssessment(ComprehensiveAssessment assessment)
			throws Exception;

	/**
	 * 删除综合测评
	 * 
	 * @param ComprehensiveAssessmentId
	 * @throws Exception
	 */
	public void deleteComprehensiveAssessment(String ComprehensiveAssessmentId)
			throws Exception;

	/**
	 * 查找id 的综合测评
	 * 
	 * @param ComprehensiveAssessmentId
	 * @return
	 * @throws Exception
	 */
	public ComprehensiveAssessment findByComprehensiveAssessmentId(
			String ComprehensiveAssessmentId) throws Exception;

	/**
	 * 按司机名字查找综合测评
	 * 
	 * @param DriverId
	 * @return
	 * @throws Exception
	 */
	public List<ComprehensiveAssessment> findByDriverId(String DriverId)
			throws Exception;

	/**
	 * 根据司机ID查询最近6个综合测评ID
	 * 
	 * @param DriverId
	 * @return
	 * @throws Exception
	 */
	List<String> findByDriverIdDesc(String DriverId) throws Exception;
	
	/**
	 * 根据司机ID和时间查询综合评测ID
	 */
	public String findByComprehensive(String str) throws Exception;
}
