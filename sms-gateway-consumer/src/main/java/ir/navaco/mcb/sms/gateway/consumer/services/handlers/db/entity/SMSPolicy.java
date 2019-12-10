package ir.navaco.mcb.sms.gateway.consumer.services.handlers.db.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SMS_POLICY", schema = "SMS_GATEWAY", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "TAG")
})
public class SMSPolicy implements Serializable {

    public static final String SEQUENCE_NAME_GENERATOR = "SMS_POLICY_SEQUENCE_NAME_GENERATOR";
    public static final String SEQUENCE_NAME_MAIN = "SMS_POLICY_SEQUENCE_NAME_MAIN";

    @Id
    @SequenceGenerator(name = SEQUENCE_NAME_GENERATOR, sequenceName = SEQUENCE_NAME_MAIN,
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME_GENERATOR)
    @Column(name = "ID", nullable = false, unique = true)
    private long id;
    @Column(name = "TAG", unique = true, nullable = false)
    private String tag;
    @Column(name = "PRIORITY", nullable = false)
    private boolean priority;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }
}
