package ir.navaco.mcb.sms.gateway.consumer.services.redis;

public interface RedisQueueListener {

    void listenerQueue(String jsonObjectFormat);

}
