package org.impress.datahomogenization.ws.service;

import java.util.Collection;
import java.util.List;

import org.impress.datahomogenization.ws.model.CityStats;
import org.impress.datahomogenization.ws.model.GeoPoint;

public interface PopulationService {
	CityStats getCityPopulation(String city);
	CityStats getPointPopulation(String lat, String lng);
	Collection<CityStats> getAreaPopulation(List<GeoPoint> points);
}
