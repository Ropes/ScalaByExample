package com.joshroppo.ScalaExamples

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Palindromes._

@RunWith(classOf[JUnitRunner])
class TestPalindromes extends FunSuite {
    val checkTrue = Set("racecar", "101", "hihih")
    val checkFalse = Set("racebuggy", "122", "hihii")
    test("Check true recursive"){
        assert(recursive("racecar"))
    }
    test("Check false recursive"){
        assert(false == recursive("watman"))
    }
    test("Recursive true list"){
        checkTrue.foreach((s: String) => assert(recursive(s)))
    }
    test("Recursive false list"){
        checkFalse.foreach((s: String) => assert(false == recursive(s)))
    }
    test("Easy approach"){
        checkTrue.foreach((s: String) => assert(dumb(s)))
    }
    test("Easy fail approach"){
        checkFalse.foreach((s: String) => assert(false == dumb(s)))
    }

}
