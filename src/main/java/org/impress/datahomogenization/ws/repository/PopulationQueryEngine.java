package org.impress.datahomogenization.ws.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.impress.datahomogenization.ws.model.Building;
import org.impress.datahomogenization.ws.model.CityStats;
import org.impress.datahomogenization.ws.model.GeoPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class PopulationQueryEngine {
	private String queryTemplate;
	@Value("${sparql.endpoint}")
	private String endpoint;	
	public CityStats findCityPopulation(String city) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext();
		org.springframework.core.io.Resource resource = appContext.getResource(
				"classpath:sparqlQueries/CityPopulationQuery");
		try {
			  InputStream is = resource.getInputStream();
	          BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        	
	          String line;
	          queryTemplate="";
	          while ((line = br.readLine()) != null) {
	             queryTemplate+=line+"\n";
	       	  } 
	          br.close();			
		} catch (IOException e1) {			
			e1.printStackTrace();
			return null;
		}
		List<String> params = new ArrayList<String>();
		params.add(city);
		String sparqlQuery = prepareQuery(queryTemplate, params);
		Query query = QueryFactory.create(sparqlQuery);
		QueryExecution qexec = QueryExecutionFactory.sparqlService(endpoint, query);
	    ResultSet results = qexec.execSelect() ;
	    if (results.hasNext() )
	    {
	      QuerySolution soln = results.nextSolution();
	      
	      Literal l = soln.getLiteral("population") ;   // Get a result variable - must be a literal
	      CityStats cityStats = new CityStats();
	      cityStats.setName(city);
	      cityStats.setPopulation((Integer) l.getValue());
	      return cityStats;
	    } else {
	    	return null;
	    }
			
	}
	public CityStats findPointPopulation(String lat, String lng) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext();
		org.springframework.core.io.Resource resource = appContext.getResource(
				"classpath:sparqlQueries/PointPopulationQuery");
		try {
			  InputStream is = resource.getInputStream();
	          BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        	
	          String line;
	          queryTemplate="";
	          while ((line = br.readLine()) != null) {
	             queryTemplate+=line+"\n";
	       	  } 
	          br.close();			
		} catch (IOException e1) {			
			e1.printStackTrace();
			return null;
		}
		List<String> params = new ArrayList<String>();
		params.add(lat); params.add(lat);params.add(lng);params.add(lng);
		String sparqlQuery = prepareQuery(queryTemplate, params);
		System.out.println(sparqlQuery);
		Query query = QueryFactory.create(sparqlQuery);
		QueryExecution qexec = QueryExecutionFactory.sparqlService(endpoint, query);
	    ResultSet results = qexec.execSelect() ;
	    if (results.hasNext() )
	    {
	      QuerySolution soln = results.nextSolution();
	      
	      Literal l = soln.getLiteral("population") ;   // Get a result variable - must be a literal
	      CityStats cityStats = new CityStats();
	      cityStats.setName((String) soln.getResource("cityURI").getURI());
	      cityStats.setPopulation((Integer) l.getValue());
	      return cityStats;
	    } else {
	    	return null;
	    }		
	}
	
	public Collection<CityStats> findAreaPopulation(List<GeoPoint> points) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext();
		org.springframework.core.io.Resource resource = appContext.getResource(
				"classpath:sparqlQueries/BoxPopulationQuery");
		try {
			  InputStream is = resource.getInputStream();
	          BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        	
	          String line;
	          queryTemplate="";
	          while ((line = br.readLine()) != null) {
	             queryTemplate+=line+"\n";
	       	  } 
	          br.close();			
		} catch (IOException e1) {			
			e1.printStackTrace();
			return null;
		}
		List<String> params = new ArrayList<String>();
		for (GeoPoint point : points) {
			params.add(point.getLat());
			params.add(point.getLng());
		}
		String sparqlQuery = prepareQuery(queryTemplate, params);
		System.out.println(sparqlQuery);
		Query query = QueryFactory.create(sparqlQuery);
		QueryExecution qexec = QueryExecutionFactory.sparqlService(endpoint, query);
	    ResultSet results = qexec.execSelect() ;
	    Collection<CityStats> cityStatsCollection = new ArrayList<CityStats>();
	    while (results.hasNext() )
	    {
	      QuerySolution soln = results.nextSolution();
	      
	      Literal l = soln.getLiteral("population") ;   // Get a result variable - must be a literal
	      CityStats cityStats = new CityStats();
	      cityStats.setName((String) soln.getResource("city").getURI());
	      cityStats.setPopulation((Integer) l.getValue());
	      cityStatsCollection.add(cityStats);
	    } 
	    return cityStatsCollection;
					
	}
	public Collection<Building> findAreaBuildings(List<GeoPoint> points, String type) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext();
		org.springframework.core.io.Resource resource = appContext.getResource(
				"classpath:sparqlQueries/BuildingsInBoxQuery");
		try {
			  InputStream is = resource.getInputStream();
	          BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        	
	          String line;
	          queryTemplate="";
	          while ((line = br.readLine()) != null) {
	             queryTemplate+=line+"\n";
	       	  } 
	          br.close();			
		} catch (IOException e1) {			
			e1.printStackTrace();
			return null;
		}
		List<String> params = new ArrayList<String>();
		params.add(type.substring(0, 1).toUpperCase() + type.substring(1));
		for (GeoPoint point : points) {
			params.add(point.getLat());
			params.add(point.getLng());
		}
		String sparqlQuery = prepareQuery(queryTemplate, params);
		System.out.println(sparqlQuery);
		Query query = QueryFactory.create(sparqlQuery);
		QueryExecution qexec = QueryExecutionFactory.sparqlService(endpoint, query);
	    ResultSet results = qexec.execSelect() ;
	    Collection<Building> buildingsCollection = new ArrayList<Building>();
	    while (results.hasNext() )
	    {
	      QuerySolution soln = results.nextSolution();
	      	      
	      Building building = new Building();
	      building.setArtifact((String) soln.getResource("building").getURI());
	      GeoPoint geopoint = new GeoPoint(
	    		  soln.getLiteral("lat").getString(),
	    		  soln.getLiteral("long").getString());
	      building.setCoords(geopoint);
	      buildingsCollection.add(building);
	    } 
	    return buildingsCollection;					
	}	
	private String prepareQuery(String query, List<String> params) {
		Pattern pattern = Pattern.compile("\\[(.+?)\\]");
		Matcher matcher = pattern.matcher(query);
		StringBuffer buffer = new StringBuffer();
		int pos=0;
		while (matcher.find()) {
			String replacement = params.get(pos);
			if (replacement != null) {

				matcher.appendReplacement(buffer, "");
				buffer.append(replacement);
			}
			pos++;
		}
		matcher.appendTail(buffer);
		return buffer.toString();		
	}
}
