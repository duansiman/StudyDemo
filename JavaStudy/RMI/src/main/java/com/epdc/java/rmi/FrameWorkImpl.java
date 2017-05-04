package com.epdc.java.rmi;

import java.rmi.RemoteException;

/**
 * Created by devin on 2017/4/26.
 */
public class FrameWorkImpl implements FrameWorkInterface {

    // instance field (base of common memory)
    private FrameWorkBase fwb;
    // constructor
    public FrameWorkImpl (FrameWorkBase reference_to_fwb)
            throws RemoteException {

        // set common memory reference
        fwb = reference_to_fwb;
    }

    @Override
    public Object[] syncRequest(FrameWorkParm in) throws RemoteException {
        return new Object[0];
    }

    @Override
    public Object[] asyncRequest(FrameWorkParm in) throws RemoteException {
        return new Object[0];
    }

    @Override
    public String shutRequest() throws RemoteException {
        return null;
    }
}
