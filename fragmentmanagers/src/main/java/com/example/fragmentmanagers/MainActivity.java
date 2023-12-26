package com.example.fragmentmanagers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(this);

        Button button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn:
                Bundle bundle = new Bundle();
                bundle.putString("message","测试测试");
                BlankFragment1 bf = new BlankFragment1();
                bf.setArguments(bundle);

                bf.setFragmentCallBack(new IFragmentCallBack() {
                    @Override
                    public void sendMsgToActivity(String msg) {
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public String getMsgFromActivity(String msg) {
                        return "hello,im from activity";
                    }
                });


                replaceFragment(bf);
                break;
            case R.id.btn2:
                replaceFragment(new ItemFragment());
                break;
        }
    }

    //动态切换fragment
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}