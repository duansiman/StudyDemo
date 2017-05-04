package com.java.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by devin on 2017/4/26.
 */
public interface UserManagerInterface extends Remote{

    public String getUserName() throws RemoteException;
    public Account getAdminAccount() throws RemoteException;

}
