package com.iotarch.controller

//import com.iotarch.Box
import com.iotarch.model.Box
import com.iotarch.UpdateBoxResultListener
import com.iotarch.model.BoxData
import javafx.collections.transformation.SortedList
import tornadofx.Controller


class MyController:Controller(){


    lateinit var listener:UpdateBoxResultListener

    fun updateResultListener(updateBoxResultListener: UpdateBoxResultListener){
        listener=updateBoxResultListener
    }

    fun findTheCorrectBox(length:Float,width:Float,height:Float){

        //Sort the list by the total(length+width+height),use the smallest box to verify the search of the right box
        //This will cause the excpetion when add another new BOX in fragment.
        //BoxData.instance.boxesList=BoxData.instance.boxesList.sorted { o1, o2 -> if(o1.total-o2.total>0) 1 else -1 }

      val sortedList=BoxData.instance.boxesList.sorted(compareBy(Box::total))

        var findBox=false

        for(box in sortedList){
            if(box.length>length && box.width>width && box.height>height){
                listener.updateResult(box.name)
                findBox=true
                break
            }
        }

        if(findBox==false)
            listener.updateResult("We don't have right box")

    }

    fun findAllBoxes():MutableList<Box>{

        return BoxData.instance.boxesList
    }

    fun saveBox(box:Box) {
        BoxData.instance.newBox(box)
    }




}