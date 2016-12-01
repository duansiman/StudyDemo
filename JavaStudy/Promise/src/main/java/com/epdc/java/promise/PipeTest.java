package com.epdc.java.promise;

import org.jdeferred.*;
import org.jdeferred.impl.DeferredObject;

/**
 * Created by devin on 2016/11/30.
 */
public class PipeTest {

    public static void main(String[] args) {

        Deferred d = new DeferredObject();
        Promise p = d.promise();

        p.then(new DonePipe<Integer, Integer, Exception, Void>() {

            public Promise<Integer, Exception, Void> pipeDone(Integer integer) {
                if (integer < 100) {
                    return new DeferredObject<Integer, Exception, Void>().resolve(integer);
                }
                return new DeferredObject<Integer, Exception, Void>().reject(new Exception("result > 100"));
            }
        }).done(new DoneCallback() {
            public void onDone(Object o) {
                System.out.println(o);
            }
        }).fail(new FailCallback() {
            public void onFail(Object o) {
                System.out.println(o);
            }
        });

        d.resolve(100);


    }

}
