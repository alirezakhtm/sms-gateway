package ir.navaco.mcb.sms.gateway.services.handlers;

import ir.navaco.mcb.sms.common.IRestSMSRequest;
import ir.navaco.mcb.sms.gateway.services.handlers.db.ObjectConverter;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class KafkaHandler extends QueueHandler{

    private static String DEFAULT_KAFKA_SERVER = null;

    @Override
    public boolean InsertRequestToQueue(String jsonIRestSMSRequest) {
        // TODO
        if(DEFAULT_KAFKA_SERVER == null) DEFAULT_KAFKA_SERVER = kafkaClusterList.get(0);
        boolean puttingResult = false;
        jsonIRestSMSRequest = ObjectConverter.convertToStandardJsonFormat(jsonIRestSMSRequest);
        IRestSMSRequest smsRequest = gson.fromJson(jsonIRestSMSRequest, IRestSMSRequest.class);
        int counter = 0;
        while (!puttingResult){

            Producer producer = new Producer(DEFAULT_KAFKA_SERVER);
            puttingResult = producer.put(KAFKA_QUEUE_NAME, UUID.randomUUID().toString(), jsonIRestSMSRequest);
            if(!puttingResult){
                if(kafkaClusterList.size() == 1) break;
                if(counter != kafkaClusterList.size() - 1){
                    DEFAULT_KAFKA_SERVER = kafkaClusterList.get(++counter);
                }else{
                    break;
                }
            }
            producer.close();
        }
        return puttingResult;
    }

    public class Producer {

        private final KafkaProducer<String, String> mProducer;

        private Properties producerProperties(String bootstrapServer){
            String serializer = StringSerializer.class.getName();
            Properties properties = new Properties();
            properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
            properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, serializer);
            properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, serializer);
            return properties;
        }

        public Producer(String bootstrapServer){
            Properties props = producerProperties(bootstrapServer);
            mProducer = new KafkaProducer<String, String>(props);
            System.out.println("Producer Initialized.");
        }

        public boolean put(String topic, String key, String value) {
            System.out.println("Put value: " + value + ", for key: " + key);
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, value);
            try {
                mProducer.send(record, (recordMetadata, e) -> {
                    if (e != null){
                        System.err.println("Error while producing >>>> " + e);
                        return;
                    }

                    System.out.println("Received new meta.\n" +
                            "Topic: " + recordMetadata.topic() + "\n" +
                            "Partition: " + recordMetadata.partition() + "\n" +
                            "Offset: " + recordMetadata.offset() + "\n" +
                            "Timestamp: " + recordMetadata.timestamp());
                }).get();
                return true;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return false;
            }
        }

        public void close(){
            System.out.println("Closing producer connection.");
            mProducer.close();
        }

    }



}
