package com.example.administrator.hellokotlin

import android.content.Context
import android.widget.Toast

class FunTest{

    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun minus(x: Int, y: Int): Int = x - y

    fun Context.toast(message:CharSequence,duration:Int= Toast.LENGTH_SHORT) {
        Toast.makeText(this,message,duration).show()
    }
}

