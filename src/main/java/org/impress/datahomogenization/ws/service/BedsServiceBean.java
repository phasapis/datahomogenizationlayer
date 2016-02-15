package org.impress.datahomogenization.ws.service;

import org.impress.datahomogenization.ws.model.BedStats;
import org.impress.datahomogenization.ws.repository.BedsQueryEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BedsServiceBean implements BedsService {

	@Autowired
	private BedsQueryEngine bedsQueryEngine;
	
	@Override
	public BedStats getClinicAvailableBeds(Integer clinicId) {
		BedStats bedStats = bedsQueryEngine.findAvailableBedsByClinic(clinicId);
		return bedStats;
	}

	@Override
	public BedStats getHospitalAvailableBeds(String hospitalName) {
		BedStats bedStats = bedsQueryEngine.findHospitalAvailableBedsAllClinics(hospitalName);
		return bedStats;
	}

}
