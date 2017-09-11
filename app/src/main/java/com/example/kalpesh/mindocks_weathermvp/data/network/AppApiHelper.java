package com.example.kalpesh.mindocks_weathermvp.data.network;

import com.example.kalpesh.mindocks_weathermvp.data.network.model.WeatherResponse;
import com.example.kalpesh.mindocks_weathermvp.data.network.services.ConnectionService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by kalpesh on 21/08/2017.
 */
@Singleton
public class AppApiHelper implements ApiHelper {

   RequestInterface requestInterface;

   @Inject
    public AppApiHelper() {
        requestInterface= ConnectionService.getConnectionService();
    }


    @Override
    public Observable<WeatherResponse> getWeather5DaysForecast() {
        /**
         * Both techniques do work
         */
       return requestInterface.fetch_Weather5DaysForecast();

//        return Rx2AndroidNetworking.get(ApiEndPoint.API_WEATHER+ApiEndPoint.API_WEATHER_5_DAYS + ApiEndPoint.WEATHER_API_KEY)
//                .build()
//                .getObjectObservable(WeatherResponse.class);
    }
}
