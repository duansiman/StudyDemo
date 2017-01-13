package com.devin.java.cache;

/**
 * Created by devin on 2017/1/13.
 */
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public class AccountService {
    @Cacheable(value="accountCache", condition="#userName.length() <= 4")// 使用了一个缓存名叫 accountCache
    public Account getAccountByName(String userName) {
        // 方法内
        // \部实现不考虑缓存逻辑，直接实现业务
        return getFromDB(userName);
    }

    @CacheEvict(value="accountCache",key="#account.getName()")//清空 accountCache 缓存
    public void updateAccount(Account account) {
        updateDB(account);
    }

//    @CachePut(value="accountCache",key="#account.getName()")// 更新 accountCache 缓存
//    public Account updateAccount(Account account) {
//        return updateDB(account);
//    }

    @CacheEvict(value="accountCache",allEntries=true)// 清空 accountCache 缓存
    public void reload() {
    }

    private Account getFromDB(String acctName) {
        System.out.println("real querying db..."+acctName);
        return new Account(acctName);
    }

    private void updateDB(Account account) {
        System.out.println("real update db..."+account.getName());
    }
}
