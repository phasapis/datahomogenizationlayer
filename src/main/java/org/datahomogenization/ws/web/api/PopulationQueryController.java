package org.datahomogenization.ws.web.api;

import org.datahomogenization.ws.model.CityStats;
import org.datahomogenization.ws.service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PopulationQueryController {
	
	@Autowired
	private PopulationService populationService;
	
	@RequestMapping(
			value="/population/{cityName}", 
			method=RequestMethod.GET,
			produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<CityStats> getCityPopulation(@PathVariable("cityName") String cityName) {	
		CityStats cityStats = populationService.getCityPopulation(cityName);
		return new ResponseEntity<CityStats>(cityStats, HttpStatus.OK);
	}
}
