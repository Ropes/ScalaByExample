package com.joshroppo.ScalaExamples

import java.net._

import EventStream._

object LinkCheck{
    def onEvent = (topic: String, payload: String) => Some(topic) collect {
        case "URI" => 
            println("URI Sent: " + payload)
            val uri = new URI(payload)
            EventStream.publish("Host", uri.getHost())
        
    }
}