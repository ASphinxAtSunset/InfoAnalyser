import jedispool.ConfJedisPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * Created by Gene on 2017/12/4.
 */
public class Process {
    private static Logger logger = LoggerFactory.getLogger(Process.class);
    public static void main(String[] args) {
        //borrowJedisPool
        Jedis jedis = ConfJedisPool.borrowJedisClient();
        jedis.append("a","b");
        //jedis.
    }
}
