package com.siervi.claudio.easysale;

import android.app.Application;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Claudio on 12/04/2016.
 */

// global methods
public class EasySale extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getApplicationContext()).build();
        Realm.deleteRealm(realmConfig);
        Realm.setDefaultConfiguration(realmConfig);
    }
}
