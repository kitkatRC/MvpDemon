package com.example.stafen.mvpdemon.model;

/**
 * Created by stafen on 2018/4/2.
 */

public interface OnLoginCallback<T> {
    //TODO 回调接口
    void onSuccess(T response);

    void onFail();
}
