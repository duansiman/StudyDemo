package com.epdc.webservice;

import android.os.AsyncTask;

/**
 * Created by epdc on 2016/5/22.
 */
public class AsyncOperation<R> extends AsyncTask<Void, Void, R> {

    private OnAsyncTask<R> onAsyncTask;

    public AsyncOperation(OnAsyncTask<R> onAsyncTask) {
        this.onAsyncTask = onAsyncTask;
    }

    @Override
    protected R doInBackground(Void... p1s) {
        return onAsyncTask.doTask();
    }

    @Override
    protected void onPostExecute(R r) {
        super.onPostExecute(r);
        onAsyncTask.onResult(r);
    }

    public interface OnAsyncTask<R> {
        R doTask();
        void onResult(R r);
    }

    public static class SimpleOnAsyncTask<R> implements OnAsyncTask<R> {


        @Override
        public R doTask() {
            return null;
        }

        @Override
        public void onResult(R r) {

        }
    }
}
