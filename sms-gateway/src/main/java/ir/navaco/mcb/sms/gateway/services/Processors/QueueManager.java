package ir.navaco.mcb.sms.gateway.services.Processors;

import ir.navaco.mcb.sms.gateway.services.handlers.KafkaHandler;
import ir.navaco.mcb.sms.gateway.services.handlers.RedisHandler;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class QueueManager implements Processor {

    private static KafkaHandler kafkaHandler = null;
    private static RedisHandler redisHandler = null;

    public QueueManager(){
        if(kafkaHandler == null){
            kafkaHandler = new KafkaHandler();
            redisHandler = new RedisHandler();
        }
    }

    public void process(Exchange exchange) throws Exception {
        Message message = exchange.getIn();
        String jsonBody = message.getBody().toString();
        boolean kafkaInsertingResult = kafkaHandler.InsertRequestToQueue(jsonBody);
        if(!kafkaInsertingResult) redisHandler.InsertRequestToQueue(jsonBody);
        System.out.println(kafkaInsertingResult ? "Request putted into kafka Queue." : "Request putted into Redis.");

        /*redisHandler.InsertRequestToQueue(jsonBody);*/

        /*kafkaHandler.InsertRequestToQueue(jsonBody);*/
    }
}
