package com.example.tzrikmstrs.data.network

import com.example.tzrikmstrs.model.camera.CamerasData
import com.example.tzrikmstrs.model.door.DoorsData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("cameras/")
    suspend fun getCameras(): Response<CamerasData>

    @GET("doors/")
    suspend fun getDoors(): Response<DoorsData>
}