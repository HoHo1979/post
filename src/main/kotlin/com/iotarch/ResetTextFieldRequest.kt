package com.iotarch

import tornadofx.EventBus
import tornadofx.FXEvent

//EventBus use to rest input fields when the button is clicked
object ResetTextFieldRequest:FXEvent(EventBus.RunOn.BackgroundThread)