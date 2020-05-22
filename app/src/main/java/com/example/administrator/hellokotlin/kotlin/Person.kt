package com.example.administrator.hellokotlin.kotlin

import java.lang.reflect.Constructor

class Person{
    private var name: String? = null
    fun Constructor(name:String){
        this.name = name

    }

    fun getNameLength():Int{
        return 4
    }

}