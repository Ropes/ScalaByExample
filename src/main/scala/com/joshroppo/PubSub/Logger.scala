package com.joshroppo.PubSub

import java.io._

object Logger{
    def onEvent(ps: PrintStream) = (topic: String, payload: Any) => Option[Unit] {
        try{
            println("Logger received = topic: " + topic + ", payload: " + payload)
            ps.println("[" + topic + "] [" + payload + "]")
        }catch{
            case ioe: IOException => println("IOException: " + ioe.toString)
            case e: Exception => println("Exception: " + e.toString)
        }
    }

    def stop(ps: PrintStream) = ps.close()
}
