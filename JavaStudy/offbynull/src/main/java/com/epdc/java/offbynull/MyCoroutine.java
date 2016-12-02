package com.epdc.java.offbynull;

import com.offbynull.coroutines.user.Continuation;
import com.offbynull.coroutines.user.Coroutine;
import com.offbynull.coroutines.user.CoroutineRunner;

/**
 * Created by devin on 2016/12/1.
 */
public final class MyCoroutine implements Coroutine {
    @Override
    public void run(Continuation c) {
        System.out.println("started");
        for (int i = 0; i < 10; i++) {
            echo(c, i);
        }
    }

    private void echo(Continuation c, int x) {
        System.out.println(x);
        c.suspend();//暂停执行
    }

    public static void main(String[] args) {
        CoroutineRunner r = new CoroutineRunner(new MyCoroutine());
        new Thread(()-> r.execute());
        System.out.println("exec ");
        r.execute();//如果没有执行，继续执行
        r.execute();
        r.execute();
    }
}
