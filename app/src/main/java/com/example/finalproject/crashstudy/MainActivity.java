package com.example.finalproject.crashstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ExceptionInfo> list;
    private RecyclerView rv;
    private MainRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateExceptionInfoList();
        rv = findViewById(R.id.rvMainList);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new MainRecyclerViewAdapter(list, this);
        rv.setAdapter(adapter);
    }

    private void generateExceptionInfoList() {
        list = new ArrayList<>();
        list.add(new ExceptionInfo("Runtime Exception", ExceptionMaker.RUNTIME_EXCEPTION, "just simply throw RuntimeException"));
        list.add(new ExceptionInfo("Concurrent Modification Exception", ExceptionMaker.CONCURRENTMODIFICATION_EXCEPTION, "https://docs.oracle.com/javase/7/docs/api/java/util/ConcurrentModificationException.html"));
        list.add(new ExceptionInfo("Bad Token Exception", ExceptionMaker.BADTOKEN_EXCEPTION, "android.view.WindowManager$BadTokenException: Unable to add window -- token null is not valid; is your activity running?"));
        list.add(new ExceptionInfo("Number Format Exception", ExceptionMaker.NUMBER_FORMAT_EXCEPTION, "java.lang. NumberFormatException"));
    }


}
