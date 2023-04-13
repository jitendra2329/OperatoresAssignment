package com.knoldus

import scala.annotation.tailrec
import scala.concurrent.Future

case object FindAverageAfterChangingOperations extends Operator {
  def findAverageAfterChangingOperations(operands: Seq[Double]): Future[Seq[Double]] = {
    if (validate(operands)) {
      Future.successful(validateAndExecute(operands))
    }
    else Future.failed(new CalculatorException("results are not equal."))
  }

  override def validate(operands: Seq[Double]): Boolean = operands.nonEmpty

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    val fibonacciNumbers = operands.map(value => findFibonacci(value))
    val oddValues = findOddValuesFromSequence(fibonacciNumbers)
    val sumOfOddValues = sumOfOddValuesOfFibonacciNumbers(oddValues)
    val averageAfterChangingOperations = sumOfOddValues / oddValues.size

    Seq(averageAfterChangingOperations)
  }

  @tailrec
  private def findFibonacci(number: Double, firstNumber: Double = 0, secondNumber: Double = 1): Double = {
    if (number == 1) 0.0
    else if (number <= 2) secondNumber
    else findFibonacci(number - 1, secondNumber, secondNumber + firstNumber)
  }

  private def findOddValuesFromSequence(values: Seq[Double]): Seq[Double] = {
    values.filter(_ % 2 != 0)
  }

  private def sumOfOddValuesOfFibonacciNumbers(values: Seq[Double]): Double = {
    values.foldLeft(0.0)(_ + _)
  }
}

