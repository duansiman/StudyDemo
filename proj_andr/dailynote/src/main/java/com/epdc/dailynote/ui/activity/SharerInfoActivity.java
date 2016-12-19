package com.epdc.dailynote.ui.activity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.epdc.commonlib.ui.BaseActivity;
import com.epdc.commonlib.utils.IntentUtil;
import com.epdc.commonlib.widget.ViewHolder;
import com.epdc.dailynote.R;
import com.epdc.dailynote.entity.Sharer;

public class SharerInfoActivity extends BaseActivity {

    public static final String KEY_SHARER = "sharer";
    private Sharer sharer;

    @Override
    protected ViewHolder initHolder() {
        return new ViewHolder(mContext, R.layout.activity_sharer_info);
    }

    @Override
    protected void initView() {
        sharer = (Sharer) getIntent().getSerializableExtra(KEY_SHARER);

        TextView textName = holder.get(R.id.text_name);
        textName.setText(sharer.getName());

        TextView textSex = holder.get(R.id.text_sex);
        textSex.setText(sharer.getGender()?"男":"女");

        TextView textPhone = holder.get(R.id.text_phone);
        textPhone.setText(sharer.getPhone());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        IntentUtil.startActivity(mContext, EditSharerInfoActivity.class, EditSharerInfoActivity.KEY_SHARER, sharer);
        return true;
    }
}
