package com.example.eventprocessing;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EventActivity extends Activity implements View.OnClickListener {
    private int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        ImageView mImage = (ImageView) findViewById(R.id.img);
        RadioGroup mRadioGroup = (RadioGroup) findViewById(R.id.radio);
        Button mButton1 = (Button) findViewById(R.id.button_login);
        Button mButton2 = (Button) findViewById(R.id.button_signin);

        mImage.setOnClickListener(this);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mRadioGroup.setOnCheckedChangeListener(new mRadioGrouponClickListener());
    }

    @Override
    public void onClick(View v){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        switch (v.getId()){
            case R.id.img:
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                final AlertDialog.Builder dialog = new AlertDialog.Builder(EventActivity.this);
                final String[] items = { "拍摄", "从相册选择" };
                dialog.setTitle("上传头像");
                dialog.setItems(items, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        //which 下表从0开始
                        //...To-do
                        Toast.makeText(EventActivity.this, "您选择了["+items[which]+"]",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("取消",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i){
                                Toast.makeText(getApplicationContext(),
                                        "您点击了取消", Toast.LENGTH_SHORT).show();
                            }
                        });
                dialog.show();
                break;
//            case R.id.radio_student:
//                Snackbar.make(v, "您选择了学生", Snackbar.LENGTH_SHORT)
//                        .setAction("确定", new View.OnClickListener(){
//                            @Override
//                            public void onClick(View v){
//                                Toast.makeText(EventActivity.this,
//                                        "Snackbar 的确定按钮被点击了", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setActionTextColor(Color.parseColor("#3F51B5")).show();
//            case R.id.radio_teacher:
//                Snackbar.make(v, "您选择了教职工", Snackbar.LENGTH_SHORT)
//                        .setAction("确定", new View.OnClickListener(){
//                            @Override
//                            public void onClick(View v){
//                                Toast.makeText(EventActivity.this,
//                                        "Snackbar 的确定按钮被点击了", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setActionTextColor(Color.parseColor("#3F51B5")).show();
            case R.id.button_signin:
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                if(flag == 1){
                    Snackbar.make(v, "学生注册功能尚未启用", Snackbar.LENGTH_SHORT)
                            .setAction("确定", new View.OnClickListener(){
                                @Override
                                public void onClick(View v){
                                    Toast.makeText(EventActivity.this,
                                            "Snackbar 的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setActionTextColor(Color.parseColor("#3F51B5")).show();
                }
                else{
                    Snackbar.make(v, "教职工注册功能尚未启用", Snackbar.LENGTH_SHORT)
                            .setAction("确定", new View.OnClickListener(){
                                @Override
                                public void onClick(View v){
                                    Toast.makeText(EventActivity.this,
                                            "Snackbar 的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setActionTextColor(Color.parseColor("#3F51B5")).show();
                }
                break;
            case R.id.button_login:
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                TextInputLayout mNumbertext = (TextInputLayout) findViewById(R.id.edit_number);
                TextInputLayout mPasstext = (TextInputLayout) findViewById(R.id.edit_password);
                String IdNumber = mNumbertext.getEditText().getText().toString();
                String pass = mPasstext.getEditText().getText().toString();
                Log.d("Idnumber", IdNumber);
                if(TextUtils.isEmpty(IdNumber)){
                    //Log.d("Idnumber","empty");
                    mNumbertext.setError("学号不能为空");
                }
                else{
                    mNumbertext.setErrorEnabled(false);
                }
                if(TextUtils.isEmpty(pass)){
                    mPasstext.setError("密码不能为空");
                }
                else{
                    mPasstext.setErrorEnabled(false);
                }
                if(IdNumber.equals("123456") && pass.equals("6666")){
                    Snackbar.make(v, "登陆成功", Snackbar.LENGTH_SHORT)
                            .setAction("确定", new View.OnClickListener(){
                                @Override
                                public void onClick(View v){
                                    Toast.makeText(EventActivity.this,
                                            "Snackbar 的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setActionTextColor(Color.parseColor("#3F51B5")).show();
                }
                else{
                    Snackbar.make(v, "学号或密码错误", Snackbar.LENGTH_SHORT)
                            .setAction("确定", new View.OnClickListener(){
                                @Override
                                public void onClick(View v){
                                    Toast.makeText(EventActivity.this,
                                            "Snackbar 的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setActionTextColor(Color.parseColor("#3F51B5")).show();
                }
                break;
             default:
                break;
        }
    }
    private class mRadioGrouponClickListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            switch(checkedId){
                case R.id.radio_student:
                    imm.hideSoftInputFromWindow(group.getWindowToken(), 0);
                    Snackbar.make(group, "您选择了学生", Snackbar.LENGTH_SHORT)
                            .setAction("确定", new View.OnClickListener(){
                                @Override
                                public void onClick(View v){
                                    Toast.makeText(EventActivity.this,
                                            "Snackbar 的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setActionTextColor(Color.parseColor("#3F51B5")).show();
                    flag = 1;
                    break;
                case R.id.radio_teacher:
                    imm.hideSoftInputFromWindow(group.getWindowToken(), 0);
                    Snackbar.make(group, "您选择了教职工", Snackbar.LENGTH_SHORT)
                            .setAction("确定", new View.OnClickListener(){
                                @Override
                                public void onClick(View v){
                                    Toast.makeText(EventActivity.this,
                                            "Snackbar 的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setActionTextColor(Color.parseColor("#3F51B5")).show();
                    flag = 2;
                    break;
                default:
                    break;
            }
        }
    }
}
