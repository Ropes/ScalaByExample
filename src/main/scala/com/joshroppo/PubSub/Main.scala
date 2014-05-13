package com.joshroppo.PubSub

import java.io.{PrintStream, File, FileOutputStream}

object Main{
    val ps = new PrintStream( new FileOutputStream( new File("outpub.txt")))

    def main(args: Array[String]){
        EventStream.subscribe(LinkCheck.onEvent, "LinkChecker")
        EventStream.subscribe(Logger.onEvent, "loggerstream")
    }

    def run {
        EventStream.publish("URI", "https://www.google.com/watman")
        EventStream.publish("URI", "https://www.amazon.com/orders")
        stop
    }
    def stop = Logger.stop()

}
