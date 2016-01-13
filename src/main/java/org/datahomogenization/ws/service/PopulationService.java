package org.datahomogenization.ws.service;

import org.datahomogenization.ws.model.CityStats;

public interface PopulationService {
	CityStats getCityPopulation(String city);
}
