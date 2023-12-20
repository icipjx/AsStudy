package com.example.jia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "jiaclick";
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);

        Button btn2 = findViewById(R.id.btn2);
        et = findViewById(R.id.et);



        btn2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String text = et.getText().toString();
                 Log.e(TAG, "输入内容为： "+text );


             }
         });


//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.e(TAG, "onClick: ");
//            }
//        });

        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.e(TAG, "onLongClick: " );
                return false;
            }
        });

        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.e(TAG, "onTouch: "+motionEvent.getAction());
                return false;
            }
        });


    }

    public void jiaClick(View view) {
        Log.e(TAG, "onClick: ");
    }


}