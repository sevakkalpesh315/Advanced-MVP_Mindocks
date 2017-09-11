package com.example.kalpesh.mindocks_weathermvp.data.network;


import com.example.kalpesh.mindocks_weathermvp.data.network.model.WeatherResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * Created by kalpesh on 14/08/2017.
 */

public interface RequestInterface {
    @GET(ApiEndPoint.API_WEATHER_5_DAYS + ApiEndPoint.WEATHER_API_KEY)
    Observable<WeatherResponse> fetch_Weather5DaysForecast();
}
