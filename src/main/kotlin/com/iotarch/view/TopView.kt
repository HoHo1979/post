package com.iotarch.view

import com.iotarch.ResetTextFieldRequest
import com.iotarch.controller.MyController
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.stage.StageStyle
import jdk.internal.util.xml.impl.Input
import tornadofx.*

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

                menu("All Boxes"){

                    controller.findAllBoxes().forEach {

                        item(it.name).action {

                            controller.boxInfo(it.boxWidth,it.boxHeight,it.boxlength)

                        }

                    }


                }

            }


        }
    }

}

class MyFragment: Fragment() {
    override val root = form{

        title="New Box"

        fieldset {

            field("weight") {


            }


        }

    }
}