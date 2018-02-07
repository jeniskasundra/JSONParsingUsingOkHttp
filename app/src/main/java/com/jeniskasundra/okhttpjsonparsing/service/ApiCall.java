package com.jeniskasundra.okhttpjsonparsing.service;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Jenis Kasundra on 2/2/2018.
 */

public class ApiCall {

    //GET network request
    public static String GET(String url){
        String strJson=null;
        try {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        strJson=response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strJson;
    }

}