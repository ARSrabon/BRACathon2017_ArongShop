package io.github.arsrabon.m.bracathon2017_arongshop;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by msrabon on 2/18/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
