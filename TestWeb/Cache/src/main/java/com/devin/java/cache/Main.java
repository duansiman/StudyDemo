package com.devin.java.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devin on 2017/1/13.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "cache.xml");// 加载 spring 配置文件

        AccountService s = (AccountService) context.getBean("accountService");
        // 第一次查询，应该走数据库
        System.out.print("first query...");
        s.getAccountByName("somebody");
        // 第二次查询，应该不查数据库，直接返回缓存的值
        System.out.print("second query...");
        s.getAccountByName("somebody");
        System.out.println("\n\n");

        System.out.println("start testing clear cache...");    // 更新某个记录的缓存，首先构造两个账号记录，然后记录到缓存中
        Account account1 = s.getAccountByName("somebody1");
        Account account2 = s.getAccountByName("somebody2");

        // 开始更新其中一个
        account1.setId(1212);
        s.updateAccount(account1);
        s.getAccountByName("somebody1");// 因为被更新了，所以会查询数据库

        s.getAccountByName("somebody2");// 没有更新过，应该走缓存
        s.getAccountByName("somebody1");// 再次查询，应该走缓存
        System.out.println("\n\n");

        // 更新所有缓存
        s.reload();
        s.getAccountByName("somebody1");// 应该会查询数据库
        s.getAccountByName("somebody2");// 应该会查询数据库
        s.getAccountByName("somebody1");// 应该走缓存
        s.getAccountByName("somebody2");// 应该走缓存

        System.out.println("\n\n");
        s.getAccountByName("somebody");// 长度大于 4，不会被缓存
        s.getAccountByName("sbd");// 长度小于 4，会被缓存
        s.getAccountByName("somebody");// 还是查询数据库
        s.getAccountByName("sbd");// 会从缓存返回

    }

}
