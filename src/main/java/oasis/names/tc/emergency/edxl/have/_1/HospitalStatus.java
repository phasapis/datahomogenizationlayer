//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.23 at 05:44:00 PM EET 
//


package oasis.names.tc.emergency.edxl.have._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Hospital" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{urn:oasis:names:tc:emergency:EDXL:HAVE:1.0}Organization"/>
 *                   &lt;element name="EmergencyDepartmentStatus" type="{urn:oasis:names:tc:emergency:EDXL:HAVE:1.0}EmergencyDepartmentStatus" minOccurs="0"/>
 *                   &lt;element name="HospitalBedCapacityStatus" type="{urn:oasis:names:tc:emergency:EDXL:HAVE:1.0}HospitalBedCapacityStatus" minOccurs="0"/>
 *                   &lt;element name="ServiceCoverageStatus" type="{urn:oasis:names:tc:emergency:EDXL:HAVE:1.0}ServiceCoverageStatus" minOccurs="0"/>
 *                   &lt;element name="HospitalFacilityStatus" type="{urn:oasis:names:tc:emergency:EDXL:HAVE:1.0}HospitalFacilityStatus" minOccurs="0"/>
 *                   &lt;element name="HospitalResourcesStatus" type="{urn:oasis:names:tc:emergency:EDXL:HAVE:1.0}HospitalResourcesStatus" minOccurs="0"/>
 *                   &lt;element name="LastUpdateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "hospital"
})
@XmlRootElement(name = "HospitalStatus")
public class HospitalStatus {

    @XmlElement(name = "Hospital", required = true)
    protected List<HospitalStatus.Hospital> hospital;

