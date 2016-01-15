package org.impress.datahomogenization.ws.service;

import java.util.Collection;
import java.util.List;

import org.impress.datahomogenization.ws.model.CityStats;
import org.impress.datahomogenization.ws.model.GeoPoint;
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
	@Override
	public CityStats getPointPopulation(String lat, String lng) {
		CityStats cityStats = populationQueryEngine.findPointPopulation(lat, lng);
		return cityStats;
	}
	@Override
	public Collection<CityStats> getAreaPopulation(List<GeoPoint> points) {
		Collection<CityStats> cityStats = populationQueryEngine.findAreaPopulation(points);
		return cityStats;
	}

}
