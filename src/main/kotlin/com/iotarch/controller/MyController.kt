package com.iotarch.controller

//import com.iotarch.Box
import com.iotarch.model.Box
import com.iotarch.UpdateBoxResultListener
import com.iotarch.model.TempData
import sun.security.util.Length
import tornadofx.Controller
import java.util.*


class MyController:Controller(){


    lateinit var listener:UpdateBoxResultListener

    fun updateResultListener(updateBoxResultListener: UpdateBoxResultListener){
        listener=updateBoxResultListener
    }

    fun findTheCorrectBox(length:Float,width:Float,height:Float){

        //Sort the list by the total(length+width+height),use the smallest box to verify the search of the right box
        TempData.instance.boxesList=TempData.instance.boxesList.sorted { o1, o2 -> if(o1.total-o2.total>0) 1 else -1 }

        for(box in TempData.instance.boxesList){
            if(box.length>length && box.width>width && box.height>height){
                listener.updateResult(box.name)
                break
            }
        }
    }

    fun findAllBoxes():MutableList<Box>{

        return TempData.instance.boxesList
    }

    fun saveBox(box: Box) {

        TempData.instance.boxesList.add(box)
    }


}