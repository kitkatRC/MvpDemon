package com.example.viperdemon.contactrs;

/**
 * Created by stafen on 2018/4/10.
 */

public interface BaseContacts {

    interface view<T> {
        void showError(String msg);

        void initView(T response);

        void showProgerssDiaolog();

        void hideProgerssDiaolog();
    }

    interface present {
        void onLoginButtonPress(String useranem, String password);

        void onDestory();
    }

    interface interactor {
        void onLogin(String username, String psw);

        void unRegistered();
    }

    interface interactorCallback<T> {
        void onLoginCallback(T respponse);

        void showFail(String msg);
    }

    interface route<T> {
        void goToNextActivity(T response);

        void unRegister();
    }
}
