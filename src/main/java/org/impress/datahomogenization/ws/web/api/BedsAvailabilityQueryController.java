package org.impress.datahomogenization.ws.web.api;

import org.impress.datahomogenization.ws.model.BedStats;
import org.impress.datahomogenization.ws.service.BedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BedsAvailabilityQueryController {
	@Autowired
	private BedsService bedService;
	
	@RequestMapping(
			value="/beds/available/{clinicId}", 
			method=RequestMethod.GET,
			produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<BedStats> getAvailableBeds(@PathVariable("clinicId") Integer clinicId) {	
		BedStats bedStats = bedService.getClinicAvailableBeds(clinicId);
		return new ResponseEntity<BedStats>(bedStats, HttpStatus.OK);
	}
}
