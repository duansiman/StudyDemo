package com.example.sharedpreferences;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sharedpreferences.R;
import com.example.sharedpreferences.utils.FilesUtil;
import com.example.sharedpreferences.utils.SDUtil;

public class FilesActivity extends Activity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

        editText = (EditText) findViewById(R.id.editText);

        System.out.println("db"+this.getDatabasePath("db.db"));
    }

    public void click(View v){
        switch (v.getId()) {
            case R.id.button:
                write();
                break;
            case R.id.button2:
                read();
                break;
        }
    }

    private void read() {
        /*String content = FilesUtil.readFiles(this, "file.txt");
        System.out.println(FilesUtil.getCacheDir(this));
        System.out.println(FilesUtil.getDir(this, "text.bin", MODE_PRIVATE));
        System.out.println(FilesUtil.getFilesDir(this));
        for (int i = 0; i < FilesUtil.fileList(this).length; i++) {
            System.out.println(FilesUtil.fileList(this)[i]);
        }*/
        String content = SDUtil.readFiles("file.txt");
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    private void write() {
//        FilesUtil.writeFiles(this, "file.txt", MODE_PRIVATE, editText.getText().toString());
        SDUtil.writeFiles("file.txt", editText.getText().toString());
    }


}
