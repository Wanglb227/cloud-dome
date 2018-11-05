import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * @author
 * @create 2018-09-19 15:26
 **/
public class JedisSubscribe extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        System.out.println("消息频道："+channel+" 消息内容："+message);
    }

    @Test
    public void subscribe() {
        Jedis jedis1 = new Jedis("192.168.9.129",6379);
        jedis1.auth("wanglb");
        JedisSubscribe jedisSubscribe = new JedisSubscribe();
        jedis1.subscribe(jedisSubscribe,"wanglb");
    }
}
