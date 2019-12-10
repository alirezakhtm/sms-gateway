package ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class Redis {

    private String queueName;
    private List<String> nodes;

    @XmlElement(name = "queue-name")
    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    @XmlElementWrapper(name = "cluster")
    @XmlElement(name = "node")
    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
}
