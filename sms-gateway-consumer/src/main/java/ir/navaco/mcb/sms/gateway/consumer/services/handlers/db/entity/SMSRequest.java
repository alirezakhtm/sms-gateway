package ir.navaco.mcb.sms.gateway.consumer.services.handlers.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(schema = "SMS_GATEWAY", name = "SMS_REQUEST", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "REQUEST_ID")
})
public class SMSRequest implements Serializable {

    public static final String SEQUENCE_NAME_GENERATOR = "SMS_REQUEST_SEQUENCE_NAME_GENERATOR";
    public static final String SEQUENCE_NAME_MAIN = "SMS_REQUEST_SEQUENCE_NAME_MAIN";

    @Id
    @SequenceGenerator(name = SEQUENCE_NAME_GENERATOR, sequenceName = SEQUENCE_NAME_MAIN,
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME_GENERATOR)
    @Column(name = "ID")
    private long id;
    @Column(name = "MSISDN", nullable = false)
    private String msisdn;
    @Column(name = "MESSAGE_CONTENT")
    private String messageContent;
    @Column(name = "REQUEST_ID", unique = true, nullable = false)
    private String requestId;
    @Column(name = "REQUEST_DATE", nullable = false)
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
