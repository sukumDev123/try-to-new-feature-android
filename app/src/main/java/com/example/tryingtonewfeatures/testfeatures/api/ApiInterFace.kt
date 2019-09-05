package com.example.tryingtonewfeatures.testfeatures.api

import com.example.tryingtonewfeatures.testfeatures.models.TestModel
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterFace {
    @GET("test_api")
    fun getTestApi() : Observable<Response<TestModel>>
}
