package com.example.myprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar pb;
    private ProgressBar pb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = findViewById(R.id.pb);
        Button btn = findViewById(R.id.pbBtn);

        pb2 = findViewById(R.id.pb2);


    }

    public void pbBtnClick(View view) {
        if(pb.getVisibility() == View.GONE) {
            pb.setVisibility(View.VISIBLE);
        } else {
            pb.setVisibility(View.GONE );
        }
    }

    public void load(View view) {
        int progress = pb2.getProgress();
        progress += 10;
        pb2.setProgress(progress);
    }
}