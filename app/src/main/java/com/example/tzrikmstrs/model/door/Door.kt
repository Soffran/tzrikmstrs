package com.example.tzrikmstrs.model.door

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Door(
    var name: String = "",
    var room: String? = null,
    @PrimaryKey
    var id: Int = 0,
    var favorites: Boolean = false,
    var snapshot: String? = null
):RealmObject(){
    constructor(): this("",null,0,false,null)
}