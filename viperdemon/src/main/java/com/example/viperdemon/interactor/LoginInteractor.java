package com.example.viperdemon.interactor;

import android.text.TextUtils;

import com.example.viperdemon.contactrs.BaseContacts;
import com.example.viperdemon.entity.LoginResponse;

/**
 * Created by stafen on 2018/4/10.
 */

public class LoginInteractor implements BaseContacts.interactor {

    private BaseContacts.interactorCallback<LoginResponse> mLoginResponseinteractorCallback;

    public LoginInteractor(BaseContacts.interactorCallback<LoginResponse> loginResponseinteractorCallback) {
        mLoginResponseinteractorCallback = loginResponseinteractorCallback;
    }

    @Override
    public void onLogin(String username, String psw) {
        //请求数据----------------------做逻辑操作
        //logical operations
        if (!"".equals(username) || !TextUtils.isEmpty(psw)) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.name = username;
            loginResponse.psw = psw;
            //回调数据到present----view
            mLoginResponseinteractorCallback.onLoginCallback(loginResponse);
        } else
            //请求数据失败-------------
            mLoginResponseinteractorCallback.showFail("login fail。。Game Over");
    }

    @Override
    public void unRegistered() {
        //注销实例
        if (mLoginResponseinteractorCallback != null) {
            mLoginResponseinteractorCallback = null;
        }
        //Release the instance in the logical operation.

    }
}
