package ir.navaco.mcb.sms.common;

public class IRestSMSRequest {

    private String msisdn;
    private String messageContent;
    private String requestId;

    public IRestSMSRequest(){

    }

    public IRestSMSRequest(String msisdn, String messageContent, String requestId) {
        this.msisdn = msisdn;
        this.messageContent = messageContent;
        this.requestId = requestId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
