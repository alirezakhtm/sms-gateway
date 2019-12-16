package ir.navaco.mcb.sms.gateway.services.handlers;

import ir.navaco.mcb.sms.common.IRestSMSRequest;
import ir.navaco.mcb.sms.gateway.services.handlers.db.ObjectConverter;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

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

        /*while (!puttingResult){
            Producer producer = new Producer(DEFAULT_KAFKA_SERVER);
            puttingResult = producer.put(KAFKA_QUEUE_NAME, smsRequest.getRequestId(), jsonIRestSMSRequest);
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

        return puttingResult;*/
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
                /*this.mProducer.send(record, new Callback() {
                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                        if(e != null){
                            // TODO - kafka has had error
                            puttingSuccessful.set(false);
                            return;
                        }
                        // ToDO - Succes
                        puttingSuccessful.set(true);
                    }
                }).get();*/
            } /*catch (InterruptedException e) {
                puttingSuccessful.set(false);
                e.printStackTrace();
            } catch (ExecutionException e) {
                puttingSuccessful.set(false);
                e.printStackTrace();
            }*/
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
