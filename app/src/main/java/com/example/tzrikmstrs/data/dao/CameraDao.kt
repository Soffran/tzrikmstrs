package com.example.tzrikmstrs.data.dao

import com.example.tzrikmstrs.model.camera.Camera
import io.realm.Realm

class CameraDao(private val realm: Realm) {

    fun saveCam(camera: Camera) {
        realm.executeTransaction { realm ->
            val crCamera = realm.createObject(Camera::class.java)
            crCamera.name = camera.name
            crCamera.snapshot = camera.snapshot
            crCamera.room = camera.room
            crCamera.id = camera.id
            crCamera.favorites = camera.favorites
            crCamera.rec = camera.rec

        }
    }

    fun getAll(): List<Camera> {
        return realm.where(Camera::class.java).findAll()
    }






}