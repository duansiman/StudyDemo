package com.devin.java.client;

import com.devin.java.remote.Account;
import com.devin.java.remote.AccountService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by devin on 2016/12/22.
 */
public class SimpleObject {

    private AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    // additional methods using the accountService
    public void insertAccount() {
        // do something...
        accountService.insertAccount(new Account("张山"));
    }

    public List<Account> getAccounts() {
        // do something...
        return accountService.getAccounts("devin");
    }



}