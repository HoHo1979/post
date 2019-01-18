package com.iotarch.model

//import com.iotarch.Box
import com.iotarch.model.Box
import tornadofx.launch
import tornadofx.observable
import kotlin.system.measureNanoTime

class TempData{

    companion object {
        val instance = TempData()
    }


    val box3 = Box("box3",23f, 14f, 13f)
    val box5 = Box("box5",39.5f, 27.5f, 23f)

    var boxesList = mutableListOf<Box>(box3,box5).observable()

    fun newBox(box:Box){

        var time=measureNanoTime {

            boxesList.add(box)

        }



        println(time)

    }

}