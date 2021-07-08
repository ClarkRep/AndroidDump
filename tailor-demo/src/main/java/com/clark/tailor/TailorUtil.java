package com.clark.tailor;

import android.os.Build;
import android.util.Log;

import com.bytedance.tailor.Tailor;
import com.clark.leaklib.application.BaseApplication;

public class TailorUtil {

    public static void tailorForHook() {
        String path = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            path = BaseApplication.getInstance().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath();
            path = BaseApplication.getInstance().getFilesDir().getAbsolutePath();
        }
        String target = path + "/TailorMini.hprof";
        Log.d("AndroidDump", "TailorUtil.tailorForHook(),path=" + path);
        try {
            Log.d("AndroidDump", "TailorUtil.tailorForHook() -> start");
            Tailor.dumpHprofData(target, true);
            Log.d("AndroidDump", "TailorUtil.tailorForHook() -> success");
        } catch (Exception e) {
            Log.d("AndroidDump", "TailorUtil.tailorForHook() -> error:" + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
