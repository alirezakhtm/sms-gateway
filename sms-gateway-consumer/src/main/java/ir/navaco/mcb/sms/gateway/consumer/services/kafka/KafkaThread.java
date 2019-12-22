package ir.navaco.mcb.sms.gateway.consumer.services.kafka;

import ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.ConfigurationHandler;
import redis.clients.jedis.Jedis;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class KafkaThread implements Runnable {

    private String kafkaQueueName = "";
    private ConfigurationHandler configurationHandler;
    private List<String> kafkaNodes = null;
    private boolean foundKafkaNodes = true;
    private static List<KafkaQueueListener> listeners = new ArrayList<>();
    private static Jedis globalRedis = null;

    public KafkaThread(){
        this.configurationHandler = new ConfigurationHandler();
        try {
            this.kafkaQueueName = configurationHandler.getConfig().getQueue().getKafka().getQueueName();
            this.kafkaNodes = configurationHandler.getConfig().getQueue().getKafka().getNodes();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {

    }



}
