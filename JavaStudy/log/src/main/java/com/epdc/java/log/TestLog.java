package com.epdc.java.log;


import org.apache.log4j.Logger;

/**
 * Created by devin on 2016/12/1.
 */
public class TestLog {

    private static final Logger log = Logger.getLogger(TestLog.class);

    public static void main(String[] args) {
        log.debug("this debug");
        log.info("this info");
        log.warn("this warn");
        log.error("this error");
    }

}
