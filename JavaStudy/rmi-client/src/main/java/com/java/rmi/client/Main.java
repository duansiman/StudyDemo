package com.java.rmi.client;

import com.java.rmi.server.UserManagerInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by devin on 2017/4/26.
 */
public class Main {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",2001);
            UserManagerInterface userManager = (UserManagerInterface) registry.lookup("userManager");
            System.out.println(userManager.getUserName());
            System.out.println(userManager.getAdminAccount().getUsername()+"\t"
                    +userManager.getAdminAccount().getPassword());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
