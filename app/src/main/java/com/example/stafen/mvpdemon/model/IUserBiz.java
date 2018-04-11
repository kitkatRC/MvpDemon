package com.example.stafen.mvpdemon.model;

/**
 * Created by stafen on 2018/4/2.
 */

public interface IUserBiz {
    //业务请求操作接口------------登陆接口
    void onLogin(String userName,String psw,OnLoginCallback onLoginCallback);

    void onSearch(String location);
}

