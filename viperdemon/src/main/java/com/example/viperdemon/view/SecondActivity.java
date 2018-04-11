package com.example.viperdemon.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.viperdemon.R;
import com.example.viperdemon.entity.LoginResponse;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LoginResponse loginResponse = getIntent().getParcelableExtra("login");
        Log.e(TAG, "onCreate: " + loginResponse.toString());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(loginResponse.toString());
    }
}
