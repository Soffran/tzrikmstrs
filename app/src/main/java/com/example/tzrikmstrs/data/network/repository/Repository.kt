package com.example.tzrikmstrs.data.network.repository


import com.example.tzrikmstrs.data.RealmHelper
import com.example.tzrikmstrs.data.network.RetrofitBuilder
import com.example.tzrikmstrs.model.camera.CamerasData
import com.example.tzrikmstrs.model.door.DoorsData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class Repository {
    val realmHelper = RealmHelper()
    suspend fun getCameras(): Response<CamerasData>{
        return RetrofitBuilder.apiService.getCameras()
    }
    suspend fun getDoors(): Response<DoorsData>{
        return RetrofitBuilder.apiService.getDoors()
    }

    suspend fun loadCameras(){
        val camerasResponse = getCameras()
        val camerasList = camerasResponse.body()?.data?.cameras
        if (camerasResponse.isSuccessful) {
                withContext(Dispatchers.IO) {
                    if (camerasList != null) {
                        realmHelper.saveCameras(camerasList)
                    }
                }
        }
    }

    suspend fun loadDoors(){
        val doorsResponse = getDoors()
        val doorsList = doorsResponse.body()?.data
        if (doorsResponse.isSuccessful){
            doorsList?.let {
                withContext(Dispatchers.IO){
                    realmHelper.saveDoors(doorsList)
                }


            }
        }
    }
}
