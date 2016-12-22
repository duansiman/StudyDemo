package com.devin.java.remote;


import java.util.Arrays;
import java.util.List;

/**
 * Created by devin on 2016/12/22.
 */

public class AccountServiceImpl implements AccountService {

    public void insertAccount(Account acc) {
        // do something...
        System.out.println("insert Account " + acc.getName());
    }

    public List<Account> getAccounts(String name) {
        // do something...
        return Arrays.asList(new Account(name));
    }

}
