package com.example.finalproject.crashstudy;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable ex) {
                Crashlytics.logException(ex);
            }
        });
    }
}
