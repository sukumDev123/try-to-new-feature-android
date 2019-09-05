package com.example.tryingtonewfeatures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.tryingtonewfeatures.testfeatures.api.ApiObject
import com.example.tryingtonewfeatures.testfeatures.viewmodels.TestViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel  : TestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this)
            .get(TestViewModel::class.java)

        nameTest1.text  =  "LODER..."
        viewModel.getLiveData().observe(this , Observer {
            nameTest1.text = it
        })

       initBtn()


    }

    fun initBtn() {
        btn1.setOnClickListener {

            viewModel.changeVal(nameTest.text.toString())
        }

        btn2.setOnClickListener {
            viewModel.getDataFromAPI()
        }
    }

}
