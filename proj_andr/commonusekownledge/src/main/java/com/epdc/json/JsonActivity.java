package com.epdc.json;

import android.app.Activity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Toast;

import com.epdc.fragment.R;

import java.io.IOException;
import java.io.StringReader;

/**
 *  Json操作
 * Created by Epdc on 2015/9/14.
 */
public class JsonActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
    }

    public void parseJson(View view) {
        StringReader sr = new StringReader("[{'name':'李四','age':23},{'name':'张三','age':18}]");
        JsonReader reader = new JsonReader(sr);
        String show = "";
        try {
            reader.beginArray();
            while (reader.hasNext())
            {
                reader.beginObject();
                reader.setLenient(true);
                while (reader.hasNext()) {
                    String field = reader.nextName();
                    String name = null;
                    int age = 0;
                    if (field.equals("name")) {
                        name = reader.nextString();
                        show += name + ":";
                    } else if(field.equals("age")){
                        age = reader.nextInt();
                        show += age + "------";
                    }
                }
                reader.endObject();
            }
            reader.endArray();

            Toast.makeText(this, show, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
