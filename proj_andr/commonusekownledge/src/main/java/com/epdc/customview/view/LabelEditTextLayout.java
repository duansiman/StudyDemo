package com.epdc.customview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.epdc.fragment.R;

/**
 * 自定义容器
 * Created by Epdc on 2015/8/31.
 */
public class LabelEditTextLayout extends LinearLayout {

    private String labelText;
    private int labelFontSize;

    public LabelEditTextLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        int resourceId = attrs.getAttributeResourceValue(null,"labelText",0);
        //是引用资源
        if (resourceId != 0) {
            labelText = getResources().getString(resourceId);
        } else {
            labelText = attrs.getAttributeValue(null,"labelText");
        }
        if (labelText == null) {
            throw new RuntimeException("必须设置labelText值");
        }

        resourceId = attrs.getAttributeResourceValue(null,"labelText",0);
        //是引用资源
        if (resourceId != 0) {
            labelFontSize = getResources().getInteger(resourceId);
        } else {
            labelFontSize = attrs.getAttributeIntValue(null, "labelFontSize", 14);
        }

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //指定ViewGroup为this
        LinearLayout labeleditlayout = (LinearLayout) inflater.inflate(R.layout.labeledittext_horizontal, this);
        TextView tvLabeltext = (TextView) findViewById(R.id.textView);

        tvLabeltext.setText(labelText);
        tvLabeltext.setTextSize(labelFontSize);
    }

}
