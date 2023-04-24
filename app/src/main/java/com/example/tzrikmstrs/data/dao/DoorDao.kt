package com.example.tzrikmstrs.data.dao

import com.example.tzrikmstrs.model.door.Door
import io.realm.Realm

class DoorDao(private val realm: Realm) {

    fun saveDoor(door: Door) {
        realm.executeTransaction { realm ->
            val crDoor = realm.createObject(Door::class.java)
            crDoor.name = door.name
            crDoor.room = door.room
            crDoor.id = door.id
            crDoor.favorites = door.favorites
            crDoor.snapshot = door.snapshot
        }
    }

    fun getAll(): List<Door> {
        return realm.where(Door::class.java).findAll()
    }





}