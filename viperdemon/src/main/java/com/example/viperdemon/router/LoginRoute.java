package com.example.viperdemon.router;

import android.app.Activity;
import android.content.Intent;

import com.example.viperdemon.view.SecondActivity;
import com.example.viperdemon.contactrs.BaseContacts;
import com.example.viperdemon.entity.LoginResponse;

/**
 * Created by stafen on 2018/4/10.
 */

public class LoginRoute implements BaseContacts.route<LoginResponse> {
    private Activity mContext;

    public LoginRoute(Activity context) {
        mContext = context;
    }

    @Override
    public void goToNextActivity(LoginResponse response) {
        //view routing logic
        Class<SecondActivity> aClass = SecondActivity.class;
        Intent intent = new Intent(mContext, aClass);
        intent.putExtra("login", response);
        mContext.startActivity(intent);
//        mContext.finish();
    }

    @Override
    public void unRegister() {
        if (mContext != null)
            mContext = null;

    }
}
