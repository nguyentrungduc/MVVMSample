package com.example.sony.mvvmsample;

import com.example.sony.mvvmsample.data.source.local.realm.DataLocalMigration;
import com.example.sony.mvvmsample.data.source.remote.MovieServiceClient;
import com.example.sony.mvvmsample.util.NetWorkManager;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Sony on 12/22/2017.
 */

public class Application extends android.app.Application {
    private static final String REALM_SCHEMA_NAME = "android_structure.realm";
    private static final int REALM_SCHEMA_VERSION = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        NetWorkManager.init(this);
        MovieServiceClient.initialize(this);
        initAndMigrateRealmIfNeeded();
    }

    private void initAndMigrateRealmIfNeeded() {
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name(REALM_SCHEMA_NAME)
                .schemaVersion(REALM_SCHEMA_VERSION)
                .migration(new DataLocalMigration())
                .build();
        Realm.setDefaultConfiguration(config);
        Realm realm = Realm.getDefaultInstance(); // Automatically run migration if needed
        realm.close();
    }
}
