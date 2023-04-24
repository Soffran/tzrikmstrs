package com.example.tzrikmstrs.ui.doors

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tzrikmstrs.data.RealmHelper
import com.example.tzrikmstrs.data.network.repository.Repository
import com.example.tzrikmstrs.model.door.Door
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DoorsViewModel:ViewModel() {
    private val repo = Repository()
    var doorsList: MutableLiveData<List<Door>> = MutableLiveData()

    fun getDoorsList(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.loadDoors()

        }
        viewModelScope.launch(Dispatchers.IO){
            doorsList.value = RealmHelper().getDoors()
        }
    }
}