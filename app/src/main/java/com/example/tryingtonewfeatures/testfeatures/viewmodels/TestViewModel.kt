package com.example.tryingtonewfeatures.testfeatures.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tryingtonewfeatures.testfeatures.api.ApiInterFace
import com.example.tryingtonewfeatures.testfeatures.api.ApiObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class TestViewModel : ViewModel() {
    private var liveDataUserInfo: MutableLiveData<String>? = null
    private var apiObject : ApiInterFace
    private var changeName = "Noo"

    init {
        apiObject = ApiObject.create()
    }

    fun getLiveData() :LiveData<String> {
        liveDataUserInfo = MutableLiveData()
        liveDataUserInfo?.value = changeName
        return liveDataUserInfo as MutableLiveData<String>
    }


    fun changeVal(newName:String ) {
        changeName = newName
        liveDataUserInfo?.value = changeName
    }

    fun getDataFromAPI() {
        apiObject.getTestApi().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe {
                testModel ->
                if(testModel.isSuccessful)
                    liveDataUserInfo?.value = testModel.body()?.name
                else
                    Log.e("ERROR" , "ERROR MESSAGE SERVER CAN FINDER.")
            }


    }

}