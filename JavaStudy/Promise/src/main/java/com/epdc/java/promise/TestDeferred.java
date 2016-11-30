package com.epdc.java.promise;

import org.jdeferred.*;
import org.jdeferred.impl.DeferredObject;

/**
 * Created by devin on 2016/11/30.
 */
public class TestDeferred {

    public static void main(String[] args) {
        Deferred deferred = new DeferredObject();

        Promise promise = deferred.promise();
        promise.done(new DoneCallback() {
            public void onDone(Object o) {
                System.out.println(o);
            }
        }).fail(new FailCallback() {
            public void onFail(Object o) {
                System.out.println(o);
            }
        }).progress(new ProgressCallback() {
            public void onProgress(Object o) {
                System.out.println(o);
            }
        }).always(new AlwaysCallback() {
            public void onAlways(Promise.State state, Object o, Object o2) {
                System.out.println(state + ", "+o+", "+o2);
            }
        });

        deferred.resolve("done");
        deferred.reject("reject");
        deferred.notify("100%");
    }

}
