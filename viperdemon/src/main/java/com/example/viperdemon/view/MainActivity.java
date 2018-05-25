package com.example.viperdemon.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.viperdemon.R;
import com.example.viperdemon.contactrs.BaseContacts;
import com.example.viperdemon.entity.LoginResponse;
import com.example.viperdemon.present.LoginPresent;

public class MainActivity extends AppCompatActivity implements BaseContacts.view<LoginResponse> {

    private EditText mEtUserName;
    private EditText mEtPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private LoginPresent mPresent = null;

    private void initData() {
        mPresent = new LoginPresent(MainActivity.this);
        mEtUserName = ((EditText) findViewById(R.id.et_username));
        mEtPassWord = ((EditText) findViewById(R.id.et_psw));
    }

    //按钮----------------------
    //测试注释----------------------------
    public void login(View view) {
        //传递数据进行请求逻辑
        String userName = mEtUserName.getText().toString().trim();
        String psw = mEtPassWord.getText().toString().trim();
//        Toast.makeText(this, ""+userName+"-"+psw, Toast.LENGTH_SHORT).show();
        mPresent.onLoginButtonPress(userName, psw);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initView(LoginResponse response) {
        //回调到请求到的数据
        Toast.makeText(this, "登陆成功:"+response.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgerssDiaolog() {
        //显示加载动画
        Toast.makeText(this, "登陆中。。。。。", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgerssDiaolog() {
        //隐藏加载
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresent.onDestory();
    }
    //////////////继续测试
    //test------------------------------------------123
    //test----ce111
    //test----------ce222222222222


    //test4----------------------111111
    //test6666666
//    test666662222
    //test 66666333
}
