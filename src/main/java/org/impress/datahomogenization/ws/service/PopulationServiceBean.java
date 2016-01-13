package org.impress.datahomogenization.ws.service;

import org.impress.datahomogenization.ws.model.CityStats;
import org.impress.datahomogenization.ws.repository.PopulationQueryEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PopulationServiceBean implements PopulationService {

	@Autowired
	private PopulationQueryEngine populationQueryEngine;
	
	@Override
	public CityStats getCityPopulation(String city) {
		CityStats cityStats = populationQueryEngine.findCityPopulation(city);
		return cityStats;
	}

}
