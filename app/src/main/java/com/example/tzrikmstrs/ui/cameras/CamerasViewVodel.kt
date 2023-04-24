package com.example.tzrikmstrs.ui.cameras

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tzrikmstrs.data.RealmHelper
import com.example.tzrikmstrs.data.network.repository.Repository
import com.example.tzrikmstrs.model.camera.Camera
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CamerasViewVodel: ViewModel() {
    val repo = Repository()
    var camerasList: MutableLiveData<List<Camera>> = MutableLiveData()

    fun loadCamList(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.loadCameras()
        }
        viewModelScope.launch(Dispatchers.IO){
            camerasList.value = RealmHelper().getCameras()
        }
    }

}