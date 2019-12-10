package ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "application")
public class ApplicationConfiguration {
    private Queue queue;
    private int interval;

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
}
