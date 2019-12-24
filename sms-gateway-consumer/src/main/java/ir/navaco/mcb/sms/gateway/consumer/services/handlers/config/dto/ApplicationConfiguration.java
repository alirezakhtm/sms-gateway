package ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "application")
public class ApplicationConfiguration {
    private Queue queue;
    private int interval;
    private String smsUsername;
    private String smsPassword;
    private String smsSenderNumber;

    @XmlElement(name = "queue")
    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    @XmlElement(name = "interval")
    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    @XmlElement(name = "sms-username")
    public String getSmsUsername() {
        return smsUsername;
    }

    public void setSmsUsername(String smsUsername) {
        this.smsUsername = smsUsername;
    }

    @XmlElement(name = "sms-password")
    public String getSmsPassword() {
        return smsPassword;
    }

    public void setSmsPassword(String smsPassword) {
        this.smsPassword = smsPassword;
    }

    @XmlElement(name = "sms-sender-number")
    public String getSmsSenderNumber() {
        return smsSenderNumber;
    }

    public void setSmsSenderNumber(String smsSenderNumber) {
        this.smsSenderNumber = smsSenderNumber;
    }
}
