package com.example.administrator.hellokotlin.kotlin

class VariableTypeTest{


    fun test1(){

        var person:Person? = null;

        var var1: Int? = 3

        //方式 1
        if (person?.getNameLength() != null) {
            var1 = person.getNameLength();
        }
        //方式 2
        var1 = person?.getNameLength();

    }

    fun test(){

    }


}