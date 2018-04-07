package dev.eder.padilla.cursogdgunam;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class CursoGDGUNAM extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
