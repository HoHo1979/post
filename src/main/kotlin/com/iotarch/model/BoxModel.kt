package com.iotarch.model

import tornadofx.ViewModel
import com.iotarch.model.Box


class BoxModel(var box: Box) : ViewModel(){

    var name = bind{box.nameProperty}
    var length = bind{ box.lengthProperty }
    var width = bind{ box.widthProperty}
    var height = bind{box.heightProperty}
    var total = bind{box.totalProperty}

}