package org.impress.datahomogenization.ws.web.api;

import java.io.StringWriter;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import oasis.names.tc.ciq.xnl._3.OrganisationNameType;
import oasis.names.tc.emergency.edxl.have._1.HospitalStatus;
import oasis.names.tc.emergency.edxl.have._1.HospitalStatus.Hospital;
import oasis.names.tc.emergency.edxl.have._1.Organization;
import oasis.names.tc.emergency.edxl.have._1.OrganizationInformation;

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
		HospitalStatus hospitalStatus = new HospitalStatus();
		Hospital hospital = new Hospital();
		Organization organization = new Organization();
		OrganizationInformation organizationInformation = new OrganizationInformation();
		//organizationInformation.getOrganisationName().add(e);
		OrganisationNameType organisationNameType = new OrganisationNameType();		
		OrganisationNameType.NameElement nameElement = new OrganisationNameType.NameElement();
		nameElement.setValue("Evaggelismos");
		organisationNameType.getNameElement().add(nameElement);
		organizationInformation.getOrganisationName().add(organisationNameType);
		organization.setOrganizationInformation(organizationInformation);
		hospital.setOrganization(organization);
		GregorianCalendar c = new GregorianCalendar();
		XMLGregorianCalendar calendar=null;
		try {
			calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		hospital.setLastUpdateTime(calendar);
		hospitalStatus.getHospital().add(hospital);

		String response = "";
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(HospitalStatus.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw = new StringWriter();
			//jaxbMarshaller.marshal(capacity, sw);
			jaxbMarshaller.marshal(hospitalStatus, sw);
			response = sw.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error Marshalling XML Object", HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		//return new ResponseEntity<BedStats>(bedStats, HttpStatus.OK);
		return new ResponseEntity<String>(response, HttpStatus.OK);		
	}
}
