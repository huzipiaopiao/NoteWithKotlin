package com.easy.kotlin.mytodoapplication

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Created by banbury on 2018/7/3.
 */

@RealmClass
open class Todo:RealmObject(){
    @PrimaryKey
    open var id:String ="-1"
    open var title:String = "日程"
    open var content:String = "事项"
}