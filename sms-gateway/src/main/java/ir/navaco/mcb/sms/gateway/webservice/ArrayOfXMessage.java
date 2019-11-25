
package ir.navaco.mcb.sms.gateway.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfXMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfXMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="XMessage" type="{http://tempuri.org/}XMessage" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfXMessage", propOrder = {
    "xMessage"
})
public class ArrayOfXMessage {

    @XmlElement(name = "XMessage", nillable = true)
    protected List<XMessage> xMessage;

    /**
     * Gets the value of the xMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the xMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getXMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XMessage }
     * 
     * 
     */
    public List<XMessage> getXMessage() {
        if (xMessage == null) {
            xMessage = new ArrayList<XMessage>();
        }
        return this.xMessage;
    }

}
