package ir.navaco.mcb.sms.gateway.consumer.services.kafka;

public interface KafkaQueueListener {

    void listenerQueue(String jsonObjectFormat);

}
