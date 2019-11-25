
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
 *         &lt;element name="XSendSMS2Result" type="{http://tempuri.org/}ArrayOfString" minOccurs="0"/>
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
    "xSendSMS2Result"
})
@XmlRootElement(name = "XSendSMS2Response")
public class XSendSMS2Response {

    @XmlElement(name = "XSendSMS2Result")
    protected ArrayOfString xSendSMS2Result;

    /**
     * Gets the value of the xSendSMS2Result property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getXSendSMS2Result() {
        return xSendSMS2Result;
    }

    /**
     * Sets the value of the xSendSMS2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setXSendSMS2Result(ArrayOfString value) {
        this.xSendSMS2Result = value;
    }

}
