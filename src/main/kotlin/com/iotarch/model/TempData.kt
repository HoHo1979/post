package com.iotarch.model

import com.iotarch.Box
import tornadofx.observable

class TempData{

    companion object {
        val instance = TempData()
    }


    val box3 = Box(23f, 14f, 13f,"box3")
    val box5 = Box(39.5f, 27.5f, 23f,"box5")

    var boxesList = mutableListOf<Box>(box3,box5).observable()

    fun newBox(box:Box){
        boxesList.add(box)
    }

}