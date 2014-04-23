package com.joshroppo.ScalaExamples

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Iterites._

@RunWith(classOf[JUnitRunner])
class TestIterites extends FunSuite {
    val wat: Array[Int] = Array(1, 4, 6, 3, 2, 10, 100)
    test("Test array length"){
        assert(wat.length == 7)
    }
    test("Test element value"){
        assert(wat(1) == 4)
    }
    test("Test Predicate"){
        val f = (p: Int) => p > 5 
        val out = filter_predicate(wat)(f)
        assert(out === Array(6,10,100))
    }
}
    
