package ir.navaco.mcb.sms.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IRestSMSResponse {
    private long id;
    private String requestId;
    private String accessId;
    private String msisdn;
    private String message;
    private String date;

    public IRestSMSResponse(){

    }

    public IRestSMSResponse(String requestId, String accessId, String msisdn, String message) {
        this.requestId = requestId;
        this.accessId = accessId;
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

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
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
