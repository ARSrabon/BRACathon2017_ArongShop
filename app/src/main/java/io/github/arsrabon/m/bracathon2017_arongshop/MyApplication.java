package io.github.arsrabon.m.bracathon2017_arongshop;

import android.app.Application;
import android.app.VoiceInteractor;
import android.content.Context;
import android.support.multidex.MultiDex;

import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.model.Route;

/**
 * Created by msrabon on 2/18/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}
