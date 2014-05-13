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

    def assertMirrorChars(str: String, i: Int): Boolean = {
        val j = str.length - i - 1  
        if (str.charAt(i) == str.charAt(j)) true else false
    }

    def enclosingIter(str: String): Boolean = {
        val len = str.length - 1
        if(len <= 1) return false
        val mid: Int = len/2 
        
        for( i <- 0 to mid){
            if(i == mid){
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
            for(j <- i+1 until str.length-1 ){
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
