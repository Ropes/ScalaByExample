package com.joshroppo.PubSub

import java.net._

import EventStream._

object LinkCheck{
    def onEvent = (topic: String, payload: String) => Some(topic) collect {
        case "URI" => 
            try{
                println("URI Sent: " + payload)
                val uri = new URI(payload)
                EventStream.publish("Host", uri.getHost())
            }catch{
                case e: MalformedURLException => println("Invalid URL: " + e)
                case e: Exception => println("Exception: " + e)
            }
    }
}
