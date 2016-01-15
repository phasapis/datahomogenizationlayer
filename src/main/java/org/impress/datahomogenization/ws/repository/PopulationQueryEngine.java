package org.impress.datahomogenization.ws.repository;

import java.io.File;
import java.io.IOException;
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
import org.impress.datahomogenization.ws.model.CityStats;
import org.impress.datahomogenization.ws.model.GeoPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class PopulationQueryEngine {
	private String queryTemplate;
	@Value("${sparql.endpoint}")
	private String endpoint;	
	public CityStats findCityPopulation(String city) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("sparqlQueries/CityPopulationQuery").getFile());
		try {
			queryTemplate = FileUtils.readFileToString(file);
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
			
		
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public CityStats findPointPopulation(String lat, String lng) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("sparqlQueries/PointPopulationQuery").getFile());
		try {
			queryTemplate = FileUtils.readFileToString(file);
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
			
		
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public Collection<CityStats> findAreaPopulation(List<GeoPoint> points) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("sparqlQueries/BoxPopulationQuery").getFile());
		try {
			queryTemplate = FileUtils.readFileToString(file);
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
			
		
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}			
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
