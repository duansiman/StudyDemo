package com.devin.java.jms.remote;

/**
 * Created by devin on 2016/12/23.
 */
public class SimpleCheckingAccountService implements CheckingAccountService {

    public void cancelAccount(Long accountId) {
        System.out.println("Cancelling account [" + accountId + "]");
    }

}
