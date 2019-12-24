
package ir.navaco.mcb.sms.gateway.consumer.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MaskanSMSServiceSoap", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MaskanSMSServiceSoap {


    /**
     * 
     * @param number
     * @param pass
     * @param ipAddress
     * @param company
     * @param servicePass
     * @param user
     * @param serviceUser
     * @return
     *     returns ir.navaco.mcb.sms.gateway.consumer.webservice.ArrayOfSTCSMSReceive3
     */
    @WebMethod(operationName = "ExtendReceiveSMS", action = "http://tempuri.org/ExtendReceiveSMS")
    @WebResult(name = "ExtendReceiveSMSResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ExtendReceiveSMS", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.ExtendReceiveSMS")
    @ResponseWrapper(localName = "ExtendReceiveSMSResponse", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.ExtendReceiveSMSResponse")
    public ArrayOfSTCSMSReceive3 extendReceiveSMS(
            @WebParam(name = "ServiceUser", targetNamespace = "http://tempuri.org/")
                    String serviceUser,
            @WebParam(name = "ServicePass", targetNamespace = "http://tempuri.org/")
                    String servicePass,
            @WebParam(name = "User", targetNamespace = "http://tempuri.org/")
                    String user,
            @WebParam(name = "Pass", targetNamespace = "http://tempuri.org/")
                    String pass,
            @WebParam(name = "Number", targetNamespace = "http://tempuri.org/")
                    String number,
            @WebParam(name = "IPAddress", targetNamespace = "http://tempuri.org/")
                    String ipAddress,
            @WebParam(name = "Company", targetNamespace = "http://tempuri.org/")
                    String company);

    /**
     * 
     * @param vPass
     * @param strResultMessage
     * @param vUser
     * @param company
     * @param getRemainCreditResult
     */
    @WebMethod(operationName = "GetRemainCredit", action = "http://tempuri.org/GetRemainCredit")
    @RequestWrapper(localName = "GetRemainCredit", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.GetRemainCredit")
    @ResponseWrapper(localName = "GetRemainCreditResponse", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.GetRemainCreditResponse")
    public void getRemainCredit(
            @WebParam(name = "vUser", targetNamespace = "http://tempuri.org/")
                    String vUser,
            @WebParam(name = "vPass", targetNamespace = "http://tempuri.org/")
                    String vPass,
            @WebParam(name = "Company", targetNamespace = "http://tempuri.org/")
                    String company,
            @WebParam(name = "strResultMessage", targetNamespace = "http://tempuri.org/", mode = WebParam.Mode.INOUT)
                    Holder<String> strResultMessage,
            @WebParam(name = "GetRemainCreditResult", targetNamespace = "http://tempuri.org/", mode = WebParam.Mode.OUT)
                    Holder<String> getRemainCreditResult);

    /**
     * 
     * @param vNumber
     * @param arrRecipientNumbers
     * @param vPass
     * @param vUser
     * @param arrMessages
     * @param company
     * @param vIPAddress
     * @return
     *     returns ir.navaco.mcb.sms.gateway.consumer.webservice.ArrayOfString
     */
    @WebMethod(operationName = "LikeSendSMS", action = "http://tempuri.org/LikeSendSMS")
    @WebResult(name = "LikeSendSMSResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "LikeSendSMS", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.LikeSendSMS")
    @ResponseWrapper(localName = "LikeSendSMSResponse", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.LikeSendSMSResponse")
    public ArrayOfString likeSendSMS(
            @WebParam(name = "arrMessages", targetNamespace = "http://tempuri.org/")
                    ArrayOfString arrMessages,
            @WebParam(name = "arrRecipientNumbers", targetNamespace = "http://tempuri.org/")
                    ArrayOfString arrRecipientNumbers,
            @WebParam(name = "vUser", targetNamespace = "http://tempuri.org/")
                    String vUser,
            @WebParam(name = "vPass", targetNamespace = "http://tempuri.org/")
                    String vPass,
            @WebParam(name = "vNumber", targetNamespace = "http://tempuri.org/")
                    String vNumber,
            @WebParam(name = "vIPAddress", targetNamespace = "http://tempuri.org/")
                    String vIPAddress,
            @WebParam(name = "Company", targetNamespace = "http://tempuri.org/")
                    String company);

    /**
     * 
     * @param vNumber
     * @param vFlash
     * @param destinationAddress
     * @param vPass
     * @param vFarsi
     * @param vUser
     * @param company
     * @param vIPAddress
     * @param message
     * @param batchID
     * @param setPriority
     * @return
     *     returns ir.navaco.mcb.sms.gateway.consumer.webservice.ArrayOfString
     */
    @WebMethod(operationName = "SendSMS", action = "http://tempuri.org/SendSMS")
    @WebResult(name = "SendSMSResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "SendSMS", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.SendSMS")
    @ResponseWrapper(localName = "SendSMSResponse", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.SendSMSResponse")
    public ArrayOfString sendSMS(
            @WebParam(name = "Message", targetNamespace = "http://tempuri.org/")
                    String message,
            @WebParam(name = "DestinationAddress", targetNamespace = "http://tempuri.org/")
                    ArrayOfString destinationAddress,
            @WebParam(name = "vUser", targetNamespace = "http://tempuri.org/")
                    String vUser,
            @WebParam(name = "vPass", targetNamespace = "http://tempuri.org/")
                    String vPass,
            @WebParam(name = "vNumber", targetNamespace = "http://tempuri.org/")
                    String vNumber,
            @WebParam(name = "vIPAddress", targetNamespace = "http://tempuri.org/")
                    String vIPAddress,
            @WebParam(name = "Company", targetNamespace = "http://tempuri.org/")
                    String company,
            @WebParam(name = "BatchID", targetNamespace = "http://tempuri.org/")
                    String batchID,
            @WebParam(name = "vFarsi", targetNamespace = "http://tempuri.org/")
                    boolean vFarsi,
            @WebParam(name = "SetPriority", targetNamespace = "http://tempuri.org/")
                    boolean setPriority,
            @WebParam(name = "vFlash", targetNamespace = "http://tempuri.org/")
                    boolean vFlash);

    /**
     * 
     * @param strNumberCompany
     * @param strResultMessage
     * @param strRecipientNumber
     * @param strMessageText
     * @param strNumberUsername
     * @param strNumberPassword
     * @param sendSMSSingleResult
     * @param strSenderNumber
     */
    @WebMethod(operationName = "SendSMS_Single", action = "http://tempuri.org/SendSMS_Single")
    @RequestWrapper(localName = "SendSMS_Single", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.SendSMSSingle")
    @ResponseWrapper(localName = "SendSMS_SingleResponse", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.SendSMSSingleResponse")
    public void sendSMSSingle(
            @WebParam(name = "strMessageText", targetNamespace = "http://tempuri.org/")
                    String strMessageText,
            @WebParam(name = "strRecipientNumber", targetNamespace = "http://tempuri.org/")
                    String strRecipientNumber,
            @WebParam(name = "strSenderNumber", targetNamespace = "http://tempuri.org/")
                    String strSenderNumber,
            @WebParam(name = "strNumberUsername", targetNamespace = "http://tempuri.org/")
                    String strNumberUsername,
            @WebParam(name = "strNumberPassword", targetNamespace = "http://tempuri.org/")
                    String strNumberPassword,
            @WebParam(name = "strNumberCompany", targetNamespace = "http://tempuri.org/")
                    String strNumberCompany,
            @WebParam(name = "strResultMessage", targetNamespace = "http://tempuri.org/", mode = WebParam.Mode.INOUT)
                    Holder<String> strResultMessage,
            @WebParam(name = "SendSMS_SingleResult", targetNamespace = "http://tempuri.org/", mode = WebParam.Mode.OUT)
                    Holder<Boolean> sendSMSSingleResult);

    /**
     * 
     * @param vPass
     * @param strResultMessage
     * @param vUser
     * @param company
     * @param strSMSID
     * @param singleStatusSMSResult
     */
    @WebMethod(operationName = "SingleStatusSMS", action = "http://tempuri.org/SingleStatusSMS")
    @RequestWrapper(localName = "SingleStatusSMS", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.SingleStatusSMS")
    @ResponseWrapper(localName = "SingleStatusSMSResponse", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.SingleStatusSMSResponse")
    public void singleStatusSMS(
            @WebParam(name = "vUser", targetNamespace = "http://tempuri.org/")
                    String vUser,
            @WebParam(name = "vPass", targetNamespace = "http://tempuri.org/")
                    String vPass,
            @WebParam(name = "Company", targetNamespace = "http://tempuri.org/")
                    String company,
            @WebParam(name = "strSMSID", targetNamespace = "http://tempuri.org/")
                    String strSMSID,
            @WebParam(name = "strResultMessage", targetNamespace = "http://tempuri.org/", mode = WebParam.Mode.INOUT)
                    Holder<String> strResultMessage,
            @WebParam(name = "SingleStatusSMSResult", targetNamespace = "http://tempuri.org/", mode = WebParam.Mode.OUT)
                    Holder<ArrayOfAnyType> singleStatusSMSResult);

    /**
     * 
     * @param vNumber
     * @param vPass
     * @param vPort
     * @param vUser
     * @param company
     * @param vIPAddress
     * @param batchId
     * @return
     *     returns ir.navaco.mcb.sms.gateway.consumer.webservice.ArrayOfSTCSMSStatus
     */
    @WebMethod(operationName = "StatusSMS", action = "http://tempuri.org/StatusSMS")
    @WebResult(name = "StatusSMSResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "StatusSMS", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.StatusSMS")
    @ResponseWrapper(localName = "StatusSMSResponse", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.StatusSMSResponse")
    public ArrayOfSTCSMSStatus statusSMS(
            @WebParam(name = "vUser", targetNamespace = "http://tempuri.org/")
                    String vUser,
            @WebParam(name = "vPass", targetNamespace = "http://tempuri.org/")
                    String vPass,
            @WebParam(name = "vNumber", targetNamespace = "http://tempuri.org/")
                    String vNumber,
            @WebParam(name = "vIPAddress", targetNamespace = "http://tempuri.org/")
                    String vIPAddress,
            @WebParam(name = "vPort", targetNamespace = "http://tempuri.org/")
                    String vPort,
            @WebParam(name = "Company", targetNamespace = "http://tempuri.org/")
                    String company,
            @WebParam(name = "BatchId", targetNamespace = "http://tempuri.org/")
                    String batchId);

    /**
     * 
     * @param input
     * @param vNumber
     * @param vFlash
     * @param vPass
     * @param vFarsi
     * @param vUser
     * @param company
     * @param vIPAddress
     * @param batchID
     * @param setPriority
     * @return
     *     returns ir.navaco.mcb.sms.gateway.consumer.webservice.ArrayOfString
     */
    @WebMethod(operationName = "XSendSMS", action = "http://tempuri.org/XSendSMS")
    @WebResult(name = "XSendSMSResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "XSendSMS", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.XSendSMS")
    @ResponseWrapper(localName = "XSendSMSResponse", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.XSendSMSResponse")
    public ArrayOfString xSendSMS(
            @WebParam(name = "Input", targetNamespace = "http://tempuri.org/")
                    ArrayOfXMessage input,
            @WebParam(name = "vUser", targetNamespace = "http://tempuri.org/")
                    String vUser,
            @WebParam(name = "vPass", targetNamespace = "http://tempuri.org/")
                    String vPass,
            @WebParam(name = "vNumber", targetNamespace = "http://tempuri.org/")
                    String vNumber,
            @WebParam(name = "vIPAddress", targetNamespace = "http://tempuri.org/")
                    String vIPAddress,
            @WebParam(name = "Company", targetNamespace = "http://tempuri.org/")
                    String company,
            @WebParam(name = "BatchID", targetNamespace = "http://tempuri.org/")
                    String batchID,
            @WebParam(name = "vFarsi", targetNamespace = "http://tempuri.org/")
                    boolean vFarsi,
            @WebParam(name = "SetPriority", targetNamespace = "http://tempuri.org/")
                    boolean setPriority,
            @WebParam(name = "vFlash", targetNamespace = "http://tempuri.org/")
                    boolean vFlash);

    /**
     * 
     * @param input
     * @param vNumber
     * @param vFlash
     * @param vPass
     * @param vFarsi
     * @param vUser
     * @param company
     * @param vIPAddress
     * @param batchID
     * @param setPriority
     * @return
     *     returns ir.navaco.mcb.sms.gateway.consumer.webservice.ArrayOfString
     */
    @WebMethod(operationName = "XSendSMS2", action = "http://tempuri.org/XSendSMS2")
    @WebResult(name = "XSendSMS2Result", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "XSendSMS2", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.XSendSMS2")
    @ResponseWrapper(localName = "XSendSMS2Response", targetNamespace = "http://tempuri.org/", className = "ir.navaco.mcb.sms.gateway.consumer.webservice.XSendSMS2Response")
    public ArrayOfString xSendSMS2(
            @WebParam(name = "Input", targetNamespace = "http://tempuri.org/")
                    ArrayOfXMessage input,
            @WebParam(name = "vUser", targetNamespace = "http://tempuri.org/")
                    String vUser,
            @WebParam(name = "vPass", targetNamespace = "http://tempuri.org/")
                    String vPass,
            @WebParam(name = "vNumber", targetNamespace = "http://tempuri.org/")
                    String vNumber,
            @WebParam(name = "vIPAddress", targetNamespace = "http://tempuri.org/")
                    String vIPAddress,
            @WebParam(name = "Company", targetNamespace = "http://tempuri.org/")
                    String company,
            @WebParam(name = "BatchID", targetNamespace = "http://tempuri.org/")
                    String batchID,
            @WebParam(name = "vFarsi", targetNamespace = "http://tempuri.org/")
                    boolean vFarsi,
            @WebParam(name = "SetPriority", targetNamespace = "http://tempuri.org/")
                    boolean setPriority,
            @WebParam(name = "vFlash", targetNamespace = "http://tempuri.org/")
                    boolean vFlash);

}
