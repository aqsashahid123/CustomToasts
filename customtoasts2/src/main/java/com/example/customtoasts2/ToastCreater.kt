package com.example.customtoasts2

import android.content.Context
import android.widget.Toast
import android.widget.TextView
import android.app.Activity
import android.graphics.Color
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

        fun createToastWithCustomLayout(context: Context, message: String, gravity: Int,
                                        backgroundColor: String,
                                        layout: Int, idOfRootInLayout: Int, idOfTextView: Int, isLong: Boolean) {
            var toast: Toast = Toast(context)
            toast.createToast(context, message, gravity,
                    backgroundColor, layout, idOfRootInLayout, idOfTextView, isLong)
        }

        private fun Toast.createToast(context: Context, message: String, gravity: Int,
                                      backgroundColor: String, layout: Int,
                                      idOfRootInLayout: Int, idOfTextView: Int, isLong: Boolean) {
            val infflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val layout = infflater.inflate(layout, (context as Activity).findViewById(idOfRootInLayout))
            layout.findViewById<TextView>(idOfTextView).text = message
            layout.setBackgroundColor(Color.parseColor(backgroundColor))
            setGravity(gravity, 0, 100)
            if (isLong) {
                duration = Toast.LENGTH_LONG
            }else{
                duration = Toast.LENGTH_SHORT
            }
                view = layout
            show()

        }


        private fun Toast.createColouredToasts(context: Context, message: String, gravity: Int,
                                      backgroundColor: String,textColor:String,  isLong: Boolean) {
            val infflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val layout = infflater.inflate(R.layout.custom_toast_background, (context as Activity).findViewById(R.id.customToastRoot))
          var tv:TextView
                  tv= layout.findViewById<TextView>(R.id.textForToast)
            tv.text = message
            tv.setTextColor(textColor.toColor())
            tv.setBackgroundColor(Color.parseColor(backgroundColor))
            //layout.findViewById<TextView>(R.id.textForToast).setTextColor(textColor.toColor())
            //layout.setBackgroundColor(Color.parseColor(backgroundColor))
            setGravity(gravity, 0, 100)
            if (isLong) {
                duration = Toast.LENGTH_LONG
            }else{
                duration = Toast.LENGTH_SHORT
            }
            view = layout
            show()

        }
        fun String.toColor(): Int = Color.parseColor(this)


    }

}