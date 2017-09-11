package com.example.kalpesh.mindocks_weathermvp.di.component;

import android.app.Application;
import android.content.Context;

import com.example.kalpesh.mindocks_weathermvp.WeatherApplication;
import com.example.kalpesh.mindocks_weathermvp.data.DataManager;
import com.example.kalpesh.mindocks_weathermvp.di.module.ApplicationModule;
import com.example.kalpesh.mindocks_weathermvp.di.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kalpesh on 26/08/2017.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(WeatherApplication application);


    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();

}
