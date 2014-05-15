package com.joshroppo.ScalaExamples

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.lang.Math

import NewtonMeth._

@RunWith(classOf[JUnitRunner])
class TestNewton extends FunSuite {

    test("Assert 4 is 2"){
        assert(Math.abs(sqrt(4) - 2.0) < 0.0001)
    }

}
