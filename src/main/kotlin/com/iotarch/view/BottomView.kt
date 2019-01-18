package com.iotarch.view

import com.iotarch.ResetTextFieldRequest
import com.iotarch.UpdateBoxResultListener
import com.iotarch.controller.MyController
import javafx.scene.Parent
import javafx.scene.control.Label
import tornadofx.*

class BottomView: View(),UpdateBoxResultListener{

    val controller:MyController by inject()

    var rLabel:Label by singleAssign()

    init {
        controller.updateResultListener(this)
    }

    override fun updateResult(name: String) {

        rLabel.text="\t use: $name"

    }

    override val root=hbox{

        rLabel = Label()

        this.add(rLabel)


    }

}