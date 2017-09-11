package com.example.kalpesh.mindocks_weathermvp.data.network.services;

import com.example.kalpesh.mindocks_weathermvp.WeatherApplication;
import com.example.kalpesh.mindocks_weathermvp.data.network.ApiEndPoint;
import com.example.kalpesh.mindocks_weathermvp.data.network.RequestInterface;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kalpesh on 11/10/2016.
 */

public class ConnectionService {

    private static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient;

    public static RequestInterface getConnectionService(){
        okHttpClient = buildClient();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiEndPoint.API_WEATHER)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    //    .client(okHttpClient)
                    .build();
        }
        return retrofit.create(RequestInterface.class);
    }

    public static OkHttpClient buildClient() {
//
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //  builder.addNetworkInterceptor(new ResponseCacheInterceptor());
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        builder.addInterceptor(interceptor).build();
        // Enable response caching
        builder .addNetworkInterceptor(new Offline_CacheData.ResponseCacheInterceptor());
        builder .addInterceptor(new Offline_CacheData.OfflineResponseCacheInterceptor())
                // Set the cache location and size (5 MB)
                .cache(new Cache(new File(WeatherApplication
                        .getContext().getCacheDir(),
                        "apiResponses"), 5 * 1024 * 1024));
        return new OkHttpClient();


    }


}
