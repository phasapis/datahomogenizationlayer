//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.23 at 05:44:00 PM EET 
//


package oasis.names.tc.ciq.xpil._3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import oasis.names.tc.ciq.ct._3.DataQualityTypeList;
import oasis.names.tc.ciq.xal._3.AddressType;
import oasis.names.tc.ciq.xnl._3.OrganisationNameType;
import oasis.names.tc.ciq.xnl._3.PartyNameType;


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
 *         &lt;element name="Document" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DocumentElement" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;urn:oasis:names:tc:ciq:ct:3>String">
 *                           &lt;attribute name="Type" type="{urn:oasis:names:tc:ciq:xpil:3}DocumentElementList" />
 *                           &lt;anyAttribute processContents='lax' namespace='##other'/>
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="NameOnDocument" type="{urn:oasis:names:tc:ciq:xnl:3}PartyNameType" minOccurs="0"/>
 *                   &lt;element name="AddressOnDocument" type="{urn:oasis:names:tc:ciq:xal:3}AddressType" minOccurs="0"/>
 *                   &lt;element name="IssuerName" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{urn:oasis:names:tc:ciq:xnl:3}OrganisationNameType">
 *                           &lt;anyAttribute processContents='lax' namespace='##other'/>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attGroup ref="{urn:oasis:names:tc:ciq:ct:3}grDataQuality"/>
 *                 &lt;attGroup ref="{urn:oasis:names:tc:ciq:ct:3}grValidityDate"/>
 *                 &lt;attribute name="Type" type="{urn:oasis:names:tc:ciq:xpil:3}DocumentTypeList" />
 *                 &lt;attribute name="Status" type="{urn:oasis:names:tc:ciq:ct:3}StatusList" />
 *                 &lt;anyAttribute processContents='lax' namespace='##other'/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "document"
})
@XmlRootElement(name = "Documents")
public class Documents {

