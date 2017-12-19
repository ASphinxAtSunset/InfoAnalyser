package jedispool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Gene on 2017/12/4.
 */
public class ConfJedisPool {

    private static Logger logger = LoggerFactory.getLogger(ConfJedisPool.class);

    private static JedisPool pool = new JedisPool();
    static {

        //JedisFactory
        //pool.
        Properties props = new Properties();
/*        try {
            FileInputStream is = new FileInputStream("");
            props.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        GenericObjectPoolConfig conf = new GenericObjectPoolConfig();
        PooledObjectFactory poolFactory = null;
        // poolFactory.activateObject();
        conf.setMaxTotal(10);
        //pool.initPool(conf,new JedisPooledFactory());
        pool = new JedisPool(conf, "127.0.0.1",6379,10,"1");
    }
    public static Jedis borrowJedisClient(){
        Jedis jedis = pool.getResource();
        return jedis;
    }

    public static void closePool() {
        if (pool != null) {
            pool.close();
            logger.info("close redis pool success");
        }
    }
}
