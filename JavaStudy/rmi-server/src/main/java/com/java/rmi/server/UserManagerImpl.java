package com.java.rmi.server;

import java.rmi.RemoteException;

/**
 * Created by devin on 2017/4/26.
 */
public class UserManagerImpl implements UserManagerInterface {

    public UserManagerImpl() throws RemoteException {
    }

    @Override
    public String getUserName() throws RemoteException {
        return "devin";
    }

    @Override
    public Account getAdminAccount() throws RemoteException {
        Account account=new Account();
        account.setUsername("admin");
        account.setPassword("admin");
        return account;
    }
}
