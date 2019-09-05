package com.example.tryingtonewfeatures.testfeatures.models

import com.google.gson.annotations.SerializedName

data class TestModel(@SerializedName("name" ) val name : String , val typeOf: String , val test: String)