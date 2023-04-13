package com.knoldus

import scala.concurrent.ExecutionContext.Implicits.global

object Driver extends App {
  private val resultOfAddition = Calculator.calculate("+", Seq(2, 3))

  resultOfAddition.onComplete {
    case scala.util.Success(result) => println("Sum of two elements in the Seq: " + result.head)
    case scala.util.Failure(exception) => println(exception.getMessage)
  }

  private val resultOfSubtraction = Calculator.calculate("-", Seq(45, 3))

  resultOfSubtraction.onComplete {
    case scala.util.Success(result) => println("Difference of two elements in the Seq(45, 3): " + result.head)
    case scala.util.Failure(exception) => println(exception.getMessage)
  }

  private val resultOfMultiplication = Calculator.calculate("*", Seq(7, 19))

  resultOfMultiplication.onComplete {
    case scala.util.Success(result) => println("Result of Multiplication of two elements in the Seq(7, 19): " + result.head)
    case scala.util.Failure(exception) => println(exception.getMessage)
  }

  private val resultOfDivision = Calculator.calculate("/", Seq(77, 11))

  resultOfDivision.onComplete {
    case scala.util.Success(result) => println("Result of Division of two elements in the Seq(77, 11): " + result.head)
    case scala.util.Failure(exception) => println(exception.getMessage)
  }

  private val resultOfPower = Calculator.calculate("^", Seq(2, 3))

  resultOfPower.onComplete {
    case scala.util.Success(result) => println("Result of Power of two elements in the Seq(2, 3): " + result.head)
    case scala.util.Failure(exception) => println(exception.getMessage)
  }

  private val resultOfFactorial = Calculator.calculate("!", Seq(5))

  resultOfFactorial.onComplete {
    case scala.util.Success(result) => println("Result of Factorial of element in the Seq(5): " + result.head)
    case scala.util.Failure(exception) => println(exception.getMessage)
  }

  private val resultOfSquareRoot = Calculator.calculate("sqrt", Seq(121))

  resultOfSquareRoot.onComplete {
    case scala.util.Success(result) => println("Result of Square root of element in the Seq(121): " + result.head)
    case scala.util.Failure(exception) => println(exception.getMessage)
  }

  private val resultOfSummation = Calculator.calculate("sum", Seq(2, 3, 12, 15, 10))

  resultOfSummation.onComplete {
    case scala.util.Success(result) => println("Result of Square root of element in the Seq(2, 3, 12, 15, 10): " + result.head)
    case scala.util.Failure(exception) => println(exception.getMessage)
  }

  private val resultOfGCD = Calculator.calculate("gcd", Seq(20, 30))

  resultOfGCD.onComplete {
    case scala.util.Success(result) => println("Result of greatest common divisor of element in the Seq(20, 30): " + result.head)
    case scala.util.Failure(exception) => println(exception.getMessage)
  }

  private val resultOfGetOddValues = Calculator.calculate("odd", Seq(10, 23, 21, 45, 22, 44, 87, 34))

  resultOfGetOddValues.onComplete {
    case scala.util.Success(result) => println("Odd values of the the Seq(10, 23, 21, 45, 22, 44, 87, 34): " + result)
    case scala.util.Failure(exception) => println(exception.getMessage)
  }

  private val resultOfGetEvenValues = Calculator.calculate("even", Seq(10, 23, 21, 45, 22, 44, 87, 34))

  resultOfGetEvenValues.onComplete {
    case scala.util.Success(result) => println("Even values of the the Seq(10, 23, 21, 45, 22, 44, 87, 34): " + result)
    case scala.util.Failure(exception) => println(exception.getMessage)
  }

  private val resultOfFibonacciSeries = Calculator.calculate("fibonacci", Seq(10))

  resultOfFibonacciSeries.onComplete {
    case scala.util.Success(result) => println("Result of fibonacci series of element in the Seq(10): " + result)
    case scala.util.Failure(exception) => println(exception.getMessage)
  }

  private val isEqual = SquareOfExpression.verifyResult(Seq(2, 3))

  isEqual.onComplete {
    case scala.util.Success(result) => println("Is {(9 + 5)^2 = 9^2 + 5^2 + 2*9*5} on the Seq(9,5): " + result)
    case scala.util.Failure(exception) => println(exception.getMessage)
  }

  private val resultOfFindNumbers = FindNumbers.findNumbers(Seq(2, 4, 9, 5, 12))

  resultOfFindNumbers.onComplete {
    case scala.util.Success(result) => println("Result of finding numbers whose factorial is greater than 6^number of the Seq(2, 4, 9, 5, 12): " + result)
    case scala.util.Failure(exception) => println(exception.getMessage)
  }

  private val averageAfterChangingOperations = FindAverageAfterChangingOperations.findAverageAfterChangingOperations(Seq(5, 3, 7, 8, 11, 10))

  averageAfterChangingOperations.onComplete {
    case scala.util.Success(result) => println("Result of averageAfterChangingOperations of the Seq(2, 4, 9, 5, 12): " + result)
    case scala.util.Failure(exception) => println(exception.getMessage)
  }
}
