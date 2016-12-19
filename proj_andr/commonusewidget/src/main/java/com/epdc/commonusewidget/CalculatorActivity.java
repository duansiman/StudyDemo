package com.epdc.commonusewidget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epdc.commonusekownledge.R;

import java.util.Stack;

/**
 * 计算器
 * Created by Epdc on 2015/8/30.
 */
public class CalculatorActivity extends Activity {

    private EditText etShow;
    private Stack<Double> stackNum;
    private Stack<Integer> stackOp;
    private String tempNum="";
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        etShow = (EditText) findViewById(R.id.etShow);
        stackNum = new Stack<>();
        stackOp = new Stack<>();
    }

    public void click(View v){
        if (!flag) {
            etShow.setText("");
            flag = true;
        }

        String showText = etShow.getText().toString();
        String btnValue = ((Button)v).getText().toString();

        showText = showText.substring(0, showText.length() - tempNum.length());

        if (tempNum.equals("0")) {
            if (!btnValue.equals("0")) {
                tempNum = btnValue;
            }
        } else {
            tempNum += btnValue;
        }
        showText += tempNum;
        etShow.setText(showText);
        etShow.setSelection(showText.length());
    }

    public void add(View v){
        opClick(Operation.ADD);
    }

    public void sub(View v){
        opClick(Operation.SUB);
    }

    public void mul(View v){
        opClick(Operation.MUL);
    }

    public void div(View v){
        opClick(Operation.DIV);
    }

    public void opClick(int op){
        if (!flag) {
            etShow.setText("");
            flag = true;
        }

        stackNum.push(Double.parseDouble(tempNum));
        tempNum = "";

        String showText = etShow.getText().toString();
        if(showText.substring(showText.length()-1,showText.length()).equals("+")
                || showText.substring(showText.length()-1,showText.length()).equals("-")
                || showText.substring(showText.length()-1,showText.length()).equals("x")
                || showText.substring(showText.length()-1,showText.length()).equals("/"))
        {
            showText = showText.substring(0,showText.length()-1);
        }
        switch (op) {
            case 1:
                showText += "-";
                break;
            case 2:
                showText += "+";
                break;
            case 4:
                showText += "x";
                break;
            case 5:
                showText += "/";
                break;
        }
        etShow.setText(showText);
        etShow.setSelection(showText.length());

        if(stackOp.size() == 0){
            stackOp.push(op);
        } else {
            int pre = stackOp.pop();
            //优先级高操作符
            if (op - pre >= 2) {
                stackOp.push(pre);
                stackOp.push(op);
            //同优先级的操作符
            } else {
                double firstNum = stackNum.pop();
                double secondNum = stackNum.pop();
                double result=0;

                switch (pre) {
                    case 1:
                        result = secondNum - firstNum;
                        break;
                    case 2:
                        result = secondNum + firstNum;
                        break;
                    case 4:
                        result = secondNum * firstNum;
                        break;
                    case 5:
                        result = (double)(secondNum / firstNum);
                        break;
                }
                stackNum.push(result);
                stackOp.push(op);
            }
        }
    }

    public void reset(View v){
        etShow.setText("");
        clear();
    }

    public void result(View v){
        flag = false;
        stackNum.push(Double.parseDouble(tempNum));
        tempNum = "";

        while (!stackOp.empty()) {
            double firstNum = stackNum.pop();
            double secondNum = stackNum.pop();
            double result=0;
            int pre = stackOp.pop();

            switch (pre) {
                case 1:
                    result = secondNum - firstNum;
                    break;
                case 2:
                    result = secondNum + firstNum;
                    break;
                case 4:
                    result = secondNum * firstNum;
                    break;
                case 5:
                    result = (double)(secondNum / firstNum);
                    break;
            }
            stackNum.push(result);
        }

        double result = stackNum.pop();
        etShow.setText(""+ result);
        etShow.setSelection((""+ result).length());
        clear();
    }

    public void clear(){
        stackNum.clear();
        stackOp.clear();
        tempNum = "";
    }

}
