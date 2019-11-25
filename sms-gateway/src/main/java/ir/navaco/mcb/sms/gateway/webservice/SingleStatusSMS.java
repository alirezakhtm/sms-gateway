
package ir.navaco.mcb.sms.gateway.webservice;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vPass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strSMSID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strResultMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "vUser",
    "vPass",
    "company",
    "strSMSID",
    "strResultMessage"
})
@XmlRootElement(name = "SingleStatusSMS")
public class SingleStatusSMS {

    protected String vUser;
    protected String vPass;
    @XmlElement(name = "Company")
    protected String company;
    protected String strSMSID;
    protected String strResultMessage;

    /**
     * Gets the value of the vUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVUser() {
        return vUser;
    }

    /**
     * Sets the value of the vUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVUser(String value) {
        this.vUser = value;
    }

    /**
     * Gets the value of the vPass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVPass() {
        return vPass;
    }

    /**
     * Sets the value of the vPass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVPass(String value) {
        this.vPass = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompany(String value) {
        this.company = value;
    }

    /**
     * Gets the value of the strSMSID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrSMSID() {
        return strSMSID;
    }

    /**
     * Sets the value of the strSMSID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrSMSID(String value) {
        this.strSMSID = value;
    }

    /**
     * Gets the value of the strResultMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrResultMessage() {
        return strResultMessage;
    }

    /**
     * Sets the value of the strResultMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrResultMessage(String value) {
        this.strResultMessage = value;
    }

}
