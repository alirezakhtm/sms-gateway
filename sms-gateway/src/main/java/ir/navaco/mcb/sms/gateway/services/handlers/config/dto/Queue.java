package ir.navaco.mcb.sms.gateway.services.handlers.config.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Queue {
    private Kafka kafka;
    private Redis redis;

    @XmlElement(name = "kafka")
    public Kafka getKafka() {
        return kafka;
    }

    public void setKafka(Kafka kafka) {
        this.kafka = kafka;
    }

    @XmlElement(name = "redis")
    public Redis getRedis() {
        return redis;
    }

    public void setRedis(Redis redis) {
        this.redis = redis;
    }
}
