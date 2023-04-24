package com.example.tzrikmstrs.model.camera

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Camera(
    var name: String = "",
    var snapshot: String? = null,
    var room: String? = null,
    @PrimaryKey
    var id: Int = 0,
    var favorites: Boolean = false ,
    var rec: Boolean = false


): RealmObject(){
    constructor(): this("",null,null,0,false,false)
}