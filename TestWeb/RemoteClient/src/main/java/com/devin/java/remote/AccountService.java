package com.devin.java.remote;

import java.util.List;

/**
 * Created by devin on 2016/12/22.
 */
public interface AccountService {
    public void insertAccount(Account account);

    public List<Account> getAccounts(String name);
}
