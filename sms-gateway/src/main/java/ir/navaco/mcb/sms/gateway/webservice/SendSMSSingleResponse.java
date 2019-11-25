
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
 *         &lt;element name="SendSMS_SingleResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "sendSMSSingleResult",
    "strResultMessage"
})
@XmlRootElement(name = "SendSMS_SingleResponse")
public class SendSMSSingleResponse {

    @XmlElement(name = "SendSMS_SingleResult")
    protected boolean sendSMSSingleResult;
    protected String strResultMessage;

    /**
     * Gets the value of the sendSMSSingleResult property.
     * 
     */
    public boolean isSendSMSSingleResult() {
        return sendSMSSingleResult;
    }

    /**
     * Sets the value of the sendSMSSingleResult property.
     * 
     */
    public void setSendSMSSingleResult(boolean value) {
        this.sendSMSSingleResult = value;
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