    /**
     * Gets the value of the hospital property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hospital property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHospital().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HospitalStatus.Hospital }
     * 
     * 
     */
    public List<HospitalStatus.Hospital> getHospital() {
        if (hospital == null) {
            hospital = new ArrayList<HospitalStatus.Hospital>();
        }
        return this.hospital;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{urn:oasis:names:tc:emergency:EDXL:HAVE:1.0}Organization"/>
     *         &lt;element name="EmergencyDepartmentStatus" type="{urn:oasis:names:tc:emergency:EDXL:HAVE:1.0}EmergencyDepartmentStatus" minOccurs="0"/>
     *         &lt;element name="HospitalBedCapacityStatus" type="{urn:oasis:names:tc:emergency:EDXL:HAVE:1.0}HospitalBedCapacityStatus" minOccurs="0"/>
     *         &lt;element name="ServiceCoverageStatus" type="{urn:oasis:names:tc:emergency:EDXL:HAVE:1.0}ServiceCoverageStatus" minOccurs="0"/>
     *         &lt;element name="HospitalFacilityStatus" type="{urn:oasis:names:tc:emergency:EDXL:HAVE:1.0}HospitalFacilityStatus" minOccurs="0"/>
     *         &lt;element name="HospitalResourcesStatus" type="{urn:oasis:names:tc:emergency:EDXL:HAVE:1.0}HospitalResourcesStatus" minOccurs="0"/>
     *         &lt;element name="LastUpdateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "organization",
        "emergencyDepartmentStatus",
        "hospitalBedCapacityStatus",
        "serviceCoverageStatus",
        "hospitalFacilityStatus",
        "hospitalResourcesStatus",
        "lastUpdateTime"
    })
    public static class Hospital {

        @XmlElement(name = "Organization", required = true)
        protected Organization organization;
        @XmlElement(name = "EmergencyDepartmentStatus")
        protected EmergencyDepartmentStatus emergencyDepartmentStatus;
        @XmlElement(name = "HospitalBedCapacityStatus")
        protected HospitalBedCapacityStatus hospitalBedCapacityStatus;
        @XmlElement(name = "ServiceCoverageStatus")
        protected ServiceCoverageStatus serviceCoverageStatus;
        @XmlElement(name = "HospitalFacilityStatus")
        protected HospitalFacilityStatus hospitalFacilityStatus;
        @XmlElement(name = "HospitalResourcesStatus")
        protected HospitalResourcesStatus hospitalResourcesStatus;
        @XmlElement(name = "LastUpdateTime", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar lastUpdateTime;

        /**
         * The container element for organization information elements. The generic element Organisation refers to the entity that is providing the data. This generic name is used throughout this document. Typically, this will include hospitals, nursing care centers, trauma centers etc.
         * 
         * 
         * @return
         *     possible object is
         *     {@link Organization }
         *     
         */
        public Organization getOrganization() {
            return organization;
        }

        /**
         * Sets the value of the organization property.
         * 
         * @param value
         *     allowed object is
         *     {@link Organization }
         *     
         */
        public void setOrganization(Organization value) {
            this.organization = value;
        }

        /**
         * Gets the value of the emergencyDepartmentStatus property.
         * 
         * @return
         *     possible object is
         *     {@link EmergencyDepartmentStatus }
         *     
         */
        public EmergencyDepartmentStatus getEmergencyDepartmentStatus() {
            return emergencyDepartmentStatus;
        }

        /**
         * Sets the value of the emergencyDepartmentStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link EmergencyDepartmentStatus }
         *     
         */
        public void setEmergencyDepartmentStatus(EmergencyDepartmentStatus value) {
            this.emergencyDepartmentStatus = value;
        }

        /**
         * Gets the value of the hospitalBedCapacityStatus property.
         * 
         * @return
         *     possible object is
         *     {@link HospitalBedCapacityStatus }
         *     
         */
        public HospitalBedCapacityStatus getHospitalBedCapacityStatus() {
            return hospitalBedCapacityStatus;
        }

        /**
         * Sets the value of the hospitalBedCapacityStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link HospitalBedCapacityStatus }
         *     
         */
        public void setHospitalBedCapacityStatus(HospitalBedCapacityStatus value) {
            this.hospitalBedCapacityStatus = value;
        }

        /**
         * Gets the value of the serviceCoverageStatus property.
         * 
         * @return
         *     possible object is
         *     {@link ServiceCoverageStatus }
         *     
         */
        public ServiceCoverageStatus getServiceCoverageStatus() {
            return serviceCoverageStatus;
        }

        /**
         * Sets the value of the serviceCoverageStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link ServiceCoverageStatus }
         *     
         */
        public void setServiceCoverageStatus(ServiceCoverageStatus value) {
            this.serviceCoverageStatus = value;
        }

        /**
         * Gets the value of the hospitalFacilityStatus property.
         * 
         * @return
         *     possible object is
         *     {@link HospitalFacilityStatus }
         *     
         */
        public HospitalFacilityStatus getHospitalFacilityStatus() {
            return hospitalFacilityStatus;
        }

        /**
         * Sets the value of the hospitalFacilityStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link HospitalFacilityStatus }
         *     
         */
        public void setHospitalFacilityStatus(HospitalFacilityStatus value) {
            this.hospitalFacilityStatus = value;
        }

        /**
         * Gets the value of the hospitalResourcesStatus property.
         * 
         * @return
         *     possible object is
         *     {@link HospitalResourcesStatus }
         *     
         */
        public HospitalResourcesStatus getHospitalResourcesStatus() {
            return hospitalResourcesStatus;
        }

        /**
         * Sets the value of the hospitalResourcesStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link HospitalResourcesStatus }
         *     
         */
        public void setHospitalResourcesStatus(HospitalResourcesStatus value) {
            this.hospitalResourcesStatus = value;
        }

        /**
         * Gets the value of the lastUpdateTime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getLastUpdateTime() {
            return lastUpdateTime;
        }

        /**
         * Sets the value of the lastUpdateTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setLastUpdateTime(XMLGregorianCalendar value) {
            this.lastUpdateTime = value;
        }

    }

}
