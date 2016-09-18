package com.epeibao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.PaymentAssessmentDao;
import com.epeibao.po.PaymentAssessment;
import com.epeibao.service.PaymentAssessmentService;

@Service
public class PaymentAssessmentServiceImpl implements PaymentAssessmentService {

	@Autowired
	private PaymentAssessmentDao dao;


	@Override
	/**
	 * 更具綜合評測ID查看缴费信息
	 * @return
	 */
	public PaymentAssessment findById(String comprehensiveAssessmentID) throws Exception {
		return dao.findById(comprehensiveAssessmentID);  
		
	}


	/**
	 * 更具监督卡号查看缴费信息的到期时间
	 * @return
	 */
	@Override
	public PaymentAssessment findByDriverId(String driverId) throws Exception {
		List<PaymentAssessment> list = dao.findByDriverId(driverId);
		String comId=null;
		for (int i = 0; i <list.size(); i++) {
			PaymentAssessment paymentAssessment = list.get(i);
			String comid1 =paymentAssessment.getComprehensiveAssessmentID();
			String comid2 =null;
			int pici =Integer.parseInt(comid1.substring(comid1.length()-2, comid1.length()));
			int pici1=0;
			if(i>0){
				PaymentAssessment paymentAssessment1 = list.get(i-1);
				comid2 =paymentAssessment1.getComprehensiveAssessmentID();
				pici1 =Integer.parseInt(comid2.substring(comid2.length()-2, comid2.length()));
			}
			if(pici<=pici1){
				comId=comid2;
			}else{
				comId= comid1;
			}
			
		}
		return dao.findById(comId);
	}

	
}
