package com.epeibao.dao;

import java.util.List;

import com.epeibao.po.PaymentAssessment;

/**
 * 繳費接口
 * @author Admin
 *
 */
public interface PaymentAssessmentDao {
	
	/**
	 * 更具綜合評測ID查看缴费信息
	 * @return
	 */
	public PaymentAssessment findById(String comprehensiveAssessmentID)  throws Exception;
	
	/**
	 * 更具綜合监督卡号模糊查看缴费信息
	 * @return
	 */
	public List<PaymentAssessment> findByDriverId(String driverId)  throws Exception;

}
