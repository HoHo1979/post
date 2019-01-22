package com.iotarch.model


import tornadofx.observable

class BoxData{

    companion object {
        val instance = BoxData()
    }


    val box3 = Box("box3",23f, 14f, 13f)
    val box5 = Box("box5",39.5f, 27.5f, 23f)

    var boxesList = mutableListOf<Box>(box3,box5).observable()


    fun newBox(box:Box){

            boxesList.add(box)

    }

}