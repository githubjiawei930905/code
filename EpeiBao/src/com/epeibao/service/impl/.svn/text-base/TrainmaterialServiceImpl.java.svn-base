package com.epeibao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.TrainmaterialDao;
import com.epeibao.po.Trainmaterial;
import com.epeibao.service.TrainmaterialService;
@Service
public class TrainmaterialServiceImpl implements TrainmaterialService {

	@Autowired
	private TrainmaterialDao dao;
	@Override
	public void saveTrainmaterial(Trainmaterial trainmaterial)
			throws Exception {
		dao.insertTrainmaterial(trainmaterial);
		
	}

	@Override
	public void updateTrainmaterial(Trainmaterial trainmaterial)
			throws Exception {
		dao.updateTrainmaterial(trainmaterial);
		
	}

	@Override
	public void deleteTrainmaterial(String trainmaterialid) throws Exception {
		dao.deleteTrainmaterial(trainmaterialid);
		
	}

	@Override
	public Trainmaterial findBytrainmaterialId(String trainmaterialid)
			throws Exception {
		
		return dao.findBytrainmaterialId(trainmaterialid);
	}

	@Override
	public Trainmaterial findByOrganizationid(String organizationid)
			throws Exception {
		
		return dao.findByOrganizationid(organizationid);
	}

}
