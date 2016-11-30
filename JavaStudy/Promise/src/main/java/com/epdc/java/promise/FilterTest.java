package com.epdc.java.promise;

import org.jdeferred.Deferred;
import org.jdeferred.DoneCallback;
import org.jdeferred.DoneFilter;
import org.jdeferred.Promise;
import org.jdeferred.impl.DeferredObject;

/**
 * Created by devin on 2016/11/30.
 */
public class FilterTest {

    public static void main(String[] args) {
        Deferred deferred = new DeferredObject();

        Promise filterPromise = deferred.promise().then(new DoneFilter<Integer, Integer>() {
            public Integer filterDone(Integer result) {
                return result*3;
            }
        });

        filterPromise.done(new DoneCallback<Integer>() {
            public void onDone(Integer o) {
                System.out.println(o);
            }
        });

        deferred.resolve(3);
    }

}
