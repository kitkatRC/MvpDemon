package com.example.stafen.mvpdemon.model;

import com.example.stafen.mvpdemon.bean.UserResponse;

/**
 * Created by stafen on 2018/4/2.
 */

public class UserBiz implements IUserBiz{
    //TODO 实现--操作逻辑接口
    @Override
    public void onLogin(final String userName, final String psw, final OnLoginCallback onLoginCallback) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                //TODO 进行登陆操作或者其他耗时操作
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                UserResponse userResponse = new UserResponse();
                userResponse.UserName=userName;
                userResponse.Psw=psw;
                onLoginCallback.onSuccess(userResponse);

            }
        }.start();
    }

    @Override
    public void onSearch(String location) {

    }
}
