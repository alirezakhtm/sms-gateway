package ir.navaco.mcb.sms.gateway.services.handlers;

import redis.clients.jedis.Jedis;

public class RedisHandler extends QueueHandler{
    /**
     * this class must be completed, changing between multi-node for redis must be added to this algorithm.
     * */
    @Override
    public boolean InsertRequestToQueue(String jsonIRestSMSRequest) {
        Producer producer = new Producer(redisClusterList.get(0));
        boolean puttingResult = producer.put(REDIS_QUEUE_NAME, jsonIRestSMSRequest);
        return puttingResult;
    }

    public class Producer{

        private Jedis redis = null;

        public Producer(String bootstrapServer){
            redis = new Jedis(bootstrapServer, 6379);
        }

        public boolean put(String topic, String value){
            redis.lpush(topic, value);
            return true;
        }

    }
}
