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
import kotlinx.android.synthetic.main.activity_main.*
import java.util.zip.Inflater


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
//        System.loadLibrary("customtoasts2")
        btnRandom.setOnClickListener(this)
        btnColouredToast.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        if (p0 === btnRandom) {
            // ToastCreater.simpleToast("AQSAAA", context,true )
        } else if (p0 === btnColouredToast) {
            var toast: Toast = Toast(context)
            toast.createToast(context,"Finally :)",Gravity.BOTTOM,"#000000",0)
            //toastWithBackgroundColor("AQSAAA", context, true, Color.BLACK)
        }
    }

//    fun toastWithBackgroundColor(message: String, context: Context, isLong: Boolean, color: Int) {
//        try {
//            var toast: Toast
//            if (isLong) {
//                toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
//            } else {
//                toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
//
//            }
//            toast.view.background.colorFilter = PorterDuffColorFilter(0xffff00, PorterDuff.Mode.MULTIPLY)
//            //view.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_IN)
//            toast.show()
//        } catch (exception: Exception) {
//            Log.e("Error Occured", "Invalid Color")
//        }
//
//    }

    fun Toast.createToast(context: Context,message: String,gravity: Int,
                          backgroundColor: String,imageBackgrount: Int){
        val infflater: LayoutInflater= context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = infflater.inflate(R.layout.custom_toast, (context as Activity).findViewById(R.id.root))
        layout.findViewById<TextView>(R.id.customToastText).text = message
        layout.setBackgroundColor(Color.parseColor(backgroundColor))
        setGravity(gravity,0,100)
        duration = Toast.LENGTH_LONG
        view = layout
        show()

    }
}
