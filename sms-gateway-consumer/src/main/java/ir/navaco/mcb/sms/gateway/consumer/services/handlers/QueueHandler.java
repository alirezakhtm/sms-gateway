package ir.navaco.mcb.sms.gateway.consumer.services.handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.ConfigurationHandler;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.dto.ApplicationConfiguration;
import javax.xml.bind.JAXBException;
import java.util.List;

public abstract class QueueHandler {

    protected static String KAFKA_QUEUE_NAME = null;
    protected static String KAFKA_GROUP_ID = null;
    protected static String REDIS_QUEUE_NAME = null;
    protected static List<String> kafkaClusterList = null;
    protected static List<String> redisClusterList = null;
    protected static Gson gson = null;

    public QueueHandler(){
        if(KAFKA_QUEUE_NAME == null){
            try {
                this.refreshConfig();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }

    public void refreshConfig() throws JAXBException {
        ConfigurationHandler configurationHandler = new ConfigurationHandler();
        ApplicationConfiguration configuration = configurationHandler.getConfig();
        KAFKA_QUEUE_NAME = configuration.getQueue().getKafka().getQueueName();
        KAFKA_GROUP_ID = configuration.getQueue().getKafka().getGroupId();
        kafkaClusterList = configuration.getQueue().getKafka().getNodes();
        redisClusterList = configuration.getQueue().getRedis().getNodes();
        REDIS_QUEUE_NAME = configuration.getQueue().getRedis().getQueueName();
        gson = new GsonBuilder().create();
    }

    public boolean InsertRequestToQueue(String jsonIRestSMSRequest) {
        return false;
    }

}
