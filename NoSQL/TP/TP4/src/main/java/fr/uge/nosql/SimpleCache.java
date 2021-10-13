package fr.uge.nosql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Random;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class SimpleCache {

    private JedisPool pool = new JedisPool(new JedisPoolConfig(),"localhost");
    private DBConnect pgDrugsDB =  new DBConnect("org.postgresql.Driver",
            "jdbc:postgresql://localhost/tom_db","tom","tom");
    private final int MAXKEY =101;

    public void cache() {
        try {
            Jedis jedis = pool.getResource();
            Map<String,Map<String,String>> map = loadData();
            System.out.println(map.size());
            Set<String> keys = map.keySet();
            for(String key : keys)
                jedis.hmset("drug:"+key, map.get(key));
            //pool.close();
        } catch (Exception e){
            System.err.println(e.toString());
        } finally{
            //pool.destroy();
        }
    }


    public Map<String,Map<String,String>> loadData() throws SQLException {
        pgDrugsDB.connexion();
        Map<String,Map<String,String>> map = new HashMap<String,Map<String,String>>();
        String query = "SELECT cip7, denom, cis FROM ciscipDenorm WHERE cip7 is NOT NULL LIMIT 100;";
        try {
            ResultSet rs = pgDrugsDB.doRequest(query);
            while(rs.next())
            {
                HashMap<String,String> tmpMap = new HashMap<String,String>();
                tmpMap.put("nom",rs.getString(2));
                tmpMap.put("cis",rs.getString(3));
                System.out.println(rs.getString(1));
                map.put(rs.getString(1), tmpMap);
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return map;
    }

    public void pgPerf(int cip) throws SQLException {
        Long start = System.currentTimeMillis();
        pgDrugsDB.connexion();
        String query = "SELECT cip7, denom, cis FROM ciscipDenorm WHERE cip7 = "+cip;
        try {
            ResultSet rs = pgDrugsDB.doRequest(query);
            while(rs.next())
            {
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        Long end = System.currentTimeMillis();
        System.out.println("duration PG access = "+ (end-start) +"ms");
    }

    public void redisPerf(int cip) {
        Long start = System.currentTimeMillis();
        Jedis jedis = pool.getResource();
        Map<String,String> map = jedis.hgetAll("drug:"+cip) ;
        System.out.println("drug:3002104"+ map.get("nom")+" "+map.get("cis"));
        Long end = System.currentTimeMillis();
        System.out.println("duration redis access = "+ (end-start) +"ms");
        jedis.close();
    }

    public void readCache(int cip) throws SQLException {
        Jedis jedis = pool.getResource();
        if(jedis.exists("drug:"+cip)) {
            Map<String, String> map = jedis.hgetAll("drug:" + cip);
            System.out.println("drug:3002104"+ map.get("nom")+" "+map.get("cis"));
        } else {
            updateCache(cip);
        }
        jedis.close();
    }

    public void updateCache(int cip) throws SQLException {
        System.out.println("Update Cache");
        pgDrugsDB.connexion();
        String query = "SELECT cip7, denom, cis FROM ciscipDenorm WHERE cip7 = "+cip;
        try {
            ResultSet rs = pgDrugsDB.doRequest(query);
            while(rs.next())
            {
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
                HashMap<String,String> tmpMap = new HashMap<String,String>();
                tmpMap.put("nom",rs.getString(2));
                tmpMap.put("cis",rs.getString(3));
                Jedis jedis = pool.getResource();
                if(isDBFull(jedis)) {
                    Set<String> keysToRemove = jedis.zrange("count",0,0);
                    System.out.println("to del = "+keysToRemove.size());
                    for(String key : keysToRemove)
                        jedis.del(key);
                    System.out.println(jedis.dbSize());
                }
                jedis.hmset("drug:"+cip, tmpMap);
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isDBFull(Jedis jedis) {
        if(jedis.dbSize()>=MAXKEY)
            return true;
        else return false;
    }

    public void randomVisits() {
        Jedis jedis = pool.getResource();
        Set<String> keys = jedis.keys("drug:*");
        Random rand = new Random();
        for(String key : keys) {
            jedis.zincrby("count",rand.nextInt(1000)+1,key);
        }
        System.out.println(keys.size());
        jedis.close();
    }

    public static void main(String args[]) throws SQLException {
        SimpleCache simpleCache = new SimpleCache();
        simpleCache.cache();
        simpleCache.pgPerf(3002104);
        simpleCache.redisPerf(3002104);
        simpleCache.readCache(3688008);
        simpleCache.readCache(3563778);
        simpleCache.randomVisits();
    }
}
