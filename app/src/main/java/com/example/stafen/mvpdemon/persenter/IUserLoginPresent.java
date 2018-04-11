package com.example.stafen.mvpdemon.persenter;

import android.os.Handler;

import com.example.stafen.mvpdemon.bean.UserResponse;
import com.example.stafen.mvpdemon.model.OnLoginCallback;
import com.example.stafen.mvpdemon.model.UserBiz;

/**
 * Created by stafen on 2018/4/2.
 */

public  class IUserLoginPresent {
    private UserBiz mUserBiz;
    private IUserLogin mIUserLogin;
    private Handler mHandler = new android.os.Handler();

    public IUserLoginPresent( IUserLogin IUserLogin) {
        mUserBiz = new UserBiz();
        mIUserLogin = IUserLogin;
    }

    //登陆接口回调-----------------------------
    public void onLogin(){
        mIUserLogin.showPrograssDialog();
        mUserBiz.onLogin(mIUserLogin.getUserName(), mIUserLogin.getUserPsw(), new OnLoginCallback() {
            @Override
            public void onSuccess(final UserResponse userResponse) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //登陆成功即跳转到另外一个界面或者其他的操作
                        mIUserLogin.ToActivity(userResponse);
                        mIUserLogin.hidePrograssDialog();
                    }
                });
            }

            @Override
            public void onFail() {
                mIUserLogin.hidePrograssDialog();
                mIUserLogin.showPrograssDialog();
            }
        });
    }
}
