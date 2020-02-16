package com.example.simpletext.text;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.simpletext.R;

public class GestureDetectorDemo extends AppCompatActivity {
    private static final String TAG = "GES";
    private ImageView imgView;
    private int img_count = 0;



    /**
     *
     * 文档链接
     *
     * https://developer.android.google.cn/training/custom-views/making-interactive.html?hl=zn
     * */

    //2
    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            Log.i(TAG, "onFling: =点到了");
//
            if ((e1.getX() - e2.getX()) > 50) {
                imgView.setImageResource(change());


            } else if ((e2.getX() - e1.getX()) > 50) {
                imgView.setImageResource(change());

            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    int change() {
        if ((img_count / 2) % 2 == 0) {
            img_count += 1;
            return R.drawable.b1;
        } else {
            img_count++;
            return R.drawable.b2;
        }

    }

    GestureDetector myGestureDetector;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gsture_detector_demo);
        imgView = findViewById(R.id.imageView);
        //4
        myGestureDetector = new GestureDetector(new MyGestureListener());

        //  1
        imgView.setOnTouchListener(new View.OnTouchListener() {
            @Override // 获得点击事件  传给 GestureDector
            public boolean onTouch(View v, MotionEvent event) {
                //3
                myGestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }
}
