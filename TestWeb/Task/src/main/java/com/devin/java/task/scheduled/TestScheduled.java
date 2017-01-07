package com.devin.java.task.scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by devin on 2017/1/3.
 */
@SpringBootApplication
@EnableScheduling
public class TestScheduled {
    public static void main(String[] args) {
        SpringApplication.run(TestScheduled.class, args);
        System.out.println(System.currentTimeMillis());
    }
}
