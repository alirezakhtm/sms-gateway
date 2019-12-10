package ir.navaco.mcb.sms.gateway.consumer.services.handlers;

import ir.navaco.mcb.sms.common.IRestSMSRequest;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public class KafkaHandler extends QueueHandler{

    private static String DEFAULT_KAFKA_SERVER = null;

    @Override
    public boolean InsertRequestToQueue(String jsonIRestSMSRequest) {
        // TODO
        if(DEFAULT_KAFKA_SERVER == null) DEFAULT_KAFKA_SERVER = kafkaClusterList.get(0);
        boolean puttingResult = false;
        IRestSMSRequest smsRequest = gson.fromJson(jsonIRestSMSRequest, IRestSMSRequest.class);
        Producer producer = new Producer(DEFAULT_KAFKA_SERVER);
        return producer.put(KAFKA_QUEUE_NAME, smsRequest.getRequestId(), jsonIRestSMSRequest);
    }

    public class Producer {

        private KafkaProducer<String, String> mProducer = null;

        public Producer(String bootstrapServer){
            mProducer = new KafkaProducer<String, String>(this.getProperties(bootstrapServer));
        }

        public boolean put(String topic, String key, String value) {
            final ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, value);
            AtomicReference<Boolean> puttingSuccessful = new AtomicReference<>();
            try {
                return this.mProducer.send(record).isDone();
            }
            catch (Exception e){
                System.err.println(e.getMessage());
                return false;
            }
//            return puttingSuccessful.get();
        }

        private Properties getProperties(String bootstrapServer){
            String serializer = StringSerializer.class.getName();
            Properties properties = new Properties();
            properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
            properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, serializer);
            properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, serializer);
            return properties;
        }

        public void close(){
            mProducer.close();
        }
    }



}
