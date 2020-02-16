package com.example.simpletext.text;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;


public class MyHttpThread extends Thread {
    // http 访问需要三个参数  url

    private String url;
    private WebView view;
    private Handler handler;

    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
     * {@code (null, null, gname)}, where {@code gname} is a newly generated
     * name. Automatically generated names are of the form
     * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
     * <p>
     * url  请求的链接
     * webview 显示网页的地方
     * hander 传递得到的信息到页面显示出来
     */
    public MyHttpThread(String url, WebView view, Handler handler) {
        this.url = url;
        this.view = view;
        this.handler = handler;
    }

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     * <p>
     * <p>
     * url
     */

    @Override
    public void run() {
//        Looper.prepare();
        // 处理 url
        try {
            URL httpUrl = new URL(url);
            //获得链接
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection(); //conn 存储了我们得到信息
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            int resultCode = conn.getResponseCode();
            System.out.println("info========" + resultCode);
            //信息处理
            //1
            StringBuffer sb = new StringBuffer();
//            InputStream inputStream = conn.getInputStream();
//            InputStreamReader inReader = new InputStreamReader(inputStream);
//            BufferedReader reader = new BufferedReader(inReader);
//            String str;
//            //读一行  村一行
//            while ((str = reader.readLine()) != null) {
//                sb.append(str);
//            }
//            //显示到页面
//            final String resultString = sb.toString();
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    view.loadData(resultString, "text/html", "charset=utf-8");
//                }
//
//            });
            System.out.println("info===========" + sb.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }
        super.run();
    }
}
