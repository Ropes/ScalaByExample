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
}
