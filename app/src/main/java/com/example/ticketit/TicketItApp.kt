package com.example.ticketit

import android.app.Application
import android.content.Context

/**
 * Clasa generala ce gestioneaza modulele principale ale aplicatiei.
 */
class TicketItApp : Application() {
    private val realmSchemaVersion = 3L

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Realm.init(this)
//        Timber.plant(Timber.DebugTree())
//        val config = RealmConfiguration.Builder()
//            .deleteRealmIfMigrationNeeded()
//            .directory(getExternalFilesDir(null))
//            .schemaVersion(realmSchemaVersion)
//            .migration(Migration())
//            .build()
//        Realm.setDefaultConfiguration(config)
//        installCrashLogger(this)
    }

    companion object {
        private lateinit var instance: TicketItApp
        fun getAppContext(): Context {
            return instance.applicationContext
        }
    }

}