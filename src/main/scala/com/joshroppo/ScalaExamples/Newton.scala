package com.joshroppo.ScalaExamples
import java.lang.Math

object NewtonMeth {
    
    def sqrt(x: Double): Double = {
        def sqrtIter(guess: Double, x: Double): Double = 
            if(isGoodEnough(guess, x)) guess
            else sqrtIter(improve(guess, x), x)

        def improve(guess: Double, x: Double) = 
            (guess + x / guess) / 2

        def isGoodEnough(guess: Double, x: Double) = 
            Math.abs(guess*guess - x) < 0.001
        sqrtIter(1.0, x)
    }

}
