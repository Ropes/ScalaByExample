package com.joshroppo.ScalaExamples

import scala._

object Iterites extends App{

    def filter_wat(wat: Array[Int]): Array[Int]= {
        return wat.filter(p => p > 5)
    }
    
    override def main(args: Array[String]){
        val wat: Array[Int] = Array(1, 4, 6, 3, 2, 10, 100)
        println(s"Length: ${wat.length}")
        println(s"Array.. ${wat.mkString("\n")}\n")
        val out = filter_wat(wat)
        println(out.mkString(" "))
    }
}
