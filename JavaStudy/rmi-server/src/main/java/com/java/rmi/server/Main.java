package com.java.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by devin on 2017/4/26.
 */
public class Main {

    public static void main(String[] args) throws RemoteException {

        UserManagerImpl userManager=new UserManagerImpl();
        UserManagerInterface userManagerI = (UserManagerInterface) UnicastRemoteObject.exportObject(userManager,0);
        // Bind the remote object's stub in the registry
        Registry registry = LocateRegistry.createRegistry(2001);
        registry.rebind("userManager", userManagerI);
        System.out.println("server is ready");

    }

}
