
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
 *         &lt;element name="GetRemainCreditResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getRemainCreditResult",
    "strResultMessage"
})
@XmlRootElement(name = "GetRemainCreditResponse")
public class GetRemainCreditResponse {

    @XmlElement(name = "GetRemainCreditResult")
    protected String getRemainCreditResult;
    protected String strResultMessage;

    /**
     * Gets the value of the getRemainCreditResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetRemainCreditResult() {
        return getRemainCreditResult;
    }

    /**
     * Sets the value of the getRemainCreditResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetRemainCreditResult(String value) {
        this.getRemainCreditResult = value;
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
