package com.iotarch

import com.iotarch.view.BottomView
import com.iotarch.view.InputFormView
import com.iotarch.view.TopView
import sun.security.util.Length
import tornadofx.*
import java.util.*

fun main(args: Array<String>) {

    launch<MyApp>(args)

}

class MyApp: App(MyView::class)

class MyView: View("This is the MainView") {

    val topView = find(TopView::class)

    val bottomView:BottomView by inject()

    val inputForm:InputFormView by inject()

    override val root = borderpane  {

        top=topView.root
        bottom = bottomView.root
        right = inputForm.root

    }

}


class Box3(boxlength:Float,boxWidth:Float,boxHeight:Float,name:String):Box(boxlength,boxWidth,boxHeight,name){


}

class Box5(boxlength:Float,boxWidth:Float,boxHeight:Float,name:String):Box(boxlength,boxWidth,boxHeight,name){


}


open class Box(val boxlength: Float,val boxWidth: Float,val boxHeight:Float,val name:String) {


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