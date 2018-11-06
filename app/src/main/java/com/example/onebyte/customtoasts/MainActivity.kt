package com.example.onebyte.customtoasts

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.customtoasts2.ToastCreater
import kotlinx.android.synthetic.main.activity_main.*
import java.util.zip.Inflater


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        btnRandom.setOnClickListener(this)
        btnColouredToast.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        if (p0 === btnRandom) {
            ToastCreater.simpleToast("Message",context,true)
        } else if (p0 === btnColouredToast) {
           ToastCreater.createToastWithCustomLayout(context,"Maine Kar dikhaya :)",
                   Gravity.BOTTOM,"#000000",0,R.layout.custom_toast,R.id.root,R.id.customToastText)
        }
    }

}
