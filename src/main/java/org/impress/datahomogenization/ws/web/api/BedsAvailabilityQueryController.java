package org.impress.datahomogenization.ws.web.api;

import java.io.StringWriter;
import java.math.BigInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

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

import oasis.names.tc.emergency.edxl.have._1.Capacity;

@RestController
public class BedsAvailabilityQueryController {
	@Autowired
	private BedsService bedService;
	
	@RequestMapping(
			value="/beds/available/{clinicId}", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BedStats> getAvailableBedsJson(@PathVariable("clinicId") Integer clinicId) {	
		BedStats bedStats = bedService.getClinicAvailableBeds(clinicId);
		return new ResponseEntity<BedStats>(bedStats, HttpStatus.OK);
	}
	@RequestMapping(
			value="/beds/available/{clinicId}", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> getAvailableBedsXML(@PathVariable("clinicId") Integer clinicId) {	
		BedStats bedStats = bedService.getClinicAvailableBeds(clinicId);
		Capacity capacity = new Capacity();
		capacity.setAvailableCount(BigInteger.valueOf(bedStats.getAvailabeBeds()));
		String response = "";
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Capacity.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw = new StringWriter();
			//jaxbMarshaller.marshal(capacity, sw);
			jaxbMarshaller.marshal(
					new JAXBElement<Capacity>(new QName("","rootTag"),Capacity.class, capacity), sw);
			response = sw.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error Marshalling XML Object", HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		//return new ResponseEntity<BedStats>(bedStats, HttpStatus.OK);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}	
}
