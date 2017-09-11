package com.example.kalpesh.mindocks_weathermvp.ui.fivedays_weatherlist;

import com.example.kalpesh.mindocks_weathermvp.data.network.model.WeatherResponse;
import com.example.kalpesh.mindocks_weathermvp.ui.base.MvpView;

/**
 * Created by kalpesh on 22/08/2017.
 */

public interface WeatherListMvpView extends MvpView{

    void onFetchDataSuccess(WeatherResponse weatherResponse);

}
