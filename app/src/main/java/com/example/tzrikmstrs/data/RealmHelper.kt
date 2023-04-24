package com.example.tzrikmstrs.data

import com.example.tzrikmstrs.data.dao.CameraDao
import com.example.tzrikmstrs.data.dao.DoorDao
import com.example.tzrikmstrs.model.camera.Camera
import com.example.tzrikmstrs.model.door.Door
import io.realm.Realm

class RealmHelper {
    private val realm:Realm by lazy{
        Realm.getDefaultInstance()
    }
    private val cameraDao= CameraDao(realm)
    private val doorDao= DoorDao(realm)
    fun saveCameras(cameras: List<Camera>) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransactionAsync {
            for (camera in cameras) {
                cameraDao.saveCam(camera)
            }
        }
        realm.commitTransaction()
    }

    fun saveDoors(doors: List<Door>) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransactionAsync {
            for (door in doors) {
                doorDao.saveDoor(door)
            }
        }
        realm.commitTransaction()
    }

    fun getCameras():List<Camera> {
        return cameraDao.getAll()
    }

    fun getDoors():List<Door> {
        return doorDao.getAll()
    }
}