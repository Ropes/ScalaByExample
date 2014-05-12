package com.joshroppo.PubSub

import java.net._

import EventStream._

object LinkCheck{
    def onEvent = (topic: String, payload: Any) => Some(topic) collect {
        case "URI" => payload match {
                case payload: String =>
                    try{
                        println("URI Sent: " + payload)
                        val uri = new URI(payload)
                        EventStream.publish("Host", uri.getHost())
                    }catch{
                        case e: MalformedURLException => println("Invalid URL: " + e)
                        case e: Exception => println("Exception: " + e)
                    }
                case _ => 
                    println("Payload to URI must be String!")
            }
    }
}
