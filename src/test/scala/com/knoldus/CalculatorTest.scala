package com.knoldus

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class CalculatorTest extends AnyFlatSpec with ScalaFutures {

  it should "return addition of values of Seq(23,21)" in {
    val actualResult = Calculator.calculate("+", Seq(23, 21))
    val expectedResult = List(44.0)
    whenReady(actualResult) { result =>
      result shouldBe expectedResult
    }
  }


  it should "return multiplication of values of Seq(2,11)" in {
    val actualResult = Calculator.calculate("*", Seq(2, 11))
    val expectedResult = List(22.0)
    whenReady(actualResult) { result =>
      result shouldBe expectedResult
    }
  }

  it should "return division of values of Seq(23,21)" in {
    val actualResult = Calculator.calculate("/", Seq(33, 11))
    val expectedResult = List(3.0)
    whenReady(actualResult) { result =>
      result shouldBe expectedResult
    }
  }

  it should "return subtraction of values of Seq(23,21)" in {
    val actualResult = Calculator.calculate("-", Seq(23, 21))
    val expectedResult = List(2.0)
    whenReady(actualResult) { result =>
      result shouldBe expectedResult
    }
  }

  it should "return power of Seq(2, 4)" in {
    val actualResult = Calculator.calculate("^", Seq(2, 4))
    val expectedResult = List(16.0)
    whenReady(actualResult) { result =>
      result shouldBe expectedResult
    }
  }

  it should "return square root of value of Seq(121)" in {
    val actualResult = Calculator.calculate("sqrt", Seq(121))
    val expectedResult = List(11.0)
    whenReady(actualResult) { result =>
      result shouldBe expectedResult
    }
  }

  it should "return summation of values of Seq(23, 21, 24, 91)" in {
    val actualResult = Calculator.calculate("sum", Seq(23, 21, 24, 91))
    val expectedResult = List(159.0)
    whenReady(actualResult) { result =>
      result shouldBe expectedResult
    }
  }

  it should "return gcd of values of Seq(20,30)" in {
    val actualResult = Calculator.calculate("gcd", Seq(20, 30))
    val expectedResult = List(10.0)
    whenReady(actualResult) { result =>
      result shouldBe expectedResult
    }
  }

  it should "return odd values from the values of Seq(25, 30, 23, 21,89, 44, 22)" in {
    val actualResult = Calculator.calculate("odd", Seq(25, 30, 23, 21, 89, 44, 22))
    val expectedResult = List(25.0, 23.0, 21.0, 89.0)
    whenReady(actualResult) { result =>
      result shouldBe expectedResult
    }
  }

  it should "return even values from the values of Seq(25, 30, 23, 21,89, 44, 22)" in {
    val actualResult = Calculator.calculate("even", Seq(25, 30, 23, 21, 89, 44, 22))
    val expectedResult = List(30.0, 44.0, 22.0)
    whenReady(actualResult) { result =>
      result shouldBe expectedResult
    }
  }

  it should "return fibonacci series till the value of Seq(10)" in {
    val actualResult = Calculator.calculate("fibonacci", Seq(10))
    val expectedResult = List(0.0, 1.0, 1.0, 2.0, 3.0, 5.0, 8.0, 13.0, 21.0, 34.0)
    whenReady(actualResult) { result =>
      result shouldBe expectedResult
    }
  }
}
