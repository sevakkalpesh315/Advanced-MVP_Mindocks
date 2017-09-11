package com.example.kalpesh.mindocks_weathermvp;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.util.Log;

import com.example.kalpesh.mindocks_weathermvp.data.network.model.WeatherResponse;
import com.example.kalpesh.mindocks_weathermvp.ui.base.BaseActivity;
import com.example.kalpesh.mindocks_weathermvp.ui.fivedays_weatherlist.WeatherListMvpView;
import com.example.kalpesh.mindocks_weathermvp.ui.fivedays_weatherlist.WeatherPresenter;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements WeatherListMvpView{
     @Inject
    WeatherPresenter<WeatherListMvpView> weatherListMvpViewWeatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);

       // weatherListMvpViewWeatherPresenter= new WeatherPresenter<>(new AppDataManager(),new AppSchedulerProvider(), new CompositeDisposable());

        weatherListMvpViewWeatherPresenter.onAttach(this);
        weatherListMvpViewWeatherPresenter.onViewPrepared();
    }

    @Override
    public void onFetchDataSuccess(WeatherResponse weatherResponse) {
        Log.i("WeatherResponse", weatherResponse.getList().get(1).getWind().toString());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onError(@StringRes int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(@StringRes int resId) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }

}
