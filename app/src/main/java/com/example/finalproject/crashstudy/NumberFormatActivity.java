package com.example.finalproject.crashstudy;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;

public class NumberFormatActivity extends AppCompatActivity {
    private final static String TAG = NumberFormatActivity.class.getSimpleName();
    TextView ans;
    Handler handler;
    Integer number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_format);

        ans = findViewById(R.id.textAns);
        handler = new Handler();
    }

    final Runnable mainThreadRunnable = new Runnable() {
        public void run() {
            ans.setText(number.toString());
        }
    };

    public void showNumber(View view){
        EditText editText = findViewById(R.id.numberInput);
        final String text = editText.getText().toString();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    number = Integer.parseInt(text);
                    handler.post(mainThreadRunnable);
                } catch (NumberFormatException e){
                    Crashlytics.setInt("classid", ExceptionMaker.NUMBER_FORMAT_EXCEPTION);
                    Crashlytics.log(Log.ERROR, TAG, "got bad input. expected "+text+" to be an integer");
                    Crashlytics.logException(e);
                    Log.e(TAG, "error stack:", e);
                }
            }
        }).start();
    }

}
