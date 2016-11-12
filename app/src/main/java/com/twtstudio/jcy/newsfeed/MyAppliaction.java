package com.twtstudio.jcy.newsfeed;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by jcy on 16-11-12.
 *
 * @TwtStudio Mobile Develop Team
 */

public class MyAppliaction extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
