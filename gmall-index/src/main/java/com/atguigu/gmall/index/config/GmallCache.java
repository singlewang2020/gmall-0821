package com.atguigu.gmall.index.config;

import org.springframework.transaction.TransactionDefinition;

import java.lang.annotation.*;

@Target({ElementType.METHOD}) // 注解作用在方法上
@Retention(RetentionPolicy.RUNTIME) // 在运行时注解
//@Inherited // 是否可继承
@Documented // 是否加入文档中
public @interface GmallCache {
    /**
     * 缓存的前提
     * 将来缓存的key: prefix + 方法参数
     *
     * @return
     */
    String prefix() default "";

    /**
     * 缓存的过期时间
     * 单位为min
     *
     * @return
     */
    int timeout() default 5;

    /**
     * 为了防止缓存雪崩
     * 给缓存指定随机范围
     *
     * @return
     */
    int random() default 5;

    /**
     * 为了防止缓存击穿，添加分布式锁
     * 此处需要指定分布式锁前缀
     *
     * @return
     */
    String lock() default "lock:";
}
