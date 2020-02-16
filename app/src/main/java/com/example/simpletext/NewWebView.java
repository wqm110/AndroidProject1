package com.example.simpletext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;

import com.example.simpletext.text.MyHttpThread;

public class NewWebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_web_view);
        WebView webView = findViewById(R.id.webview);
        MyHttpThread thread =
                new MyHttpThread("http://111.231.141.151:8000/movie", webView, new Handler());
        thread.run();
    }
}
