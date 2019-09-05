package com.example.tryingtonewfeatures.testfeatures.api

import com.example.tryingtonewfeatures.testfeatures.models.TestModel
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiObject {

    companion object {
        fun create() : ApiInterFace = Retrofit.Builder()
            .baseUrl("http://192.168.43.180:8123/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterFace::class.java)
    }
}