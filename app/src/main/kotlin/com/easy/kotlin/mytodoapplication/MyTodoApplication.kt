package com.easy.kotlin.mytodoapplication

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by banbury on 2018/7/3.
 */

class MyTodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val config = RealmConfiguration.Builder(this)
                .name("realm.my_todos")//库文件名
                .encryptionKey(getkey())//加密
                .schemaVersion(1)//版本
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(config)
    }

    private fun getkey(): ByteArray? {
        return byteArrayOf(0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1)
    }
}