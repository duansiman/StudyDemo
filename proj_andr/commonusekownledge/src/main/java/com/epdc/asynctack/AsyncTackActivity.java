package com.epdc.asynctack;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.epdc.fragment.R;

/**
 *  AsyncTack 异步任务，但可以在里面处理控件
 * Created by Epdc on 2015/9/18.
 */
public class AsyncTackActivity extends Activity {

    private ProgressBar pbAsyncTack;
    private TextView tvShowPrecent;
    private ProgressAsyncTack paAsyncTack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctack);

        this.pbAsyncTack = (ProgressBar) findViewById(R.id.pbAsyncTack);
        this.tvShowPrecent = (TextView) findViewById(R.id.tvShowPrecent);
    }

    public void start(View v){

        paAsyncTack = new ProgressAsyncTack();
        paAsyncTack.execute("hello asynctask");

    }

    public void close(View v){
        paAsyncTack.cancel(true);
    }

    public class ProgressAsyncTack extends AsyncTask<String,Integer,Integer>{

        @Override
        protected Integer doInBackground(String... params) {
            System.out.println("doInBackground");
            for (int i = 0; i < 5; i++) {
                publishProgress(20); //来触发onProgressUpdate
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    if (isCancelled()) {
                        break;
                    }
                }
            }
            return pbAsyncTack.getProgress();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(AsyncTackActivity.this,"onPreExecute",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onCancelled(Integer integer) {
            //中途取消，调用该方法
            super.onCancelled(integer);
            Toast.makeText(AsyncTackActivity.this,"onCancelled"+integer,Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onCancelled() {
            //中途取消，调用该方法，然后调用带参数的 onCancelled
            super.onCancelled();
            Toast.makeText(AsyncTackActivity.this,"onCancelled",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            //正常结束 执行该方法
            super.onPostExecute(integer);
            Toast.makeText(AsyncTackActivity.this,"onPostExecute:"+integer,Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Toast.makeText(AsyncTackActivity.this,"onProgressUpdate",Toast.LENGTH_SHORT).show();
            super.onProgressUpdate(values);
            pbAsyncTack.setProgress(values[0] + pbAsyncTack.getProgress());
            tvShowPrecent.setText(pbAsyncTack.getProgress()+"%");
        }
    }
}
