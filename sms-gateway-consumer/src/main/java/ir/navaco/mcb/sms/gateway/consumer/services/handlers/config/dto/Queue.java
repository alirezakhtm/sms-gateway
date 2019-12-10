package ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.dto;

import javax.xml.bind.annotation.XmlElement;

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
