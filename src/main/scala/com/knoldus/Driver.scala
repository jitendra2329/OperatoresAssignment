package com.knoldus

object Driver extends App {

  private val resultOfAddition = Calculator.calculate("+", Seq(2, 3))
  println(resultOfAddition)

  private val resultOfSubtraction = Calculator.calculate("-", Seq(2, 3))
  println(resultOfSubtraction)

  private val resultOfDivision = Calculator.calculate("/", Seq(2, 3))
  println(resultOfDivision)

  private val resultOfFactorial= Calculator.calculate("!", Seq(5))
  println(resultOfFactorial)

  private val resultOfPower = Calculator.calculate("^", Seq(2, 3))
  println(resultOfPower)

  private val resultOfSummation = Calculator.calculate("sum", Seq(2, 3))
  println(resultOfSummation)

  private val resultOfGCD = Calculator.calculate("gcd", Seq(20, 30))
  println(resultOfGCD)

  private val resultOfFibonacciSeries = Calculator.calculate("fibonacci", Seq(10))
  println(resultOfFibonacciSeries)

  private val isEqual = squareOfExpression.verifyResult(Seq(2,3))
  println(isEqual)
}
