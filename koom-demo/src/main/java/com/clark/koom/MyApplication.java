package com.clark.koom;

import com.clark.leaklib.application.BaseApplication;
import com.kwai.koom.javaoom.KOOM;

public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        KOOM.init(this);
    }

}
