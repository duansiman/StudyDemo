package com.epdc.java.rmi;

import java.io.Serializable;

/**
 * Created by devin on 2017/4/26.
 */
public class FrameWorkParm implements Serializable {

    // passed data from Client
    private Object client_data;
    // Function name
    private String func_name;
    // maximum time to wait for a reply
    private int wait_time;
    // priority of the request
    private int priority;

}
