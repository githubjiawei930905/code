package com.epeibao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.ComprehensiveAssessmentDao;
import com.epeibao.po.ComprehensiveAssessment;
import com.epeibao.service.ComprehensiveAssessmentService;

@Service
public class ComprehensiveAssessmentServiceImpl implements
		ComprehensiveAssessmentService {

	@Autowired
	private ComprehensiveAssessmentDao dao;

	@Override
	/**
	 * 根据监督卡号返回综合评测ID
	 */
	public String driverIdByComprehensiveAssessmentID(String driverId)
			throws Exception {
		List<ComprehensiveAssessment> cad = dao
				.findByDriverId(driverId);
		String compreID = null;
		for (int i = 0; i < cad.size(); i++) {
			String c1 = null;
			String c2 = null;
			String pi1 = null;
			String pi2 = null;
			c1 = cad.get(i).getComprehensiveAssessmentID();
			pi1 = c1.substring(c1.length() - 2, c1.length());
			if (i > 0 && cad.get(i - 1) != null ) {
				c2 = cad.get(i - 1).getComprehensiveAssessmentID();
				pi2 = c2.substring(c2.length() - 2, c2.length());
				if (Integer.parseInt(pi2, 16) > Integer.parseInt(pi1, 16)) {
					compreID = c2;
				}else{
					compreID = c1;
				}
			}else{				
				compreID = c1;
			}

		}
		return compreID;
	}

	@Override
	/**
	 * 根据监督卡号返回是否通过考核进行数据采集
	 */
	public boolean isSucessful(String driverId) throws Exception {
		boolean flag = false;
		String driId = driverIdByComprehensiveAssessmentID(driverId);
		List<ComprehensiveAssessment> cad = dao.findByDriverId(driverId);
		for (int i = 0; i < cad.size(); i++) {
			if (cad.get(i) != null) {
				int pay = cad.get(i).getIfPaymentAssessment(); // 缴费是否正常
				int veh = cad.get(i).getIfVehicleMaintenanceAssessment(); // 车况保养
				int exam = cad.get(i).getIfExamine(); // 培训考核是否通过
				if (pay == veh && pay == exam && pay == 1) {
					flag = true;
				}
			}
		}
		return flag;
	}

	@Override
	public void saveComprehensiveAssessment(ComprehensiveAssessment assessment)
			throws Exception {
		dao.insertComprehensiveAssessment(assessment);
	}

	@Override
	public void updateComprehensiveAssessment(ComprehensiveAssessment assessment)
			throws Exception {
		dao.updateComprehensiveAssessment(assessment);
	}

	@Override
	public void deleteComprehensiveAssessment(String ComprehensiveAssessmentId)
			throws Exception {
		dao.deleteComprehensiveAssessment(ComprehensiveAssessmentId);
	}

	@Override
	public ComprehensiveAssessment findByComprehensiveAssessmentId(
			String ComprehensiveAssessmentId) throws Exception {

		return dao.findByComprehensiveAssessmentId(ComprehensiveAssessmentId);
	}

	@Override
	public List<ComprehensiveAssessment> findByDriverId(String DriverId)
			throws Exception {

		return dao.findByDriverId(DriverId);
	}

	@Override
	public List<String> findByDriverIdDesc(String DriverId) throws Exception {
		return dao.findByDriverIdDesc(DriverId);
	}

	@Override
	public String findByComprehensive(String str) throws Exception {
// TODO 
		return null;
	}

}
