package com.example.kalpesh.mindocks_weathermvp.data.network;


import com.example.kalpesh.mindocks_weathermvp.data.network.model.WeatherResponse;

import io.reactivex.Observable;

/**
 * Created by kalpesh on 21/08/2017.
 */

public interface ApiHelper {
    Observable<WeatherResponse> getWeather5DaysForecast();
}
