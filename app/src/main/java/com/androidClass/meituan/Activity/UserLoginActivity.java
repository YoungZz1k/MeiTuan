package com.androidClass.meituan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidClass.meituan.R;

public class UserLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        // 获取用验证码登录时的手机号
        EditText userPhoneNumberWithMsg = findViewById(R.id.userPhoneNumberWithMsg);
        // 获取验证码按钮
        Button getMsgCode_button = findViewById(R.id.getMsgCode_button);

        // 监听号码输入框
        userPhoneNumberWithMsg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() == 11 && s.toString().startsWith("1")){
                    // 设置获取验证码按钮颜色
                    ColorStateList colorStateList = ColorStateList.valueOf(Color.parseColor("#FFC033"));
                    getMsgCode_button.setEnabled(true);
                    getMsgCode_button.setBackgroundTintList(colorStateList);
                }else if(s.length() > 11 || !s.toString().startsWith("1") ){
                    // 手机号大于11位或者不是以1开头弹出提示
                    Toast.makeText(getApplicationContext(),"请输入正确的手机号码",Toast.LENGTH_LONG).show();
                    // 号码输入错误获取登录按钮变为灰色并禁用按钮
                    getMsgCode_button.setEnabled(false);
                    ColorStateList colorStateList = ColorStateList.valueOf(Color.parseColor("#CCCCCC"));
                    getMsgCode_button.setBackgroundTintList(colorStateList);
                }
                else{
                    // 号码输入错误获取验证码按钮变为灰色并禁用按钮
                    getMsgCode_button.setEnabled(false);
                    ColorStateList colorStateList = ColorStateList.valueOf(Color.parseColor("#CCCCCC"));
                    getMsgCode_button.setBackgroundTintList(colorStateList);
                }
            }
        });

        // 用密码登录跳转
        findViewById(R.id.usePasswordLogin).setOnClickListener(v -> {
            Intent intent = new Intent(this, usePasswordActivity.class);
            startActivity(intent);
        });


    }
}