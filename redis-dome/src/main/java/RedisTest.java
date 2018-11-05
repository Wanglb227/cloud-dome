import redis.clients.jedis.Jedis;

/**
 * @author
 * @create 2018-09-19 11:47
 **/
public class RedisTest {
    public static void main(String arg[]) {
        Jedis jedis = new Jedis("192.168.9.129",6379);
        jedis.auth("wanglb");
        jedis.publish("wanglb", "我能的要上天。。。");
        System.out.println(jedis.ping());
    }
}
