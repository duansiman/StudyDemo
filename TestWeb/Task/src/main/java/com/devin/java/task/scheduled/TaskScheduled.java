package com.devin.java.task.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by devin on 2017/1/3.
 */
@Component
public class TaskScheduled {

    /*@Scheduled(fixedDelay=5000) //从任务完成时算，每五秒执行一次
    public void doSomething() {
        // something that should execute periodically
        System.out.println(System.currentTimeMillis());
        System.out.println("do something");
    }*/

    /*@Scheduled(fixedRate=5000)  //从任务开始时算，每五秒执行一次
    public void doSomething() {
        // something that should execute periodically
        System.out.println(System.currentTimeMillis());
        System.out.println("do something");
    }*/

    //从任务开始时算，每五秒执行一次。但第一次执行延迟1s
    /*@Scheduled(initialDelay=1000, fixedRate=5000)
    public void doSomething() {
        // something that should execute periodically
        System.out.println(System.currentTimeMillis());
        System.out.println("do something");
    }*/

    @Scheduled(cron="*/5 * * * * MON-FRI")
    public void doSomething() {
        // something that should execute on weekdays only
    }

}
