package com.iotarch.view

import com.iotarch.ResetTextFieldRequest
import com.iotarch.controller.MyController
import com.iotarch.model.Box
import com.iotarch.model.BoxModel
import com.iotarch.model.TempData
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.layout.BorderPane
import javafx.stage.StageStyle
import jdk.internal.util.xml.impl.Input
import tornadofx.*
import kotlin.reflect.full.valueParameters
import kotlin.reflect.jvm.javaGetter

class TopView: View(){

    val controller: MyController by inject()

    override val root= vbox {


        menubar {

            menu("Package"){

                menu("Cacualtion"){

                    item("New Item").action {


                       fire(ResetTextFieldRequest)

                    }

                }

            }

            menu("Setting"){

                menu("New Box"){

                    item("Box Size").action {
                       find<MyFragment>().openModal(stageStyle = StageStyle.UTILITY)
                    }


                }

            }


        }
    }

}

class MyFragment: Fragment() {
    override val root = BorderPane()

    val controller: MyController by inject()

    var boxes = TempData.instance.boxesList
    val model = BoxModel(Box("",13f,13f,13f))

    init {
        with(root){

            center{

                tableview(boxes) {

                    column("Box Name",Box::name)
                    column("Width",Box::width)
                    column("Length",Box::length)
                    column("Height",Box::height)
                    column("Total",Box::total)

                    model.rebindOnChange(this){

                        selectedBox-> box= selectedBox?:Box("",0f,0f,0f)

                    }

                }

            }

            right{
                form{

                    fieldset("Edit Box") {
                        field("Name") {
                            textfield(model.name)
                        }
                        field("width") {
                            textfield(model.width)
                        }
                        field("length") {
                            textfield(model.length)
                        }
                        field("height") {
                            textfield(model.height)
                        }
                        button("Add") {
                            enableWhen(model.dirty)
                            action {
                                var newBox = Box(model.name.value,model.width.value.toFloat(),model.length.value.toFloat(),model.height.value.toFloat())
                                controller.saveBox(newBox)
                            }
                        }
//                        button("Reset").action {
//                            model.rollback()
//                        }
                    }



                }
            }



        }
    }


}