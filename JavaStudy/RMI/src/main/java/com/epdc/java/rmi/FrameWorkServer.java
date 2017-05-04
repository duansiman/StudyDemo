package com.epdc.java.rmi;

import java.rmi.RemoteException;

/**
 * Created by devin on 2017/4/26.
 */
public class FrameWorkServer {
    // The base for all persistent processing
    private static FrameWorkBase fwb = null;

    // Start up Server
    public static void main(java.lang.String[] args) throws RemoteException {

        // the base for all processing
        fwb = new FrameWorkBase();

        // now, after initializing the other FrameWorkBase fields
        // including the application queues and threads,
        // do the Implementation class with a ref to FrameWorkBase
        FrameWorkImpl fwi = new FrameWorkImpl(fwb);
    }


}
