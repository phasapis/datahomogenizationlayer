package org.impress.datahomogenization.ws.service;

import org.impress.datahomogenization.ws.model.BedStats;

public interface BedsService {
	BedStats getClinicAvailableBeds(Integer clinicId);
	BedStats getHospitalAvailableBeds(String hospitalName);
}
