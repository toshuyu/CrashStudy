package com.example.finalproject.crashstudy;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.widget.TextView;

public class BadTokenDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_token_demo);

        final TextView tv = findViewById(R.id.tvBadToken);

        // https://stackoverflow.com/questions/18662239/android-view-windowmanagerbadtokenexception-unable-to-add-window-on-buider-s
        new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                tv.setText((millisUntilFinished / 1000) + " sec");
            }

            public void onFinish() {
                AlertDialog.Builder builder = new AlertDialog.Builder(BadTokenDemoActivity.this)
                        .setMessage("To produce this exception, please Go Back to Previous Activity before countdown finish")
                        .setTitle("BadTokenException Demo Guide")
                        .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }.start();
    }
}
