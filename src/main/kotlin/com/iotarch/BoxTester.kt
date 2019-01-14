package com.iotarch

import sun.security.util.Length
import java.util.*

fun main(args: Array<String>) {

    val box3 = Box(23f, 14f, 13f)
    val box5 = Box(39.5f, 27.5f, 23f)


    println("Post Box Checking System, type -1 to exit")
    println("=============================================")

    val exitCode=0

    while(exitCode!=-1) {

        println("New Item")


        val scanner = Scanner(System.`in`)

        println("Please enter object's length")
        val length: Float = scanner.nextInt().toFloat()
        if (length==-1f) break
        println("Please enter object's width")
        val width: Float = scanner.nextInt().toFloat()
        if (width==-1f) break
        println("Please enter object's height")
        val height: Float = scanner.nextInt().toFloat()
        if (height==-1f) break

        if(box3.validate(length,width,height)){
            println("box3")
        }else if(box5.validate(length,width,height)){
            println("box5")
        }else{
            println("You Item is too big to fit into our box")
        }
        println("---------------------------------")
    }

}



data class Box(val boxlength: Float,val boxWidth: Float,val boxHeight:Float) {


    fun validate(length:Float,width:Float,height:Float): Boolean{

        if(boxlength<length) {
            return false
        }else if(boxWidth<width) {
            return false
        }else if(boxHeight<height){
            return false
        }

        return true
    }

}