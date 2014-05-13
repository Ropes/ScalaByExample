package com.joshroppo.PubSub

import EventStream._

object HostCatcher {
    def onEvent = (topic: String, payload: Any) => Some(topic) collect {
        case "Host" => 
            println("Host found: " + payload)
    }
}
