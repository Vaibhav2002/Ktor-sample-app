package com.example.models

import java.util.*

data class Person(
    val name:String="",
    val age:Int=0,
){
    val id=UUID.randomUUID().toString()
}
