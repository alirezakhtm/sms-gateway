
package ir.navaco.mcb.sms.gateway.consumer.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSTC_SMSReceive3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSTC_SMSReceive3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="STC_SMSReceive3" type="{http://tempuri.org/}STC_SMSReceive3" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSTC_SMSReceive3", propOrder = {
    "stcsmsReceive3"
})
public class ArrayOfSTCSMSReceive3 {

    @XmlElement(name = "STC_SMSReceive3", nillable = true)
    protected List<STCSMSReceive3> stcsmsReceive3;

    /**
     * Gets the value of the stcsmsReceive3 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stcsmsReceive3 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSTCSMSReceive3().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link STCSMSReceive3 }
     * 
     * 
     */
    public List<STCSMSReceive3> getSTCSMSReceive3() {
        if (stcsmsReceive3 == null) {
            stcsmsReceive3 = new ArrayList<STCSMSReceive3>();
        }
        return this.stcsmsReceive3;
    }

}
