package ir.navaco.mcb.sms.gateway.services.handlers.db.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "SMS_RESPONSE", schema = "dbsms", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "REQUEST_ID"),
        @UniqueConstraint(columnNames = "ACCESS_ID")
})
public class SMSResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true)
    private long id;
    @Column(name = "REQUEST_ID", nullable = false, unique = true)
    private String requestId;
    @Column(name = "ACCESS_ID", nullable = false, unique = true)
    private String accessId;
    @Column(name = "MSISDN", nullable = false)
    private String msisdn;
    @Column(name = "MESSAGE_CONTENT")
    private String message;
    @Column(name = "DATE_RESPONSE")
    private String date;
    @Column(name = "STATUS")
    private String status;

    public SMSResponse(){

    }

    public SMSResponse(String requestId, String accessId, String msisdn, String message) {
        this.requestId = requestId;
        this.accessId = accessId;
        this.msisdn = msisdn;
        this.message = message;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
        this.status = "PROGRESSING";
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
