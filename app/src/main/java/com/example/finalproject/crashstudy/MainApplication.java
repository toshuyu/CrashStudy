package com.example.finalproject.crashstudy;

import android.app.Application;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;

public class MainApplication extends Application {
    public static final String TAG = MainApplication.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();

        // same effect as below
        // CrashHandler crashHandler = CrashHandler.getInstance();
        // crashHandler.init(getApplicationContext());


        // Default uncaught exception handler.
        // If exceptions are not caught, they'll be handled by this handler
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable ex) {

                new Thread() {
                    @Override
                    public void run() {
                        Looper.prepare();
                        Toast.makeText(getApplicationContext(), "很抱歉，APP出了問題，即將重啟", Toast.LENGTH_LONG).show();
                        Looper.loop();
                    }
                }.start();

                // send logs to Crashlytics
                Crashlytics.logException(ex);

                try {
                    // make a thread to show toast
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Log.e(TAG, "Thread error: ", e);
                }

                // stop the app
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}
