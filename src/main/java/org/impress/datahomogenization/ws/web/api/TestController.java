package org.impress.datahomogenization.ws.web.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@Value("${sparql.endpoint}")
	private String endpoint;	
	@RequestMapping(
			value="/test/{paramName}", 
			method=RequestMethod.GET, 
			produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> testWParam(@PathVariable("paramName") String paramName) {	
		//String queryString = "select distinct <city_param> ?c where {?a <http://www.geonames.org/ontology#population> ?c}";
		String returnString="";

		//Query query = QueryFactory.create(queryString);
		/*  try (QueryExecution qexec = QueryExecutionFactory.sparqlService(endpoint, query)) {
			    ResultSet results = qexec.execSelect() ;
			    for ( ; results.hasNext() ; )
			    {
			      QuerySolution soln = results.nextSolution();
			      
			      Literal l = soln.getLiteral("c") ;   // Get a result variable - must be a literal
			      returnString+= (l+" ");
			    }
			  }		
			  */
		return new ResponseEntity<String>("Hello "+returnString, HttpStatus.OK);
	}
}
