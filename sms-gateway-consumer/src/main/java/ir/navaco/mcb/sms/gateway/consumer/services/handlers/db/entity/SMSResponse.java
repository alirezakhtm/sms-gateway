package ir.navaco.mcb.sms.gateway.consumer.services.handlers.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(schema = "SMS_GATEWAY", name = "SMS_RESPONSE", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "REQUEST_ID"),
        @UniqueConstraint(columnNames = "REFERENCE_ID")
})
public class SMSResponse implements Serializable {

    public static final String SEQUENCE_NAME_GENERATOR = "SMS_RESPONSE_SEQUENCE_NAME_GENERATOR";
    public static final String SEQUENCE_NAME_MAIN = "SMS_RESPONSE_SEQUENCE_NAME_MAIN";


    @Id
    @SequenceGenerator(name = SEQUENCE_NAME_GENERATOR, sequenceName = SEQUENCE_NAME_MAIN,
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME_GENERATOR)
    @Column(name = "ID")
    private long id;
    @Column(name = "REQUEST_ID", nullable = false, unique = true)
    private String requestId;
    @Column(name = "REFERENCE_ID", nullable = false, unique = true)
    private String referenceId;
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

    public SMSResponse(String requestId, String referenceId, String msisdn, String message) {
        this.requestId = requestId;
        this.referenceId = referenceId;
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

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String accessId) {
        this.referenceId = accessId;
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
