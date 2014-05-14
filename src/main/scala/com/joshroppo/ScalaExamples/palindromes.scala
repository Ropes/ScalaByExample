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

    def cmpChars(str: String, i: Int, j: Int): Boolean = str.charAt(i) == str.charAt(j)

    def assertMirrorChars(str: String, i: Int): Boolean = {
        println(str)
        if(str.length == 2){
            val j = 1
            cmpChars(str, i, j)
        }else if(str.length == 1) { 
            return true 
        }else {
            val j = str.length - i - 1  
            cmpChars(str, i, j)
        }
    }

    def enclosingIter(str: String): Boolean = {
        val len = str.length - 1
        if(len <= 1) return false
        val mid: Int = len/2 
        //println(s"mid: $mid, len: $len")
        
        for( i <- 0 to mid){
            if(i == mid && mid >= 2){
                return true
            }else if(!assertMirrorChars(str, i)){
                return false
            }
        }
        true
    }

    def largestPalindrome(str: String): String = {
        var largest: String = ""
        for(i <- 0 until str.length){
            for(j <- i+1 until str.length ){
                val slice: String = str.slice(i, j)
                if(assertMirrorChars(slice, 0) && enclosingIter(slice)){
                    println(s"Palindrome found: '$slice'")
                    if(slice.length > largest.length) largest = slice
                }
            }
        }
        largest
    }
}
