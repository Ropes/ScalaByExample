package com.joshroppo.ScalaExamples

object Palindromes{

    def dumb(str: String): Boolean = str == str.reverse

    def recursive(str: String): Boolean = {
        if(str.length <= 1){
            return true
        }else{
            return str.head == str.last && recursive(str.slice(1, str.length-1))
        }
    }

    //def cmpMirrorIndexes(str: String, i: Int): Boolean = {


    def enclosingIter(str: String): Boolean = {
        val len = str.length - 1
        val mid: Int = len/2 
        
        println(str)
        for( i <- 0 to len){
            val j = len - i
            println(s"i: $i, j: $j, mid: $mid")
            if(i == mid && j == mid){
                return true
            }else if(str.charAt(i) != str.charAt(j)){
                return false
            }
        }
        true
    }
}
