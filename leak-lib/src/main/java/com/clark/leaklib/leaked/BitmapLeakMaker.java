package com.clark.leaklib.leaked;

import android.content.Context;
import android.graphics.Bitmap;

import com.clark.leaklib.Constants;
import com.clark.leaklib.LeakMaker;

/**
 * Copyright 2020 Kwai, Inc. All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author Rui Li <lirui05@kuaishou.com>
 */
public class BitmapLeakMaker extends LeakMaker<Bitmap> {

    @Override
    public void startLeak(Context context) {
        Bitmap bitmap = Bitmap.createBitmap(Constants.BitmapThreshold.DEFAULT_BIG_WIDTH + 1,
                Constants.BitmapThreshold.DEFAULT_BIG_HEIGHT + 1, Bitmap.Config.ARGB_8888);
        uselessObjectList.add(bitmap);
    }
}
