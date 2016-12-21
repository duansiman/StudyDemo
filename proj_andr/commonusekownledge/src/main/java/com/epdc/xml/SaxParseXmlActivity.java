package com.epdc.xml;

import android.app.Activity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Toast;

import com.epdc.fragment.R;
import com.epdc.model.Product;
import com.epdc.service.SaxProductXml;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *  Sax解析xml，比其他方式耗内存少，因为它是边读边解析
 * Created by Epdc on 2015/9/14.
 */
public class SaxParseXmlActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sax_xml);
    }

    public void parse(View view){
        InputStream is = getResources().openRawResource(R.raw.product);
        SaxProductXml handler = new SaxProductXml();
        try {
            Xml.parse(is, Xml.Encoding.UTF_8, handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        List<Product> products = handler.getProducts();
        String show = "";
        for (int i = 0; i < products.size(); i++) {
            show += products.get(i) + "-";
        }
        Toast.makeText(this,show,Toast.LENGTH_LONG).show();
    }
}
