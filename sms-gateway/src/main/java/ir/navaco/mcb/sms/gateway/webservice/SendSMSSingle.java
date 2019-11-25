
package ir.navaco.mcb.sms.gateway.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="strMessageText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strRecipientNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strSenderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strNumberUsername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strNumberPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strNumberCompany" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "strMessageText",
    "strRecipientNumber",
    "strSenderNumber",
    "strNumberUsername",
    "strNumberPassword",
    "strNumberCompany",
    "strResultMessage"
})
@XmlRootElement(name = "SendSMS_Single")
public class SendSMSSingle {

    protected String strMessageText;
    protected String strRecipientNumber;
    protected String strSenderNumber;
    protected String strNumberUsername;
    protected String strNumberPassword;
    protected String strNumberCompany;
    protected String strResultMessage;

    /**
     * Gets the value of the strMessageText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrMessageText() {
        return strMessageText;
    }

    /**
     * Sets the value of the strMessageText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrMessageText(String value) {
        this.strMessageText = value;
    }

    /**
     * Gets the value of the strRecipientNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrRecipientNumber() {
        return strRecipientNumber;
    }

    /**
     * Sets the value of the strRecipientNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrRecipientNumber(String value) {
        this.strRecipientNumber = value;
    }

    /**
     * Gets the value of the strSenderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrSenderNumber() {
        return strSenderNumber;
    }

    /**
     * Sets the value of the strSenderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrSenderNumber(String value) {
        this.strSenderNumber = value;
    }

    /**
     * Gets the value of the strNumberUsername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrNumberUsername() {
        return strNumberUsername;
    }

    /**
     * Sets the value of the strNumberUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrNumberUsername(String value) {
        this.strNumberUsername = value;
    }

    /**
     * Gets the value of the strNumberPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrNumberPassword() {
        return strNumberPassword;
    }

    /**
     * Sets the value of the strNumberPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrNumberPassword(String value) {
        this.strNumberPassword = value;
    }

    /**
     * Gets the value of the strNumberCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrNumberCompany() {
        return strNumberCompany;
    }

    /**
     * Sets the value of the strNumberCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrNumberCompany(String value) {
        this.strNumberCompany = value;
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
