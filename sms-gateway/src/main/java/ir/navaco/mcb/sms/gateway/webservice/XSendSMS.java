
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
 *         &lt;element name="Input" type="{http://tempuri.org/}ArrayOfXMessage" minOccurs="0"/>
 *         &lt;element name="vUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vPass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vIPAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BatchID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vFarsi" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SetPriority" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vFlash" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "input",
    "vUser",
    "vPass",
    "vNumber",
    "vipAddress",
    "company",
    "batchID",
    "vFarsi",
    "setPriority",
    "vFlash"
})
@XmlRootElement(name = "XSendSMS")
public class XSendSMS {

    @XmlElement(name = "Input")
    protected ArrayOfXMessage input;
    protected String vUser;
    protected String vPass;
    protected String vNumber;
    @XmlElement(name = "vIPAddress")
    protected String vipAddress;
    @XmlElement(name = "Company")
    protected String company;
    @XmlElement(name = "BatchID")
    protected String batchID;
    protected boolean vFarsi;
    @XmlElement(name = "SetPriority")
    protected boolean setPriority;
    protected boolean vFlash;

    /**
     * Gets the value of the input property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfXMessage }
     *     
     */
    public ArrayOfXMessage getInput() {
        return input;
    }

    /**
     * Sets the value of the input property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfXMessage }
     *     
     */
    public void setInput(ArrayOfXMessage value) {
        this.input = value;
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

    /**
     * Gets the value of the batchID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchID() {
        return batchID;
    }

    /**
     * Sets the value of the batchID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchID(String value) {
        this.batchID = value;
    }

    /**
     * Gets the value of the vFarsi property.
     * 
     */
    public boolean isVFarsi() {
        return vFarsi;
    }

    /**
     * Sets the value of the vFarsi property.
     * 
     */
    public void setVFarsi(boolean value) {
        this.vFarsi = value;
    }

    /**
     * Gets the value of the setPriority property.
     * 
     */
    public boolean isSetPriority() {
        return setPriority;
    }

    /**
     * Sets the value of the setPriority property.
     * 
     */
    public void setSetPriority(boolean value) {
        this.setPriority = value;
    }

    /**
     * Gets the value of the vFlash property.
     * 
     */
    public boolean isVFlash() {
        return vFlash;
    }

    /**
     * Sets the value of the vFlash property.
     * 
     */
    public void setVFlash(boolean value) {
        this.vFlash = value;
    }

}
