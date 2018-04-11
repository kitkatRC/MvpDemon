package com.example.stafen.mvpdemon.persenter;

import com.example.stafen.mvpdemon.bean.UserResponse;

/**
 * Created by stafen on 2018/4/2.
 */

public interface IUserLogin {
    void showPrograssDialog();
    void hidePrograssDialog();
    String getUserName();
    String getUserPsw();

    void ToActivity(UserResponse userResponse);
    void showFailErrorMsg();
}
