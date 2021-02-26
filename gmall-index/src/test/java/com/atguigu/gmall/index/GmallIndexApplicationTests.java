package com.atguigu.gmall.index;

import org.junit.jupiter.api.Test;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.PostConstruct;

@SpringBootTest
class GmallIndexApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redissonClient;
//    private StringRedisTemplate redisTemplate;

    @PostConstruct
    public void init() {
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
        this.redisTemplate.setValueSerializer(new StringRedisSerializer());
    }

    @Test
    void contextLoads() {
        this.redisTemplate.opsForValue().set("test", "柳岩");
        System.out.println(this.redisTemplate.opsForValue().get("test"));
    }

    @Test
    void testRedissonBloomFilter() {
        RBloomFilter<Object> bloomFilter = this.redissonClient.getBloomFilter("bloomFilter");
        bloomFilter.tryInit(20, 0.3);
        bloomFilter.add("1");
        bloomFilter.add("2");
        bloomFilter.add("3");
        bloomFilter.add("4");
        bloomFilter.add("5");
        bloomFilter.add("6");
        bloomFilter.add("7");
        bloomFilter.add("8");
        bloomFilter.add("9");
        bloomFilter.add("10");
        bloomFilter.add("11");
        bloomFilter.add("12");
        bloomFilter.add("13");
        bloomFilter.add("14");
        bloomFilter.add("15");
        bloomFilter.add("16");
        bloomFilter.add("17");
        bloomFilter.add("18");
        bloomFilter.add("19");

        System.out.println("1: " + bloomFilter.contains("1"));
        System.out.println("3: " + bloomFilter.contains("3"));
        System.out.println("5: " + bloomFilter.contains("5"));
        System.out.println("11: " + bloomFilter.contains("11"));
        System.out.println("12: " + bloomFilter.contains("12"));
        System.out.println("13: " + bloomFilter.contains("13"));
        System.out.println("14: " + bloomFilter.contains("14"));
        System.out.println("15: " + bloomFilter.contains("15"));
        System.out.println("16: " + bloomFilter.contains("16"));
        System.out.println("22: " + bloomFilter.contains("22"));
        System.out.println("21: " + bloomFilter.contains("21"));
        System.out.println("20: " + bloomFilter.contains("20"));
    }


}
