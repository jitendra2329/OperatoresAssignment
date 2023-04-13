package com.knoldus

import com.knoldus.FibonacciSeries.fibonacciSeries

import scala.annotation.tailrec
import scala.concurrent.Future
import scala.jdk.Accumulator
import scala.math.BigDecimal.double2bigDecimal

// User defined exception class for calculation errors
class CalculatorException(message: String) extends Exception

// Validation and execution of operands for Additions
case object Addition extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    val result = operands.head + operands(1)
    Seq(result)
  }
}

// Validation and execution of operands for Subtraction
case object Subtraction extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    val result = operands.head - operands(1)
    Seq(result)
  }
}

//Validation and execution of operands for Multiplication
case object Multiplication extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    val result = operands.head * operands(1)
    Seq(result)
  }
}

//Validation and execution of operands for Division
case object Division extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    val result = operands.head / operands(1)
    Seq(result)
  }
}

//Validation and execution of operands for Power
case object Power extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    val result = operands.head.pow(operands(1).toInt)
    Seq(result.toDouble)
  }
}

//Validation and execution of operands for SquareRoot
case object SquareRoot extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 1 && operands.head >= 0

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    val result = Math.sqrt(operands.head)
    Seq(result)
  }
}

//Validation and execution of operands for Factorial
case object Factorial extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 1

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    val result = calculateFactorial(operands.head)
    Seq(result)
  }

  @tailrec
  private def calculateFactorial(number: Double, accumulator: Double = 1): Double = {
    if (number <= 0) accumulator
    else calculateFactorial(number - 1, accumulator * number)
  }
}

//Validation and execution of operands for Summation
case object Summation extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.nonEmpty

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    val result = operands.foldLeft(0.0)(_ + _)
    Seq(result)
  }
}

//Validation and execution of operands for GetOddOperands
case object GetOddOperands extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.nonEmpty

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    val result = operands.filter(_ % 2 != 0)
    result
  }
}

//Validation and execution of operands for GetEvenOperands
case object GetEvenOperands extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.nonEmpty

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    val result = operands.filter(_ % 2 == 0)
    result
  }
}

//Validation and execution of operands for GetGCD
case object GetGCD extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    val result = findGCD(operands.head, operands(1))
    result
  }

  @tailrec
  private def findGCD(firstOperand: Double, secondOperand: Double): Seq[Double] = {
    if (secondOperand == 0) Seq(firstOperand)
    else findGCD(secondOperand, firstOperand % secondOperand);
  }
}

//Validation and execution of operands for FibonacciSeries
case object FibonacciSeries extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 1

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    val result = fibonacciSeries(operands.head)
    result
  }

  private def fibonacciSeries(number: Double): Seq[Double] = {
    if (number <= 0) Seq()
    else if (number == 1) Seq(0)
    else if (number == 2) Seq(0, 1)
    else {
      val prevSeq = fibonacciSeries(number - 1) // generate the previous Fibonacci sequence
      prevSeq :+ (prevSeq.takeRight(2).sum) // add the next number to the sequence
    }
  }
}


case object squareOfExpression {
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

case object FindNumbers {
  def findNumbers(operands: Seq[Double]): Future[String] = {
    if (validate(operands)) {
      Future.successful(validateAndExecute(operands))
    }
    else Future.failed(new CalculatorException("results are not equal."))
  }

  private def validate(operands: Seq[Double]): Boolean = operands.nonEmpty

  private def validateAndExecute(operands: Seq[Double]): String = execute(operands)

  private def execute(operands: Seq[Double]): Seq[Double] = {
    val sequenceOfFactorials = operands.map(value => findFactorial(value))
    val valueSix = 6

    def findPower(value: Double):BigDecimal = {
      valueSix.pow(value.toInt)
    }

    val powerOfSix = for {
      value <- operands
    } yield valueSix.pow(value.toInt)

    val result = operands.map(value => findPower(value)).filter()
  }

  private def findFactorial(value: Double): Double = {
    @tailrec
    def factorialHelper(number: Double, accumulator: Double = 1): Double = {
      if (number <= 0) accumulator
      else factorialHelper(number - 1, accumulator * number)
    }

    factorialHelper(value)
  }
  //  private def squareOfExpression(operands: Seq[Double]): Boolean ={
  //    val squareOfOperands = (operands.head + operands(1)).pow(2)
  //    val result = (operands.head.pow(2)) + (operands(1).pow(2)) + (2 * operands.head * operands(1))
  //    squareOfOperands == result
  //  }
}


object Calculator {

  // matching the provided operators and the Calling the corresponding Classes
  def calculate(operator: String, operands: Seq[Double]): Future[Seq[Double]] = {
    val op: Operator = operator match {
      case "+" => Addition
      case "-" => Subtraction
      case "*" => Multiplication
      case "/" => Division
      case "^" => Power
      case "sqrt" => SquareRoot
      case "!" => Factorial
      case "sum" => Summation
      case "gcd" => GetGCD
      case "odd" => GetOddOperands
      case "even" => GetEvenOperands
      case "fibonacci" => FibonacciSeries
      case _ => throw new IllegalArgumentException("Invalid operator")
    }

    execute(op, operands)
  }

  private def execute(operator: Operator, operands: Seq[Double]): Future[Seq[Double]] = {
    if (operator.validate(operands)) {
      Future.successful(operator.execute(operands))
    } else {
      Future.failed(new CalculatorException("Invalid operands"))
    }
  }
}
