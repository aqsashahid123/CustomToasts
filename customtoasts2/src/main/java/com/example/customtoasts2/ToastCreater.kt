package com.example.customtoasts2

import android.content.Context
import android.widget.Toast
import android.widget.TextView
import android.graphics.PorterDuff
import android.R.attr.duration
import android.app.Activity
import android.graphics.Color
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater


class ToastCreater {
    companion object {
        fun simpleToast(message: String, context: Context, isLong: Boolean) {
            if (isLong) {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        }

//        fun toastWithBackgroundColor(message: String, context: Context, isLong: Boolean, color: Int) {
//            try {
//                var toast: Toast
//                if (isLong) {
//
//                    toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
//                }else{
//                    toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
//
//                }
//                val view = toast.getView()
//                view.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_IN)
//                toast.show()
//            }catch (exception: Exception){
//                Log.e("Error Occured", "Invalid Color")
//            }
//
//        }

        fun createToastWithCustomLayout(context: Context,message: String,gravity: Int,
                                        backgroundColor: String,imageBackgrount: Int,
                                        layout: Int, idOfRootInLayout: Int, idOfTextView: Int){
            var toast: Toast = Toast(context)
            toast.createToast(context,message,gravity,
                    backgroundColor, layout, idOfRootInLayout, idOfTextView)
        }
       private fun Toast.createToast(context: Context,message: String,gravity: Int,
                              backgroundColor: String, layout: Int, idOfRootInLayout: Int, idOfTextView: Int){
            val infflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val layout = infflater.inflate(layout, (context as Activity).findViewById(idOfRootInLayout))
            layout.findViewById<TextView>(idOfTextView).text = message
            layout.setBackgroundColor(Color.parseColor(backgroundColor))
            setGravity(gravity,0,100)
            duration = Toast.LENGTH_LONG
            view = layout
            show()

        }



    }

}