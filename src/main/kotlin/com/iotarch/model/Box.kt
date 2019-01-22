package com.iotarch.model

import javafx.beans.property.SimpleFloatProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
// Correct the order of box input, length, width and height.
open class Box(name:String,length: Float,width:Float,height:Float){

    var nameProperty = SimpleStringProperty(this,"name",name)
    var name by nameProperty

    var widthProperty = SimpleFloatProperty(this,"boxWidth",width)
    var width by widthProperty

    var lengthProperty = SimpleFloatProperty(this,"boxLength",length)
    var length by lengthProperty

    var heightProperty = SimpleFloatProperty(this,"boxHeight",height)
    var height by heightProperty

    var totalProperty = SimpleFloatProperty(this,"boxTotal",(width+length+height))
    var total by totalProperty

}


//class Box3(name: String,width: Float,length: Float,height: Float):Box(name,width,length,height){
//
//
//}
//
//
//class Box5(name: String,width: Float,length: Float,height: Float):Box(name,width,length,height){
//
//
//}
