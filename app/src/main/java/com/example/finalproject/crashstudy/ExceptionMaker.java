package com.example.finalproject.crashstudy;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.crashlytics.android.Crashlytics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExceptionMaker {
    private final static String TAG = ExceptionMaker.class.getSimpleName();
    public static final int RUNTIME_EXCEPTION = 0;
    public static final int CONCURRENTMODIFICATION_EXCEPTION = 1;
    public static final int BADTOKEN_EXCEPTION = 2;
    public static final int NUMBER_FORMAT_EXCEPTION = 4;

    // TODO https://www.apteligent.com/technical-resource/top-5-crashes-on-android/
    // TODO https://stackoverflow.com/questions/33011319/what-are-the-list-of-android-specific-exceptions

    public static void makeException(int type, Context context) {
        switch (type) {
            case RUNTIME_EXCEPTION:
                triggerRuntimeException();
                break;
            case CONCURRENTMODIFICATION_EXCEPTION:
                triggerConcurrentModificationException();
                break;
            case BADTOKEN_EXCEPTION:
                triggerBadTokenException(context);
                break;
            case NUMBER_FORMAT_EXCEPTION:
                triggerNumberFormatException(context);
                break;
        }
    }

    public static void triggerRuntimeException() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    throw new RuntimeException();
                } catch (RuntimeException e){
                    Crashlytics.setInt("classid", RUNTIME_EXCEPTION);
                    Crashlytics.log(Log.ERROR, TAG, "this is a customized catch");
                    Crashlytics.logException(e);
                }
            }
        }).start();
    }

    public static void triggerConcurrentModificationException() {
        // https://stackoverflow.com/questions/223918/iterating-through-a-collection-avoiding-concurrentmodificationexception-when-re?rq=1
        new Thread(new Runnable() {
            public void run() {
                List<String> list = new ArrayList<>(Arrays.asList("1", "2"));
                for (String item: list) {
                    list.remove(item);
                }
            }
        }).start();
    }

    public static void triggerBadTokenException(Context context) {
        // // https://stackoverflow.com/questions/18662239/android-view-windowmanagerbadtokenexception-unable-to-add-window-on-buider-s
        Intent intent = new Intent(context, BadTokenDemoActivity.class);
        context.startActivity(intent);
    }

    public static void triggerNumberFormatException(Context context) {
        Intent intent = new Intent(context, NumberFormatActivity.class);
        context.startActivity(intent);
    }
}
