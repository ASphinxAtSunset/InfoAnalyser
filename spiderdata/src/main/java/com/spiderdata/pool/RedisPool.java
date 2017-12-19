package com.spiderdata.pool;

import com.sun.deploy.util.SessionState;
import com.typesafe.config.Config;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Gene on 2017/9/25.
 * redis连接池工具类
 */
public class RedisPool {
    private static final Logger logger = LoggerFactory.getLogger(RedisPool.class);

    private static GenericObjectPool<Jedis> pool;

    /**
     * config初始值
     */
    static {
        //从配置文件中     取值-->放入   连接池配置对象
        Config config = null;
        /*常用属性
        *最大连接数
        * 最大空闲连接数
        * 阻塞时间
        * 控线连接最小世界
        * 检测连接是否有效
        * 检测控线连接进程周期
        * 等等
        */
        //强引用
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        pool = new GenericObjectPool<Jedis>(new RedisPoolFactory(),poolConfig);
        JedisPool redisRool = new JedisPool(poolConfig,"",6379);
        logger.info("init redis pool success");
    }




    public static class RedisPoolFactory extends BasePooledObjectFactory<Jedis> {

        public Jedis create() throws Exception {
            return null;
        }

        public PooledObject<Jedis> wrap(Jedis obj) {
            return null;
        }

        /**
         *分配 connection
         */

        /**
         *销毁对象
         */
        @Override
        public void destroyObject(PooledObject<Jedis> p){
            p.getObject().close();
        }

        /**
         * 返回一个 Jedis登录
         * @param
         */
        private Jedis  buildJedisClient(){
            Jedis jedis = new Jedis("",6379);
            jedis.connect();
            JedisPool poola = new JedisPool();
            jedis = poola.getResource();
            System.out.println("");
            //JedisPool redisRool = new JedisPool(poolConfig,"",6379);
            //return new DefaultPooledObject<Jedis>(jedis);
            return jedis;
        }
    }

}
