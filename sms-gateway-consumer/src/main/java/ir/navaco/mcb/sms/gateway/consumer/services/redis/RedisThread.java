package ir.navaco.mcb.sms.gateway.consumer.services.redis;

import ir.navaco.mcb.sms.gateway.consumer.services.handlers.config.ConfigurationHandler;
import redis.clients.jedis.Jedis;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class RedisThread implements Runnable {

    private String redisQueueName = "";
    private ConfigurationHandler configurationHandler;
    private List<String> redisNodes = null;
    private boolean foundRedisNodes = true;
    private static List<RedisQueueListener> listeners = new ArrayList<>();
    private static Jedis globalRedis = null;

    public RedisThread(){
        configurationHandler = new ConfigurationHandler();
        try {
            this.redisNodes = configurationHandler.getConfig().getQueue().getRedis().getNodes();
            this.redisQueueName = configurationHandler.getConfig().getQueue().getRedis().getQueueName();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private Jedis getRedisServer(){
        if(globalRedis != null) return globalRedis;
        Jedis redis = null;
        for (String redisNode : this.redisNodes){
            try {
                redis = new Jedis(redisNode);
                redis.ping();
                System.out.println(String.format("[>>>] Server %s exists.", redisNode));
                break;
            }catch (Exception e){
                System.err.println(String.format("[>>>] Server %s does not exist.", redisNode));
                System.err.println("[>>>] Trying another server.");
            }
        }
        globalRedis = redis;
        return redis;
    }

    private String readObject(){
        if(redisNodes == null) {
            this.foundRedisNodes = false;
            return null;
        }
        Jedis redis = this.getRedisServer();
        if(redis == null) {
            this.foundRedisNodes = false;
            return null;
        }
        String jsonObject = redis.rpop(this.redisQueueName);
        redis.close();
        return jsonObject;
    }

    public void setOnQueueListener(RedisQueueListener object){
        listeners.add(object);
    }

    private void putDataInEvent(String jsonObject){
        for(RedisQueueListener redisQueueListener : listeners){
            redisQueueListener.listenerQueue(jsonObject);
        }
    }

    @Override
    public void run() {
        while (this.foundRedisNodes){
            String jsonObject = readObject();
            if(jsonObject != null){
                this.putDataInEvent(jsonObject);
            }
        }
    }
}
