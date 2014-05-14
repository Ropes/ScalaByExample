package com.joshroppo.ScalaExamples

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Palindromes._

@RunWith(classOf[JUnitRunner])
class TestPalindromes extends FunSuite {
    val checkTrue = Set("racecar", "101", "hihih")
    val checkFalse = Set("racebuggy", "122", "hihii", " at ")
    val sent = "The racecars drive at over 101 mph for 1001 minutes of pastetsap!"
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
    test("Enclosing iter true"){
        checkTrue.foreach((s: String) => assert(enclosingIter(s)))
    }
    test("Enclosing iter false"){
        checkFalse.foreach((s: String) => assert(false == enclosingIter(s)))
    }

    test("Assert Mirrored Chars true"){
        checkTrue.foreach((s: String) => assert(assertMirrorChars(s, 0)))
    }
    test("Cmp chars true"){
        assert(cmpChars("aa", 0, 1))
    }
    test("Cmp chars false"){
        assert(!cmpChars("at", 0, 1))
    }
    test("Assert M C false special"){
        assert(!assertMirrorChars("at", 0))
    }
    test("Assert M C true special2"){
        assert(assertMirrorChars("aa", 0))
    }
    test("Assert Not Mirrored chars"){
        assert(assertMirrorChars("fat", 0) == false)
        assert(assertMirrorChars("fsdfasdfasdfat", 0) == false)
    }

    test("Search string iteration"){
        assert(largestPalindrome(sent) == "pastetsap")
    }
}
