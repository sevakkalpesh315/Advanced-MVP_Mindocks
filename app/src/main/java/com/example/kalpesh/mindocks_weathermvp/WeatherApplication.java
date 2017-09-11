package com.example.kalpesh.mindocks_weathermvp;

import android.app.Application;
import android.content.Context;

import com.example.kalpesh.mindocks_weathermvp.di.component.ApplicationComponent;
import com.example.kalpesh.mindocks_weathermvp.di.component.DaggerApplicationComponent;
import com.example.kalpesh.mindocks_weathermvp.di.module.ApplicationModule;

/**
 * Created by kalpesh on 21/08/2017.
 */

public class WeatherApplication extends Application {


    public static Application sApplication;

    ApplicationComponent mApplicationComponent;

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;

        mApplicationComponent= DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        mApplicationComponent.inject(this);
    }
}


