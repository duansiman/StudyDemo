package com.epdc.java.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by devin on 2017/4/26.
 */
public interface FrameWorkInterface extends Remote {

    public Object[] syncRequest(FrameWorkParm in)
            throws RemoteException;

    public Object[] asyncRequest(FrameWorkParm in)
            throws RemoteException;

    public String shutRequest()
            throws RemoteException;

}
