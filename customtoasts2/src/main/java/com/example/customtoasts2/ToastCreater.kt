package com.example.customtoasts2

import android.content.Context
import android.widget.Toast
import android.widget.TextView
import android.graphics.PorterDuff
import android.R.attr.duration
import android.graphics.Color
import android.util.Log


class ToastCreater {
    companion object {
        fun simpleToast(message: String, context: Context, isLong: Boolean) {
            if (isLong) {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        }

        fun toastWithBackgroundColor(message: String, context: Context, isLong: Boolean, color: Int) {
            try {
                var toast: Toast
                if (isLong) {
                    toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
                }else{
                    toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)

                }
                val view = toast.getView()
                view.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_IN)
                toast.show()
            }catch (exception: Exception){
                Log.e("Error Occured", "Invalid Color")
            }

        }
    }
}