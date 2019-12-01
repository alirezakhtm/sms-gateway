package ir.navaco.mcb.sms.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IRestSMSResponse {
    private long id;
    private String requestId;
    private String referenceId;
    private String msisdn;
    private String message;
    private String date;

    public IRestSMSResponse(){

    }

    public IRestSMSResponse(String requestId, String referenceId, String msisdn, String message) {
        this.requestId = requestId;
        this.referenceId = referenceId;
        this.msisdn = msisdn;
        this.message = message;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
