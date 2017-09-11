package com.example.kalpesh.mindocks_weathermvp.data;

import android.content.Context;

import com.example.kalpesh.mindocks_weathermvp.data.network.ApiHelper;
import com.example.kalpesh.mindocks_weathermvp.data.network.model.WeatherResponse;
import com.example.kalpesh.mindocks_weathermvp.di.scope.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by kalpesh on 21/08/2017.
 */
@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG= "AppDataManager";
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          ApiHelper apiHelper) {
      //  this.mApiHelper = new AppApiHelper();
        this.mApiHelper= apiHelper;
    }

    @Override
    public Observable<WeatherResponse> getWeather5DaysForecast() {
        return mApiHelper.getWeather5DaysForecast();
    }
}
