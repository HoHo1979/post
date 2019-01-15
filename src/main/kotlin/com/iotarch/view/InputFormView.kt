package com.iotarch.view

import com.iotarch.ResetTextFieldRequest
import com.iotarch.controller.MyController
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class InputFormView: View(){

    val controller:MyController by inject()

    var hei=SimpleStringProperty()
    var weight=SimpleStringProperty()
    var length=SimpleStringProperty()

    override var root=form{

        fieldset {
            field("length") {textfield(length) {}}
            field("weight") {textfield(weight) {  }}
            field("height") {textfield(hei) {  }}
            button("Find the right Box"){
                action {

                  controller.findTheCorrectBox(length.value.toFloat(),weight.value.toFloat(),
                      hei.value.toFloat())

                }
            }

            subscribe<ResetTextFieldRequest>{
                length.value=""
                weight.value=""
                hei.value=""
            }

        }

    }



}