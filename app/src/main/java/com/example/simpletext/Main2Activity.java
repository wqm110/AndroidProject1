package com.example.simpletext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.simpletext.text.GestureDetectorDemo;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "Main2Activity";
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void toGestureDetector(View v) {
        intent = new Intent(this, GestureDetectorDemo.class);
        startActivity(intent);
        Log.i(TAG, "toGestureDetector: to 手势识别页面");

    }

    //跳转到百度页面
    public void toNewWebView(View v) {
        intent = new Intent(this, NewWebView.class);
        startActivity(intent);
        Log.i(TAG, "toNewWebView: Heep 详解");

    }
}
