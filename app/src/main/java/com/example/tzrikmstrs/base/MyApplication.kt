package com.example.tzrikmstrs.base

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("apprealm.realm")
            .schemaVersion(3)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
    }
}