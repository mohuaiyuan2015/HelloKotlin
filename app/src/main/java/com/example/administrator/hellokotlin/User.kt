package com.example.administrator.hellokotlin

class User{

    private var pin: String? = null
    private var name: String? = null

    constructor(pin: String) {
        this.pin = pin
    }

    constructor(pin: String, name: String) {
        this.pin = pin
        this.name = name
    }




}