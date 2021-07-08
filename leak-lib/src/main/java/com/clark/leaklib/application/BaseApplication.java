package com.clark.leaklib.application;

import android.app.Application;

import com.clark.leaklib.CrashHandler;

public class BaseApplication extends Application {

    private static BaseApplication INSTANCE;

    public static BaseApplication getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        CrashHandler.getInstance().programStart(this);
    }

}
