package com.iotarch.view

import com.iotarch.ResetTextFieldRequest
import com.iotarch.controller.MyController
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class InputFormView: View(){

    val controller:MyController by inject()

    var hei=SimpleStringProperty()
    var wid=SimpleStringProperty()
    var length=SimpleStringProperty()

    override var root=form{

        fieldset {
            field("length") {textfield(length) {}}
            field("width") {textfield(wid) {  }}
            field("height") {textfield(hei) {  }}
            button("Find the right Box"){
                action {

                  controller.findTheCorrectBox(length.value.toFloat(),wid.value.toFloat(),
                      hei.value.toFloat())

                }
            }

            subscribe<ResetTextFieldRequest>{
                length.value=""
                wid.value=""
                hei.value=""
            }

        }

    }



}