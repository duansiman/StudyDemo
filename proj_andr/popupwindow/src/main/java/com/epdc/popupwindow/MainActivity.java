package com.epdc.popupwindow;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean flag = this.checkCallingOrSelfPermission(Manifest.permission.ACCESS_CHECKIN_PROPERTIES) == PackageManager.PERMISSION_DENIED;
    }

    public void showPopup(View v){
        PopupWindow popupWindow = new PopupWindow(View.inflate(this, R.layout.layout_popup, null));
        popupWindow.showAtLocation(this.getWindow().getDecorView(), Gravity.BOTTOM,0,0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
