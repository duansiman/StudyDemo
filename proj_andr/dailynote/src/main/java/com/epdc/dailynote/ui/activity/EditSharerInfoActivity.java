package com.epdc.dailynote.ui.activity;

import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.epdc.commonlib.ui.BaseActivity;
import com.epdc.commonlib.widget.ViewHolder;
import com.epdc.dailynote.R;
import com.epdc.commonlib.entity.MsgBean;
import com.epdc.dailynote.entity.Sharer;
import com.epdc.dailynote.presenter.SharerPresenter;

import org.greenrobot.eventbus.EventBus;

import java.util.Map;

public class EditSharerInfoActivity extends BaseActivity {

    public static final String KEY_SHARER = "sharer";
    private SharerPresenter presenter;
    private Sharer sharer;
    private EditText editName;
    private EditText editSex;
    private EditText editPhone;
    private boolean isEdit;

    @Override
    protected ViewHolder initHolder() {
        return new ViewHolder(mContext, R.layout.activity_edit_sharer_info);
    }

    @Override
    protected void initView() {
        sharer = (Sharer) getIntent().getSerializableExtra(KEY_SHARER);

        editName = holder.get(R.id.edit_name);
        editSex = holder.get(R.id.edit_sex);
        editPhone = holder.get(R.id.edit_phone);
        if (sharer != null) {
            editName.setText(sharer.getName());
            editSex.setText(sharer.getGender() ? "男" : "女");
            editPhone.setText(sharer.getPhone());
            isEdit = true;
        } else {
            sharer = new Sharer();
            isEdit = false;
            setTitle("添加合租人");
        }
    }

    @Override
    protected void initEvent() {
        presenter = new SharerPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (invalidate()) {
            if (isEdit) {
                presenter.updateSharer(0, sharer);
            } else {
                presenter.addSharer(0, sharer);
            }
        }
        return true;
    }

    public boolean invalidate(){

        sharer.setName(editName.getText().toString());
        sharer.setGender(TextUtils.equals(editSex.getText().toString(), "男")?true:false);
        sharer.setPhone(editPhone.getText().toString());

        if (TextUtils.isEmpty(sharer.getName()) || TextUtils.isEmpty(sharer.getName())) {

            return false;
        }

        return true;
    }

    @Override
    public void onPresenterNotify(int reqCode, int resultCode, Map<String, Object> data) {
        super.onPresenterNotify(reqCode, resultCode, data);
        if (resultCode == 0) {
            EventBus.getDefault().post(new MsgBean(MsgBean.Type.REFRESH_SHARER));
        }
    }
}
