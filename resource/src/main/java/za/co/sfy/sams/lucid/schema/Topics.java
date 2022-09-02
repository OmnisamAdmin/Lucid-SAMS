
package za.co.sfy.sams.lucid.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Name" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="200"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Key" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="50"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Code" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="50"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Group" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Selected" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Phase" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Afrname" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="200"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PrintOrder" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="CTAWeight" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ExcludeSchedule" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="LuritsCode" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="50"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SubjectStatus" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/&gt;
 *         &lt;element name="SubjectGrade" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="OfficialSubjectID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "MainTopicID",
    "MainPosition",
    "Description",
    "AfrDescription",
    "VernDescription",
    "SubjectID",
    "OfficialSubjectID",
    "RecLocked",
    "PatchVer",
    "GroupNo",
 
})
@XmlRootElement(name = "Subjects")
public class Topics {

    @XmlElement(name = "MainTopicID")
    protected int maintopicid;
    @XmlElement(name = "MainPosition")
    protected String mainposition;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "AfrDescription")
    protected String afrdescription;
    @XmlElement(name = "VernDescription")
    protected String verndescription;
    @XmlElement(name = "SubjectID")
    protected Integer subjectid;
    @XmlElement(name = "OfficialSubjectID")
    protected Integer officialsubjectid;
    @XmlElement(name = "RecLocked")
    protected String reclocked;
    @XmlElement(name = "PatchVer")
    protected String patchver;
    @XmlElement(name = "GroupNo")
    protected Integer groupno;
  

   
    public int getMainTopicID() {
        return maintopicid;
    }

   
    public void setMainTopicID(int value) {
        this.maintopicid = value;
    }

    
    public String getMainPosition() {
        return mainposition;
    }

    
    public void setMainPosition(String value) {
        this.mainposition = value;
    }

    
    public String getDescription() {
        return description;
    }

    
    public void setDescription(String value) {
        this.description = value;
    }

   
    public String getAfrDescription() {
        return afrdescription;
    }

   
    public void setAfrDescription(String value) {
        this.afrdescription = value;
    }

   
    public String getVernDescription() {
        return verndescription;
    }

   
    public void setVernDescription(String value) {
        this.verndescription = value;
    }

    
    public Integer getSubjectID() {
        return subjectid;
    }

    
    public void setSubjectID(Integer value) {
        this.subjectid = value;
    }

    
    public Integer getOfficialSubjectID() {
        return officialsubjectid;
    }

   
    public void setOfficialSubjectID(Integer value) {
        this.officialsubjectid = value;
    }

    
    public String getRecLocked() {
        return reclocked;
    }

    
    public void setRecLocked(String value) {
        this.reclocked = value;
    }

    public String getPatchVer() {
        return patchver;
    }

    
    public void setPatchVer(String value) {
        this.patchver = value;
    }

    
  public Integer getGroupNo() {
        return groupno;
    }

    
    public void setGroupNo(Integer value) {
        this.groupno = value;
    }

    }