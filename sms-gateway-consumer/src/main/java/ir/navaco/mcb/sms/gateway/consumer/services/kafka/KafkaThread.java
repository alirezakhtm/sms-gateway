package ir.navaco.mcb.sms.gateway.consumer.services.kafka;

import ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.ConfigurationHandler;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.dto.ApplicationConfiguration;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import redis.clients.jedis.Jedis;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class KafkaThread implements Runnable {

    private static String kafkaQueueName = "";
    private static ConfigurationHandler configurationHandler = null;
    private static ApplicationConfiguration applicationConfiguration = null;
    private static List<String> kafkaNodes = null;
    private static boolean foundKafkaNodes = true;
    private static List<KafkaQueueListener> listeners = new ArrayList<>();
    private static Jedis globalRedis = null;

    public KafkaThread(){
        if(configurationHandler == null) {
            configurationHandler = new ConfigurationHandler();
            try {
                applicationConfiguration = configurationHandler.getConfig();
                kafkaQueueName = applicationConfiguration.getQueue().getKafka().getQueueName();
                kafkaNodes = applicationConfiguration.getQueue().getKafka().getNodes();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }

    private Properties getProperties(){
        Properties properties = new Properties();
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, applicationConfiguration.getQueue().getKafka().getGroupId());
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, applicationConfiguration.getQueue().getKafka());
        return properties;
    }

    @Override
    public void run() {

    }



}
