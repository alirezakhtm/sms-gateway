
package ir.navaco.mcb.sms.gateway.consumer.webservice;

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
 *         &lt;element name="ExtendReceiveSMSResult" type="{http://tempuri.org/}ArrayOfSTC_SMSReceive3" minOccurs="0"/>
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
    "extendReceiveSMSResult"
})
@XmlRootElement(name = "ExtendReceiveSMSResponse")
public class ExtendReceiveSMSResponse {

    @XmlElement(name = "ExtendReceiveSMSResult")
    protected ArrayOfSTCSMSReceive3 extendReceiveSMSResult;

    /**
     * Gets the value of the extendReceiveSMSResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSTCSMSReceive3 }
     *     
     */
    public ArrayOfSTCSMSReceive3 getExtendReceiveSMSResult() {
        return extendReceiveSMSResult;
    }

    /**
     * Sets the value of the extendReceiveSMSResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSTCSMSReceive3 }
     *     
     */
    public void setExtendReceiveSMSResult(ArrayOfSTCSMSReceive3 value) {
        this.extendReceiveSMSResult = value;
    }

}
