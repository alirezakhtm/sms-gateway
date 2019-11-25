package ir.navaco.mcb.sms.gateway.services.handlers.config.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "application")
public class ApplicationConfiguration {
    private Queue queue;

    @XmlElement(name = "queue")
    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }
}
