package com.knoldus

import scala.math.BigDecimal.double2bigDecimal
import scala.concurrent.Future

case object SquareOfExpression {
  def verifyResult(operands: Seq[Double]): Future[String] = {
    if (validate(operands)) {
      Future.successful(validateAndExecute(operands))
    }
    else Future.failed(new CalculatorException("results are not equal."))
  }

  private def validate(operands: Seq[Double]): Boolean = operands.length == 2

  private def validateAndExecute(operands: Seq[Double]): String = execute(operands)

  private def execute(operands: Seq[Double]): String = {
    val result = squareOfExpression(operands)
    if (result) "Equal"
    else "Not Equal"
  }

  private def squareOfExpression(operands: Seq[Double]): Boolean = {
    val squareOfOperands = (operands.head + operands(1)).pow(2)
    val result = (operands.head.pow(2)) + (operands(1).pow(2)) + (2 * operands.head * operands(1))
    squareOfOperands == result
  }
}
