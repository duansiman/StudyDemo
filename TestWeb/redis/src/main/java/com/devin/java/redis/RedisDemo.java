package com.devin.java.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by devin on 2017/4/13.
 */
public class RedisDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springmvc-servlet.xml"});

//        JedisConnectionFactory jedisConnFactory = context.getBean("jedisConnFactory", JedisConnectionFactory.class);
//
//        RedisConnection redisConnection = jedisConnFactory.getConnection();
//
//        if (redisConnection.exists("foo".getBytes())) {
//            System.out.println(new String(redisConnection.get("foo".getBytes())));
//        }
//
//        List<byte[]> bytes = redisConnection.lRange("number".getBytes(), 0L, -1L);
//        for (byte[] bs:bytes
//             ) {
//            System.out.println(new String(bs));
//        }
//
//        redisConnection.close();

        ValueOperations stringRedisTemplate = context.getBean("stringRedisTemplate", ValueOperations.class);
        System.out.println(stringRedisTemplate.get("foo"));

//
//        ListOperations listOperations = context.getBean("redisTemplate", ListOperations.class);
//        System.out.println(listOperations.size("number"));
//        System.out.println(listOperations.range("number", 0L, 2L));
//        System.out.println(listOperations.size("sortbylist"));
//        System.out.println(listOperations.range("sortbylist", 0L, 2L));
//
        try {
            HashOperations hashOperations = context.getBean("hashOperations", HashOperations.class);
            System.out.println(hashOperations.hasKey("user".getBytes("utf-8"), "name".getBytes("utf-8")));
            System.out.println(hashOperations.get("user".getBytes("utf-8"), "name".getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

}
