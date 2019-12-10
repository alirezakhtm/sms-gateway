import redis.clients.jedis.Jedis;

public class RedisTest {


    public static void main(String[] args) {
        try {
            Jedis redis = new Jedis("localhost");
            String redisRsp = redis.ping();
            System.out.println(redisRsp);
            String jsonObj = redis.rpop("test");
            System.out.println("[>>>] Object in json format from \'test\' queue is: " + jsonObj);
            redis.close();
        }catch (Exception e){
            System.err.println("[>>>] " + e.getMessage());
        }
    }

}
