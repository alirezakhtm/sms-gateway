package ir.navaco.mcb.sms.gateway.services.handlers.db.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(schema = "dbsms", name = "SMS_REQUEST", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "REQUEST_ID")
})
public class SMSRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true)
    private long id;
    @Column(name = "MSISDN", nullable = false)
    private String msisdn;
    @Column(name = "MESSAGE_CONTENT")
    private String messageContent;
    @Column(name = "REQUEST_ID")
    private String requestId;
    @Column(name = "REQUEST_DATE")
    private String requestDate;

    public SMSRequest(){

    }

    public SMSRequest(String msisdn, String messageContent, String requestId) {
        this.msisdn = msisdn;
        this.messageContent = messageContent;
        this.requestId = requestId;
        this.requestDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }
}