    @XmlElement(name = "Document", required = true)
    protected List<Documents.Document> document;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the document property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the document property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Documents.Document }
     * 
     * 
     */
    public List<Documents.Document> getDocument() {
        if (document == null) {
            document = new ArrayList<Documents.Document>();
        }
        return this.document;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
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
     *         &lt;element name="DocumentElement" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;urn:oasis:names:tc:ciq:ct:3>String">
     *                 &lt;attribute name="Type" type="{urn:oasis:names:tc:ciq:xpil:3}DocumentElementList" />
     *                 &lt;anyAttribute processContents='lax' namespace='##other'/>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="NameOnDocument" type="{urn:oasis:names:tc:ciq:xnl:3}PartyNameType" minOccurs="0"/>
     *         &lt;element name="AddressOnDocument" type="{urn:oasis:names:tc:ciq:xal:3}AddressType" minOccurs="0"/>
     *         &lt;element name="IssuerName" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{urn:oasis:names:tc:ciq:xnl:3}OrganisationNameType">
     *                 &lt;anyAttribute processContents='lax' namespace='##other'/>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attGroup ref="{urn:oasis:names:tc:ciq:ct:3}grDataQuality"/>
     *       &lt;attGroup ref="{urn:oasis:names:tc:ciq:ct:3}grValidityDate"/>
     *       &lt;attribute name="Type" type="{urn:oasis:names:tc:ciq:xpil:3}DocumentTypeList" />
     *       &lt;attribute name="Status" type="{urn:oasis:names:tc:ciq:ct:3}StatusList" />
     *       &lt;anyAttribute processContents='lax' namespace='##other'/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "documentElement",
        "nameOnDocument",
        "addressOnDocument",
        "issuerName"
    })
    public static class Document {

        @XmlElement(name = "DocumentElement")
        protected List<Documents.Document.DocumentElement> documentElement;
        @XmlElement(name = "NameOnDocument")
        protected PartyNameType nameOnDocument;
        @XmlElement(name = "AddressOnDocument")
        protected AddressType addressOnDocument;
        @XmlElement(name = "IssuerName")
        protected Documents.Document.IssuerName issuerName;
        @XmlAttribute(name = "Type", namespace = "urn:oasis:names:tc:ciq:xpil:3")
        protected DocumentTypeList type;
        @XmlAttribute(name = "Status", namespace = "urn:oasis:names:tc:ciq:xpil:3")
        protected String status;
        @XmlAttribute(name = "DataQualityType", namespace = "urn:oasis:names:tc:ciq:ct:3")
        protected DataQualityTypeList dataQualityType;
        @XmlAttribute(name = "ValidFrom", namespace = "urn:oasis:names:tc:ciq:ct:3")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar validFrom;
        @XmlAttribute(name = "ValidTo", namespace = "urn:oasis:names:tc:ciq:ct:3")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar validTo;
        @XmlAttribute(name = "DateValidFrom", namespace = "urn:oasis:names:tc:ciq:ct:3")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dateValidFrom;
        @XmlAttribute(name = "DateValidTo", namespace = "urn:oasis:names:tc:ciq:ct:3")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dateValidTo;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the documentElement property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the documentElement property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDocumentElement().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Documents.Document.DocumentElement }
         * 
         * 
         */
        public List<Documents.Document.DocumentElement> getDocumentElement() {
            if (documentElement == null) {
                documentElement = new ArrayList<Documents.Document.DocumentElement>();
            }
            return this.documentElement;
        }

        /**
         * Gets the value of the nameOnDocument property.
         * 
         * @return
         *     possible object is
         *     {@link PartyNameType }
         *     
         */
        public PartyNameType getNameOnDocument() {
            return nameOnDocument;
        }

        /**
         * Sets the value of the nameOnDocument property.
         * 
         * @param value
         *     allowed object is
         *     {@link PartyNameType }
         *     
         */
        public void setNameOnDocument(PartyNameType value) {
            this.nameOnDocument = value;
        }

        /**
         * Gets the value of the addressOnDocument property.
         * 
         * @return
         *     possible object is
         *     {@link AddressType }
         *     
         */
        public AddressType getAddressOnDocument() {
            return addressOnDocument;
        }

        /**
         * Sets the value of the addressOnDocument property.
         * 
         * @param value
         *     allowed object is
         *     {@link AddressType }
         *     
         */
        public void setAddressOnDocument(AddressType value) {
            this.addressOnDocument = value;
        }

        /**
         * Gets the value of the issuerName property.
         * 
         * @return
         *     possible object is
         *     {@link Documents.Document.IssuerName }
         *     
         */
        public Documents.Document.IssuerName getIssuerName() {
            return issuerName;
        }

        /**
         * Sets the value of the issuerName property.
         * 
         * @param value
         *     allowed object is
         *     {@link Documents.Document.IssuerName }
         *     
         */
        public void setIssuerName(Documents.Document.IssuerName value) {
            this.issuerName = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link DocumentTypeList }
         *     
         */
        public DocumentTypeList getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link DocumentTypeList }
         *     
         */
        public void setType(DocumentTypeList value) {
            this.type = value;
        }

        /**
         * Gets the value of the status property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatus() {
            return status;
        }

        /**
         * Sets the value of the status property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatus(String value) {
            this.status = value;
        }

        /**
         * Gets the value of the dataQualityType property.
         * 
         * @return
         *     possible object is
         *     {@link DataQualityTypeList }
         *     
         */
        public DataQualityTypeList getDataQualityType() {
            return dataQualityType;
        }

        /**
         * Sets the value of the dataQualityType property.
         * 
         * @param value
         *     allowed object is
         *     {@link DataQualityTypeList }
         *     
         */
        public void setDataQualityType(DataQualityTypeList value) {
            this.dataQualityType = value;
        }

        /**
         * Gets the value of the validFrom property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getValidFrom() {
            return validFrom;
        }

        /**
         * Sets the value of the validFrom property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setValidFrom(XMLGregorianCalendar value) {
            this.validFrom = value;
        }

        /**
         * Gets the value of the validTo property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getValidTo() {
            return validTo;
        }

        /**
         * Sets the value of the validTo property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setValidTo(XMLGregorianCalendar value) {
            this.validTo = value;
        }

        /**
         * Gets the value of the dateValidFrom property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDateValidFrom() {
            return dateValidFrom;
        }

        /**
         * Sets the value of the dateValidFrom property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDateValidFrom(XMLGregorianCalendar value) {
            this.dateValidFrom = value;
        }

        /**
         * Gets the value of the dateValidTo property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDateValidTo() {
            return dateValidTo;
        }

        /**
         * Sets the value of the dateValidTo property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDateValidTo(XMLGregorianCalendar value) {
            this.dateValidTo = value;
        }

        /**
         * Gets a map that contains attributes that aren't bound to any typed property on this class.
         * 
         * <p>
         * the map is keyed by the name of the attribute and 
         * the value is the string value of the attribute.
         * 
         * the map returned by this method is live, and you can add new attribute
         * by updating the map directly. Because of this design, there's no setter.
         * 
         * 
         * @return
         *     always non-null
         */
        public Map<QName, String> getOtherAttributes() {
            return otherAttributes;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;urn:oasis:names:tc:ciq:ct:3>String">
         *       &lt;attribute name="Type" type="{urn:oasis:names:tc:ciq:xpil:3}DocumentElementList" />
         *       &lt;anyAttribute processContents='lax' namespace='##other'/>
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class DocumentElement {

            @XmlValue
            @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
            protected String value;
            @XmlAttribute(name = "Type", namespace = "urn:oasis:names:tc:ciq:xpil:3")
            protected DocumentElementList type;
            @XmlAnyAttribute
            private Map<QName, String> otherAttributes = new HashMap<QName, String>();

            /**
             * Normalized and Collapsed String
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link DocumentElementList }
             *     
             */
            public DocumentElementList getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link DocumentElementList }
             *     
             */
            public void setType(DocumentElementList value) {
                this.type = value;
            }

            /**
             * Gets a map that contains attributes that aren't bound to any typed property on this class.
             * 
             * <p>
             * the map is keyed by the name of the attribute and 
             * the value is the string value of the attribute.
             * 
             * the map returned by this method is live, and you can add new attribute
             * by updating the map directly. Because of this design, there's no setter.
             * 
             * 
             * @return
             *     always non-null
             */
            public Map<QName, String> getOtherAttributes() {
                return otherAttributes;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{urn:oasis:names:tc:ciq:xnl:3}OrganisationNameType">
         *       &lt;anyAttribute processContents='lax' namespace='##other'/>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class IssuerName
            extends OrganisationNameType
        {


        }

    }

}
