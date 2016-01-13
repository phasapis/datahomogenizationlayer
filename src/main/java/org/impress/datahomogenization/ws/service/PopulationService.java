package org.impress.datahomogenization.ws.service;

import org.impress.datahomogenization.ws.model.CityStats;

public interface PopulationService {
	CityStats getCityPopulation(String city);
}
