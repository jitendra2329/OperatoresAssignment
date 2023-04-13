package com.knoldus

import scala.annotation.tailrec
import scala.concurrent.Future
import scala.math.BigDecimal.int2bigDecimal

// case object of finding the number of the Sequence whose factorial is greater than 6 to the power number
case object FindNumbers {
  def findNumbers(operands: Seq[Double]): Future[Seq[Double]] = {
    if (validate(operands)) {
      Future.successful(validateAndExecute(operands))
    }
    else Future.failed(new CalculatorException("results are not equal."))
  }

  private def validate(operands: Seq[Double]): Boolean = operands.nonEmpty

  private def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  private def execute(operands: Seq[Double]): Seq[Double] = {
    filterValues(operands)
  }

  // filtering the values whose factorial is greater than 6^number in Sequence
  private def filterValues(operands: Seq[Double]): Seq[Double] = {
    val valueSix = 6

    def findPower(value: Double): BigDecimal = {
      valueSix.pow(value.toInt)
    }

    val result = operands.filter(value => findPower(value) < findFactorial(value))
    result
  }

  private def findFactorial(value: Double): Double = {
    @tailrec
    def factorialHelper(number: Double, accumulator: Double = 1): Double = {
      if (number <= 0) accumulator
      else factorialHelper(number - 1, accumulator * number)
    }

    factorialHelper(value)
  }
}
