package com.iotarch.controller

import com.iotarch.UpdateBoxResultListener
import org.junit.Test
import tornadofx.*
import com.iotarch.controller.MyController;
import com.iotarch.model.Box
import org.junit.jupiter.api.Assertions

class MyControllerTesting{

    val controller= find(MyController::class)

    //Find the Box5
    @Test
    fun box5Testing(){

        var listener= object : UpdateBoxResultListener {
            override fun updateResult(name: String) {
                Assertions.assertEquals("box5",name)
            }
        }
        controller.updateResultListener(listener)
        controller.findTheCorrectBox(22f,22f,22f)

    }

    //Find the Box3
    @Test
    fun box3Testing(){

        var listener= object : UpdateBoxResultListener {
            override fun updateResult(name: String) {
                Assertions.assertEquals("box3",name)
            }
        }
        controller.updateResultListener(listener)
        controller.findTheCorrectBox(22f,13f,12f)

    }


    @Test
    fun NoBoxTesting(){

        var listener= object : UpdateBoxResultListener {
            override fun updateResult(name: String) {
                Assertions.assertEquals("We don't have right box",name)
            }
        }
        controller.updateResultListener(listener)
        controller.findTheCorrectBox(33f,34f,36f)

    }

    @Test
    fun saveBoxAndFindAllBoxesTesting(){

        var box7 = Box("box7",44f,45f,43f)
        controller.saveBox(box7)

        var box=controller.findAllBoxes().find {
            it.name.equals("box7")
        }

        Assertions.assertEquals(box?.total,44f+45f+43f)

    }

}