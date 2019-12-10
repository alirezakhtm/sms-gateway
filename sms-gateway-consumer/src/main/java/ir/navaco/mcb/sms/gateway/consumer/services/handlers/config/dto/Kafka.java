package ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class Kafka {

    private String queueName;
    private String groupId;
    private List<String> nodes;

    @XmlElement(name = "queue-name")
    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    @XmlElement(name = "group-id")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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
