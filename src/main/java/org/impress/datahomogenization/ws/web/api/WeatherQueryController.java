package org.impress.datahomogenization.ws.web.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherQueryController {
	@Value("${openweathermap.appkey}")
	private String appKey;
	@Value("${openweathermap.restendpoint}")
	private String endpoint;
	
	//
	//1st version:
	//Just return the response from open weather map for cities in rectangle
	//	
	@RequestMapping(
			value="/weather/area", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<String> getWeatherinRectangle(
			@RequestParam("lngLeft") String lngLeft,
			@RequestParam("latBottom") String latBottom,
			@RequestParam("lngRight") String lngRight,
			@RequestParam("latTop") String latTop) {
		RestTemplate restTemplate = new RestTemplate();
		String restEndpoint = endpoint+lngLeft+","+latBottom+","+lngRight+","+latTop+",100";
		restEndpoint += "&appid="+appKey;
		String response = restTemplate.getForObject(restEndpoint, String.class);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
