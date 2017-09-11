package com.example.kalpesh.mindocks_weathermvp.ui.fivedays_weatherlist;

import com.example.kalpesh.mindocks_weathermvp.data.DataManager;
import com.example.kalpesh.mindocks_weathermvp.data.network.model.WeatherResponse;
import com.example.kalpesh.mindocks_weathermvp.ui.base.BasePresenter;
import com.example.kalpesh.mindocks_weathermvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by kalpesh on 22/08/2017.
 */

public class WeatherPresenter<V extends WeatherListMvpView>  extends BasePresenter<V>
        implements  WeatherListMvpPresenter<V> {

    @Inject
    public WeatherPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .getWeather5DaysForecast()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<WeatherResponse>() {
                               @Override
                               public void accept(WeatherResponse weatherResponse) throws Exception {
                                   if (weatherResponse != null) {
                                       getMvpView().onFetchDataSuccess(weatherResponse);
                                   }
                                   getMvpView().hideLoading();
                               }

                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                if (!isViewAttached()) {
                                    return;
                                }

                                getMvpView().hideLoading();
                            }
                        }
                ));
    }
}
