package com.example.stafen.mvpdemon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stafen.mvpdemon.R;
import com.example.stafen.mvpdemon.bean.UserResponse;
import com.example.stafen.mvpdemon.persenter.IUserLogin;
import com.example.stafen.mvpdemon.persenter.IUserLoginPresent;

public class MainActivity extends AppCompatActivity implements IUserLogin{
    private IUserLoginPresent mIUserLoginPresent=new IUserLoginPresent(this);
    private EditText mUser;
    private EditText mPsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUser = findViewById(R.id.user);
        mPsw = findViewById(R.id.psw);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIUserLoginPresent.onLogin();
            }
        });
    }

    @Override
    public void showPrograssDialog() {

    }

    @Override
    public void hidePrograssDialog() {

    }

    @Override
    public String getUserName() {
        return mUser.getText().toString().trim();
    }

    @Override
    public String getUserPsw() {
        return mPsw.getText().toString().trim();
    }

    @Override
    public void ToActivity(UserResponse userResponse) {
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
    }

    @Override
    public void showFailErrorMsg() {
        Toast.makeText(this,"登陆失败",Toast.LENGTH_SHORT).show();
    }
}
