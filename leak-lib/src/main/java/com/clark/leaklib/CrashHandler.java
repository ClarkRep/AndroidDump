package com.clark.leaklib;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static CrashHandler INSTANCE;
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private CrashCallback mCrashCallback;

    private CrashHandler() {

    }

    public static CrashHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CrashHandler();
        }
        return INSTANCE;
    }

    public void programStart(Context ctx) {
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void setCrashCallback(CrashCallback crashCallback) {
        this.mCrashCallback = crashCallback;
    }

    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        Log.e("AndroidDump", e.getLocalizedMessage());
        if (mCrashCallback != null) {
            mCrashCallback.uncaughtException(t, e);
        }
        if (mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(t, e);
        }
    }

    public interface CrashCallback {
        void uncaughtException(@NonNull Thread t, @NonNull Throwable e);
    }
}
