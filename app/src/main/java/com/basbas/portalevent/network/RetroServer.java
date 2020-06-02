package com.basbas.portalevent.network;


import com.basbas.portalevent.utils.Constant;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {

    private static Retrofit retrofit;
//    private static RetroServer retroServer;

    public static Retrofit getClient()
    {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(Constant.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return  retrofit;
    }
//
//    private RetroServer(){
//        retrofit = new Retrofit.Builder()
//                .baseUrl(Constant.BASEURL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }
//
//    public static synchronized  RetroServer getInstance(){
//        if(retroServer == null){
//            retroServer = new RetroServer();
//        }return retroServer;
//    }
//
//    public RestApi getApi(){
//        return retrofit.create(RestApi.class);
//    }
}
