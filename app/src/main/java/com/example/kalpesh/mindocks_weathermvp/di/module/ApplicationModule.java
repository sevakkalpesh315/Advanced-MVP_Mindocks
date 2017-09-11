package com.example.kalpesh.mindocks_weathermvp.di.module;

import android.app.Application;
import android.content.Context;

import com.example.kalpesh.mindocks_weathermvp.data.AppDataManager;
import com.example.kalpesh.mindocks_weathermvp.data.DataManager;
import com.example.kalpesh.mindocks_weathermvp.data.network.ApiHelper;
import com.example.kalpesh.mindocks_weathermvp.data.network.AppApiHelper;
import com.example.kalpesh.mindocks_weathermvp.di.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kalpesh on 26/08/2017.
 */

/**
 * AIM:
 * Used to inject the Datamanager and the domain modules- API, database and prefs, if any
 */
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }


    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

}
