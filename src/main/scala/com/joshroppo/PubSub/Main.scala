package com.joshroppo.PubSub

import java.io.{PrintStream, File, FileOutputStream}

object Main{
    val ps = new PrintStream( new FileOutputStream( new File("outpub.txt")))

    def main(args: Array[String]){
        EventStream.subscribe(LinkCheck.onEvent, "LinkChecker")

    }

}
