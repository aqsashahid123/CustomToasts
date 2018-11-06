package com.example.onebyte.customtoasts

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.customtoasts2.ToastCreater
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var context : Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        btnRandom.setOnClickListener(this)

    }
    override fun onClick(p0: View?) {
        if (p0===btnRandom){
            ToastCreater.simpleToast("AQSAAA", context,true )
        }
    }

}
