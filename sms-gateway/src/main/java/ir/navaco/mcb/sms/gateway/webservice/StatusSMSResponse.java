
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
 *         &lt;element name="StatusSMSResult" type="{http://tempuri.org/}ArrayOfSTC_SMSStatus" minOccurs="0"/>
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
    "statusSMSResult"
})
@XmlRootElement(name = "StatusSMSResponse")
public class StatusSMSResponse {

    @XmlElement(name = "StatusSMSResult")
    protected ArrayOfSTCSMSStatus statusSMSResult;

    /**
     * Gets the value of the statusSMSResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSTCSMSStatus }
     *     
     */
    public ArrayOfSTCSMSStatus getStatusSMSResult() {
        return statusSMSResult;
    }

    /**
     * Sets the value of the statusSMSResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSTCSMSStatus }
     *     
     */
    public void setStatusSMSResult(ArrayOfSTCSMSStatus value) {
        this.statusSMSResult = value;
    }

}
