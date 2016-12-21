package com.epdc.actionbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

import com.epdc.fragment.R;

/**
 *  actionbar 分享
 * Created by Epdc on 2015/9/16.
 */
public class ActionBarShareActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.actionbar_share, menu);
        MenuItem shareItem = menu.findItem(R.id.menu_share);
        ShareActionProvider provider = (ShareActionProvider) shareItem
                .getActionProvider();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
        intent.putExtra(Intent.EXTRA_TEXT, "使用ShareActionProvider");
        provider.setShareIntent(intent);

        return true;
    }


}
