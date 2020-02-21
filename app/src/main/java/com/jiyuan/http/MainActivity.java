package com.jiyuan.http;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jiyuan.http.constant.ContentType;
import com.jiyuan.http.constant.HttpHeader;
import com.jiyuan.http.constant.SystemHeader;
import com.jiyuan.http.util.MessageDigestUtil;
import com.jiyuan.http.util.SignUtil;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.*;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "http://client.shjywlxx.com/api/hospital/gethospitalbyid";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            post();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void post() throws MalformedURLException {
        String appKey = "203781232";
        String appSecret = "nk7xj7pn9new7vbzsb94gab7iuw1conw";
        String host = "client.shjywlxx.com";
        String path = "/api/hospital/gethospitalbyid";
        Map<String, String> query = new HashMap<>();
        Map<String, String> bodys = new HashMap<>();
        bodys.put("hosptid", "1");
        Map<String, String> headers = new HashMap<>();
        headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, "application/x-www-form-urlencoded");
        headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "android");
        List<String> signHeaderPrefixList = new ArrayList<>();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        FormBody body = new FormBody.Builder()
                .add("hosptid", "1")
                .build();
        Request request = new Request.Builder()
                .url(URL)
                .post(body)
                .build();
        HttpUrl httpUrl = request.url();
        Log.e(TAG, "path = : " +  httpUrl.encodedPath());
        Log.e(TAG, "host = : " +  httpUrl.host());
        Map<String, String> basicHeader = initialBasicHeader(request.method(), path, headers,
                query, bodys, signHeaderPrefixList, appKey, appSecret);
        Request.Builder newBuild = request.newBuilder();
        for (Map.Entry<String, String> entry : basicHeader.entrySet()) {
            String key = entry.getKey();
            Log.e(TAG, "headers key = : " + key);
            String value = entry.getValue();
            Log.e(TAG, "headers value = : " + value);
            newBuild.addHeader(key, MessageDigestUtil.utf8ToIso88591(value));
        }
        client.newCall(newBuild.build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
//Server StringToSign:`POST#android##application/x-www-form-urlencoded##X-Ca-Key:203781232#X-Ca-Timestamp:1582264501633#/api/hospital/gethospitalbyid?hosptid=1`
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                int code = response.code();
                Log.e(TAG, "code: = " + code );
                String string = response.body().string();
                Log.e(TAG, "onResponse: = " + string );
            }
        });
    }

//    private okhttp3.Request buildRequest(String host, String path, int connectTimeout,
//                                         Map<String, String> headers, Map<String, String> querys, byte[] bodys,
//                                         List<String> signHeaderPrefixList, String appKey, String appSecret){
//
//    }

    private static Map<String, String> initialBasicHeader(String method, String path,
                                                          Map<String, String> headers,
                                                          Map<String, String> querys,
                                                          Map<String, String> bodys,
                                                          List<String> signHeaderPrefixList,
                                                          String appKey, String appSecret)
            throws MalformedURLException {
        if (headers == null) {
            headers = new HashMap<>();
        }

        headers.put(SystemHeader.X_CA_TIMESTAMP, String.valueOf(new Date().getTime()));
        //headers.put(SystemHeader.X_CA_NONCE, UUID.randomUUID().toString());
        headers.put(SystemHeader.X_CA_KEY, appKey);
        headers.put(SystemHeader.X_CA_SIGNATURE,
                SignUtil.sign(appSecret, method, path, headers, querys, bodys, signHeaderPrefixList));

        return headers;
    }
}
