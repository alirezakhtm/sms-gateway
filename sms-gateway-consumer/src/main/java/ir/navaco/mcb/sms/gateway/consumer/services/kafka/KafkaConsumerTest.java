package ir.navaco.mcb.sms.gateway.consumer.services.kafka;

import ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.ConfigurationHandler;
import ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.dto.ApplicationConfiguration;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class KafkaConsumerTest {


    public static void main(String[] args) {
        /*KafkaConsumerTest.MyConsumer consumer = new KafkaConsumerTest.MyConsumer();
        consumer.runConsumer();*/

        ApplicationConfiguration applicationConfiguration = null;
        try {
            applicationConfiguration = new ConfigurationHandler().getConfig();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        String server = applicationConfiguration.getQueue().getKafka().getNodes().get(0);
        String groupId = applicationConfiguration.getQueue().getKafka().getGroupId();
        String topic = applicationConfiguration.getQueue().getKafka().getQueueName();

        new KafkaConsumerTest.MyConsumer(server, groupId, topic).run();



    }

    /*private static class MyConsumer{

        private ConfigurationHandler configurationHandler = new ConfigurationHandler();
        private ApplicationConfiguration applicationConfiguration = null;

        public MyConsumer() {
            try {
                applicationConfiguration = configurationHandler.getConfig();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }

        private Properties getProperties(){
            Properties properties = new Properties();
            properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                    applicationConfiguration.getQueue().getKafka().getNodes().get(0));
            properties.put(ConsumerConfig.GROUP_ID_CONFIG, applicationConfiguration.getQueue().getKafka().getGroupId());
            properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            return properties;
        }

        private Consumer<String, String> getConsumer(){
            Properties prop = this.getProperties();
            Consumer<String, String> consumer = new KafkaConsumer<String, String>(prop);
            consumer.subscribe(Collections.singletonList(applicationConfiguration.getQueue().getKafka().getQueueName()));
            return consumer;
        }

        public void runConsumer(){
            Consumer<String, String> consumer = this.getConsumer();
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            records.forEach(record -> {
                String message = String.format("Consumer Record: (%s, %s, %d, %d)",
                        record.key(), record.value(), record.partition(), record.offset());
                System.out.println(message);
            });
        }

    }*/

    private static class MyConsumer {

        private final Logger mLogger = LoggerFactory.getLogger(Consumer.class.getName());
        private final String mBootstrapServer;
        private final String mGroupId;
        private final String mTopic;

        public MyConsumer(String bootstrapServer, String groupId, String topic){
            this.mBootstrapServer = bootstrapServer;
            this.mGroupId = groupId;
            this.mTopic = topic;
        }

        public void run(){
            System.out.println("Creating consumer thread.");

            CountDownLatch countDownLatch = new CountDownLatch(1);

            ConsumerRunnable consumerRunnable =
                    new ConsumerRunnable(this.mBootstrapServer, this.mGroupId, this.mTopic, countDownLatch);
            Thread thread = new Thread(consumerRunnable);
            thread.start();

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("Caught shutdown hook.");
                consumerRunnable.shutdown();
                await(countDownLatch);
            }));

            await(countDownLatch);
        }

        void await(CountDownLatch latch) {
            try {
                latch.await();
            } catch (InterruptedException e) {
                System.err.println("Application got interrupted >>>> " + e);
            } finally {
                System.out.println("Application is closing");
            }
        }

        private class ConsumerRunnable implements Runnable {

            private CountDownLatch mLatch;
            private KafkaConsumer<String, String> mConsumer;

            public ConsumerRunnable(String bootstrapServer, String groupId, String topic, CountDownLatch latch){
                this.mLatch = latch;
                Properties properties = consumerProps(bootstrapServer, groupId);
                this.mConsumer = new KafkaConsumer<String, String>(properties);
                this.mConsumer.subscribe(Collections.singletonList(topic));
            }

            private Properties consumerProps(String bootStrapServer, String groupId){
                String deserializer = StringDeserializer.class.getName();
                Properties properties = new Properties();
                properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, deserializer);
                properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
                properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
                properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
                properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
                return properties;
            }

            @Override
            public void run() {
                try {
                    do{
                        ConsumerRecords<String, String> records = this.mConsumer.poll(Duration.ofMillis(100));
                        for(ConsumerRecord<String, String> record : records){
                            System.out.println("Key: " + record.key() + ", Value: " + record.value());
                            System.out.println("Partition: " + record.partition() + ", Offset: " + record.offset());
                        }
                    }while (true);
                } catch (WakeupException e){
                    System.out.println("Received shutdown signal!");
                }finally {
                    mConsumer.close();
                    mLatch.countDown();
                }
            }

            public void shutdown(){
                this.mConsumer.wakeup();
            }
        }
    }


}
