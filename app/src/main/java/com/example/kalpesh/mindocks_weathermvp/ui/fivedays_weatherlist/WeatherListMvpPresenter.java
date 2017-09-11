package com.example.kalpesh.mindocks_weathermvp.ui.fivedays_weatherlist;

import com.example.kalpesh.mindocks_weathermvp.ui.base.MvpPresenter;

/**
 * Created by kalpesh on 22/08/2017.
 */


public interface WeatherListMvpPresenter<V extends WeatherListMvpView>
        extends MvpPresenter<V>  {

    void onViewPrepared();

}
