package com.lily.demo.handler.test;

import com.google.gson.Gson;
import com.lily.demo.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisTest {
    private final static Gson gson = new Gson();
    //15天
    public static final long EXPIRE_SECOND = 15 * 24 * 60 * 60;

    private static final RedisTemplate<String, Object> redisTestTemp = RedisUtil.getStringRedisTemplate(0);

    public static void setRedisString (String key, String value) {
        redisTestTemp.opsForValue().set(key, value, EXPIRE_SECOND, TimeUnit.SECONDS);
    }

    /**
     * 将站点以map的形式存入redis （站点的key作为key, 使用票数作为值）
     * @param sitePoints
     * @param key 路线id + 班车id + 选择的日期
     */
    public static void setSitePointsByRedis(Map<String, Integer> sitePoints, String key) {

        String sitePointsStr = gson.toJson(sitePoints);
        redisTestTemp.opsForValue().set(key, sitePointsStr, EXPIRE_SECOND, TimeUnit.SECONDS);
    }

    public static Map<String, Integer> getSitePointsByRedis(String routeKey) {
        Object obj = redisTestTemp.opsForValue().get(routeKey);
        if (obj == null || StringUtils.isEmpty(obj.toString())) {
            return null;
        }
        Map<String, Integer> sitePoints = gson.fromJson(obj.toString(), Map.class);

        return sitePoints;
    }

    public static void main(String[] args) {
//        for (int i=0; i< 10; i++) {
//            Map<String, Integer> map = new LinkedHashMap<>();
//            map.put("A", 15);
//            map.put("B", 23);
//            map.put("C", 20);
//            map.put("D", 21);
//            map.put("E", 25);
//            setSitePointsByRedis(map, "route:shuttleId_date" + i);
//        }

        Set<String> keys = redisTestTemp.keys("*shuttleId*");
        System.out.println(keys);
//        Map<String, Integer> sitePoints = getSitePointsByRedis("route:");
//        System.out.println(sitePoints);
    }
}
