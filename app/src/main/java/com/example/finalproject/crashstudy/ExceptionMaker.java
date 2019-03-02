package com.example.finalproject.crashstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExceptionMaker {
    public static final int RUNTIME_EXCEPTION = 0;
    public static final int CONCURRENTMODIFICATION_EXCEPTION = 1;

    // TODO https://www.apteligent.com/technical-resource/top-5-crashes-on-android/
    // TODO https://stackoverflow.com/questions/33011319/what-are-the-list-of-android-specific-exceptions

    public static void makeException(int type) {
        switch (type) {
            case RUNTIME_EXCEPTION:
                triggerRuntimeException();
                break;
            case CONCURRENTMODIFICATION_EXCEPTION:
                triggerConcurrentModificationException();
                break;
        }
    }

    public static void triggerRuntimeException() {
        throw new RuntimeException();
    }

    public static void triggerConcurrentModificationException() {
        // https://stackoverflow.com/questions/223918/iterating-through-a-collection-avoiding-concurrentmodificationexception-when-re?rq=1
        List<String> list = new ArrayList<>(Arrays.asList("1", "2"));
        for (String item: list) {
            list.remove(item);
        }
    }
}
