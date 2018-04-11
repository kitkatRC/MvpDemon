package com.example.viperdemon.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by stafen on 2018/4/10.
 */

public class LoginResponse implements Parcelable {
    public String name;
    //    public String sex;
//    public int age;
//    public String address;
    public String psw;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "name='" + name + '\'' +
//                ", sex='" + sex + '\'' +
//                ", age=" + age +
//                ", address='" + address + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }

    protected LoginResponse(Parcel in) {
        name = in.readString();
//        sex = in.readString();
//        age = in.readInt();
//        address = in.readString();
        psw = in.readString();
    }

    public LoginResponse() {
    }

    public static final Creator<LoginResponse> CREATOR = new Creator<LoginResponse>() {
        @Override
        public LoginResponse createFromParcel(Parcel in) {
            return new LoginResponse(in);
        }

        @Override
        public LoginResponse[] newArray(int size) {
            return new LoginResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(psw);
    }
}
