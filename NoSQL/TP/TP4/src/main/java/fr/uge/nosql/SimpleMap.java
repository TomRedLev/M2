package fr.uge.nosql;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class SimpleMap {
    private JedisPool pool = new JedisPool(new JedisPoolConfig(),"localhost");
    private void test() {
        try {
            Jedis jedis = pool.getResource();
            Map<String,String> val1 = new HashMap<String,String>();
            val1.put("uri", "person");
            val1.put("local", "1");
            val1.put("start","0");
            jedis.hmset(new String("user:123"),val1);
            Map<String,String> val2 = new HashMap<String,String>();
            val2.put("uri", "prof");
            val2.put("local", "3");
            val2.put("start","1");
            jedis.hmset(new String("user:234"), val2);
            val1 = jedis.hgetAll("234");
            Set<String> keys = val1.keySet();
            for(String key: keys)
                System.out.println(key+" " +val1.get(key));
            Set<String> cles = jedis.keys("user:*");
            System.out.println(cles.size());
            for(String str : cles)
                System.out.println(" - "+str);
            pool.getResource();//returnResource(jedis);
        }
        catch (Exception e) {
            System.err.println(e.toString());
        }finally{
            pool.destroy();
        }
    }
    public static void main(String args[]) {
        SimpleMap map1 = new SimpleMap();
        map1.test();
    }
}
