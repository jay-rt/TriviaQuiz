package com.example.triviaquiz;

import android.app.Application;

import com.example.triviaquiz.data.network.ServiceGenerator;

public class QuizApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ServiceGenerator.initialize(getApplicationContext());
    }
}
