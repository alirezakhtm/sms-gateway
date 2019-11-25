
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
 *         &lt;element name="arrMessages" type="{http://tempuri.org/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="arrRecipientNumbers" type="{http://tempuri.org/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="vUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vPass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vIPAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "arrMessages",
    "arrRecipientNumbers",
    "vUser",
    "vPass",
    "vNumber",
    "vipAddress",
    "company"
})
@XmlRootElement(name = "LikeSendSMS")
public class LikeSendSMS {

    protected ArrayOfString arrMessages;
    protected ArrayOfString arrRecipientNumbers;
    protected String vUser;
    protected String vPass;
    protected String vNumber;
    @XmlElement(name = "vIPAddress")
    protected String vipAddress;
    @XmlElement(name = "Company")
    protected String company;

    /**
     * Gets the value of the arrMessages property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getArrMessages() {
        return arrMessages;
    }

    /**
     * Sets the value of the arrMessages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setArrMessages(ArrayOfString value) {
        this.arrMessages = value;
    }

    /**
     * Gets the value of the arrRecipientNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getArrRecipientNumbers() {
        return arrRecipientNumbers;
    }

    /**
     * Sets the value of the arrRecipientNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setArrRecipientNumbers(ArrayOfString value) {
        this.arrRecipientNumbers = value;
    }

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
     * Gets the value of the vNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVNumber() {
        return vNumber;
    }

    /**
     * Sets the value of the vNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVNumber(String value) {
        this.vNumber = value;
    }

    /**
     * Gets the value of the vipAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVIPAddress() {
        return vipAddress;
    }

    /**
     * Sets the value of the vipAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVIPAddress(String value) {
        this.vipAddress = value;
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

}
