package com.epeibao.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.VehicleMaintenanceDao;
import com.epeibao.po.VehicleMaintenance;
import com.epeibao.service.VehicleMaintenanceService;

@Service
public class VehicleMaintenanceServiceImpl implements VehicleMaintenanceService {
	@Autowired
	private VehicleMaintenanceDao dao;

	@Override
	public void insertVehicleMaintenance(VehicleMaintenance maintenance)
			throws Exception {
		dao.insertVehicleMaintenance(maintenance);
	}

	@Override
	public void deleteVehicleMaintenance(String Id) throws Exception {
		dao.deleteVehicleMaintenance(Id);
	}

	@Override
	public void updateVehicleMaintenance(VehicleMaintenance maintenance)
			throws Exception {
		dao.updateVehicleMaintenance(maintenance);
	}

	@Override
	public List<VehicleMaintenance> getVehicleMaintenanceById(String id)
			throws Exception {
		return dao.getVehicleMaintenanceById(id);
	}

	@Override
	public VehicleMaintenance getoneVeMaintenance(String id, String type)
			throws Exception {
		return dao.getoneVeMaintenance(id, type);
	}

	

	@Override
	public List<LinkedHashMap<String, String>> getVeMaintenanceByComprehensiveAssessmentID(
			String ComprehensiveAssessmentID) throws Exception {
		return dao
				.getVeMaintenanceByComprehensiveAssessmentID(ComprehensiveAssessmentID);
	}

	@Override
	public int getVeMaintenanceForIfAssessment(
			String comprehensiveAssessmentID, int photoType) {
		return dao.getVeMaintenanceForIfAssessment(comprehensiveAssessmentID, photoType);
	}

	@Override
	public List<LinkedHashMap<String, String>> getVeMaintenanceByBusNumber(
			String comprehensiveAssessmentID,String busNumber) throws Exception {
		return dao.getVeMaintenanceByBusNumber(comprehensiveAssessmentID, busNumber);
	}

}
