package com.joshroppo.PubSub

import java.io.{PrintStream, File, FileOutputStream}

object Main extends App{
    val ps = new PrintStream( new FileOutputStream( new File("outpub.txt")))

    def stop = {
        EventStream.system.shutdown()
        //Logger.stop(ps)
    }

    def run { 
        EventStream.publish("URI", "https://www.google.com/watman")
        EventStream.publish("URI", "https://www.amazon.com/orders")
        EventStream.publish("URI", "www.watman/flazl")
        stop
    }

    override def main(args: Array[String]){
        EventStream.subscribe(LinkCheck.onEvent, "LinkChecker")
        //EventStream.subscribe(Logger.onEvent(ps), "loggerstream")
        EventStream.subscribe(HostCatcher.onEvent, "HostCatcher")
        run
    }

}
