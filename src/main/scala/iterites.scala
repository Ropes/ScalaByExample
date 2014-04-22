package com.joshroppo.ScalaExamples

import scala._

object Iterites extends App{

    def filter_predicate(wat: Array[Int]): Array[Int]= {
        return wat.filter(p => p > 5)
    }

    def quicksort(arr: Array[Int]): Array[Int] = {
        if(arr.length <= 1) arr
        else{
            val pivot = arr(arr.length /2)     
            Array.concat(
                quicksort(arr filter (p => p < pivot)), 
                arr filter (p => pivot == p),
                quicksort(arr filter (p => p > pivot)) )
        }
    }
    
    override def main(args: Array[String]){
        val wat: Array[Int] = Array(1, 4, 6, 3, 2, 10, 100)
        val hat = Array(5, 4, 1, 8, 90, 12)
        println(s"Length: ${wat.length}")
        println(s"Array.. ${wat.mkString("\n")}\n")
        val out = quicksort(hat)
        println(out.mkString(" "))
    }

}
