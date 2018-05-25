package com.example.viperdemon.present;

import android.app.Activity;

import com.example.viperdemon.contactrs.BaseContacts;
import com.example.viperdemon.contactrs.BaseContacts.interactorCallback;
import com.example.viperdemon.entity.LoginResponse;
import com.example.viperdemon.interactor.LoginInteractor;
import com.example.viperdemon.router.LoginRoute;

/**
 * Created by stafen on 2018/4/10.
 */

public class LoginPresent implements BaseContacts.present, interactorCallback<LoginResponse> {

    public LoginPresent(BaseContacts.view<LoginResponse> view) {
        mView = view;
        mRoute = new LoginRoute((Activity) mView);
    }

    private BaseContacts.view<LoginResponse> mView;
    private BaseContacts.route mRoute = null;
    private LoginInteractor mLoginInteractor = new LoginInteractor(this);

    @Override
    public void onLoginButtonPress(String username, String password) {
        mView.showProgerssDiaolog();
        mLoginInteractor.onLogin(username, password);
    }

    @Override
    public void onDestory() {
        //释放对象
        mLoginInteractor.unRegistered();
        mLoginInteractor = null;
        mView=null;
        mRoute=null;
    }

    @Override
    public void onLoginCallback(LoginResponse respponse) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.psw="999";
        //callback data
        mView.hideProgerssDiaolog();
        //回调数据---------------------------------------------
        if (respponse != null) {
            //传给view进行显示
            mRoute.goToNextActivity(respponse);
            mView.initView(respponse);
            mRoute.unRegister();
        } else {
            mView.showError("no data?");
        }
    }

    @Override
    public void showFail(String msg) {
        mView.hideProgerssDiaolog();
        mView.showError(msg);
    }

}
