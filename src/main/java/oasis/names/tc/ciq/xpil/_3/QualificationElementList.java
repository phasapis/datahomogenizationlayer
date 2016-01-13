//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.23 at 05:44:00 PM EET 
//


package oasis.names.tc.ciq.xpil._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QualificationElementList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="QualificationElementList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="QualificationName"/>
 *     &lt;enumeration value="MajorSubject"/>
 *     &lt;enumeration value="MinorSubject"/>
 *     &lt;enumeration value="Grade"/>
 *     &lt;enumeration value="CourseDuration"/>
 *     &lt;enumeration value="CompletionDate"/>
 *     &lt;enumeration value="Award"/>
 *     &lt;enumeration value="Restriction"/>
 *     &lt;enumeration value="Registration"/>
 *     &lt;enumeration value="WayOfStudy"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "QualificationElementList")
@XmlEnum
public enum QualificationElementList {


    /**
     * Free text name of the qualification
     * 
     */
    @XmlEnumValue("QualificationName")
    QUALIFICATION_NAME("QualificationName"),

    /**
     * Name of the major subject of the qualification
     * 
     */
    @XmlEnumValue("MajorSubject")
    MAJOR_SUBJECT("MajorSubject"),

    /**
     * Name of a minor subject of the qualification
     * 
     */
    @XmlEnumValue("MinorSubject")
    MINOR_SUBJECT("MinorSubject"),

    /**
     * Grade (average?, percentage? ) achieved with the qualification.
     * 
     */
    @XmlEnumValue("Grade")
    GRADE("Grade"),

    /**
     * Free text description of the duration of the course, e.g. 4 years, 1 month, etc.
     * 
     */
    @XmlEnumValue("CourseDuration")
    COURSE_DURATION("CourseDuration"),

    /**
     * Free text description of the date when the qualification was completed to the best known precision.
     * 
     */
    @XmlEnumValue("CompletionDate")
    COMPLETION_DATE("CompletionDate"),

    /**
     * Award, or distinction that was awarded to the graduate, e.g. honors.
     * 
     */
    @XmlEnumValue("Award")
    AWARD("Award"),

    /**
     * Restrictions imposed on the graduate, e.g. not valid before completion of 2 year practical work under supervision.
     * 
     */
    @XmlEnumValue("Restriction")
    RESTRICTION("Restriction"),

    /**
     * Details of any professional registration if required for practicing, e.g. for pharmacists, electricians, medical professionals.
     * 
     */
    @XmlEnumValue("Registration")
    REGISTRATION("Registration"),

    /**
     * Full time, part time, evening classes, extramural, etc.
     * 
     */
    @XmlEnumValue("WayOfStudy")
    WAY_OF_STUDY("WayOfStudy");
    private final String value;

    QualificationElementList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static QualificationElementList fromValue(String v) {
        for (QualificationElementList c: QualificationElementList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
