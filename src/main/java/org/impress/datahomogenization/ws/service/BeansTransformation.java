package org.impress.datahomogenization.ws.service;

import org.impress.datahomogenization.ws.model.BedStats;

import oasis.names.tc.emergency.edxl.have._1.HospitalStatus;

public interface BeansTransformation {
	public HospitalStatus BedStatstoHAVE(BedStats bedstats);
}
