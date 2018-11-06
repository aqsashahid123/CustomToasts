package com.example.customtoasts2

import android.content.Context
import android.widget.Toast

class ToastCreater {
    companion object {
        fun simpleToast(message: String, context: Context, isLong: Boolean) {
            if (isLong) {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}