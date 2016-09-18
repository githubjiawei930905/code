package com.epeibao.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.VehicleOriginalPhotoDao;
import com.epeibao.po.VehicleOriginalPhoto;
import com.epeibao.service.VehicleOriginalPhotoService;

@Service
public class VehicleOriginalPhotoServiceImpl implements
		VehicleOriginalPhotoService {
	@Autowired
	private VehicleOriginalPhotoDao dao;

	@Override
	public void insertVehicleOriginalPhoto(
			VehicleOriginalPhoto vehicleOriginalPhoto) {
		dao.insertVehicleOriginalPhoto(vehicleOriginalPhoto);
	}

	@Override
	public void deleteVehicleOriginalPhoto(int vehicleOriginalPhotoId) {
		dao.deleteVehicleOriginalPhoto(vehicleOriginalPhotoId);
	}

	@Override
	public void updateVehicleOriginalPhoto(
			VehicleOriginalPhoto vehicleOriginalPhoto) {
		dao.updateVehicleOriginalPhoto(vehicleOriginalPhoto);
	}

	@Override
	public List<LinkedHashMap<String, String>> getPhotoType(String busNumber) {
		return dao.getPhotoType(busNumber);
	}

	@Override
	public int getMaxBatchId() {
		return dao.getMaxBatchId();
	}

}
