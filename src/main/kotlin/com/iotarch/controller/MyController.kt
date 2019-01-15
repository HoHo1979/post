package com.iotarch.controller

import com.iotarch.Box
import com.iotarch.UpdateBoxResultListener
import com.iotarch.model.TempData
import sun.security.util.Length
import tornadofx.Controller


class MyController:Controller(){


    lateinit var listener:UpdateBoxResultListener

    fun updateResultListener(updateBoxResultListener: UpdateBoxResultListener){
        listener=updateBoxResultListener
    }

    fun findTheCorrectBox(length:Float,width:Float,height:Float){

        for(box in TempData.instance.boxesList){
            if(box.boxlength>length && box.boxWidth>width && box.boxHeight>height){
                listener.updateResult(box.name)
                break
            }
        }
    }

    fun findAllBoxes():MutableList<Box>{

        return TempData.instance.boxesList
    }

    fun boxInfo(boxWidth: Float, boxHeight: Float, boxlength: Float) {

        //updateInputFormView's TextField

    }

    fun resetAllTextField() {



    }


}