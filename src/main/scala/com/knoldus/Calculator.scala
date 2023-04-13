package com.knoldus

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec
import scala.concurrent.Future
import scala.math.BigDecimal.double2bigDecimal

// User defined exception class for calculation errors
class CalculatorException(message: String) extends Exception

// Validation and execution of operands for Additions
case object Addition extends Operator {
  private val logger: Logger = Logger(getClass.getName)

  override def validate(operands: Seq[Double]): Boolean = {
    logger.info("validation done for the addition of two numbers!")
    operands.length == 2
  }

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(operands.head + operands(1))
  }
}

// Validation and execution of operands for Subtraction
case object Subtraction extends Operator {
  private val logger: Logger = Logger(getClass.getName)

  override def validate(operands: Seq[Double]): Boolean = {
    logger.info("validation done for the subtraction of two numbers!")
    operands.length == 2
  }

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(operands.head - operands(1))
  }
}

//Validation and execution of operands for Multiplication
case object Multiplication extends Operator {
  private val logger: Logger = Logger(getClass.getName)

  override def validate(operands: Seq[Double]): Boolean = {
    logger.info("validation done for the multiplication of two numbers!")
    operands.length == 2
  }

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(operands.head * operands(1))
  }
}

//Validation and execution of operands for Division
case object Division extends Operator {
  private val logger: Logger = Logger(getClass.getName)

  override def validate(operands: Seq[Double]): Boolean = {
    logger.info("validation done for the division of two numbers!")
    operands.length == 2
  }

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(operands.head / operands(1))
  }
}

//Validation and execution of operands for Power
case object Power extends Operator {
  private val logger: Logger = Logger(getClass.getName)

  override def validate(operands: Seq[Double]): Boolean = {
    logger.info("validation done for finding power!")
    operands.length == 2
  }

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    val result = operands.head.pow(operands(1).toInt)
    Seq(result.toDouble)
  }
}

//Validation and execution of operands for SquareRoot
case object SquareRoot extends Operator {
  private val logger: Logger = Logger(getClass.getName)

  override def validate(operands: Seq[Double]): Boolean = {
    logger.info("validation done for finding square root!")
    operands.length == 1 && operands.head >= 0
  }

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    val result = Math.sqrt(operands.head)
    Seq(result)
  }
}

//Validation and execution of operands for Factorial
case object Factorial extends Operator {
  private val logger: Logger = Logger(getClass.getName)

  override def validate(operands: Seq[Double]): Boolean = {
    logger.info("validation done for finding factorials!")
    operands.length == 1
  }

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(calculateFactorial(operands.head))
  }

  @tailrec
  private def calculateFactorial(number: Double, accumulator: Double = 1): Double = {
    if (number <= 0) accumulator
    else calculateFactorial(number - 1, accumulator * number)
  }
}

//Validation and execution of operands for Summation
case object Summation extends Operator {
  private val logger: Logger = Logger(getClass.getName)

  override def validate(operands: Seq[Double]): Boolean = {
    logger.info("validation done for finding Summation!")
    operands.nonEmpty
  }

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(operands.foldLeft(0.0)(_ + _))
  }
}

//Validation and execution of operands for GetOddOperands
case object GetOddOperands extends Operator {
  private val logger: Logger = Logger(getClass.getName)

  override def validate(operands: Seq[Double]): Boolean = {
    logger.info("validation done for getting odd values!")
    operands.nonEmpty
  }

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    operands.filter(_ % 2 != 0)
  }
}

//Validation and execution of operands for GetEvenOperands
case object GetEvenOperands extends Operator {
  private val logger: Logger = Logger(getClass.getName)

  override def validate(operands: Seq[Double]): Boolean = {
    logger.info("validation done for getting even values!")
    operands.nonEmpty
  }

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    operands.filter(_ % 2 == 0)
  }
}

//Validation and execution of operands for GetGCD
case object GetGCD extends Operator {
  private val logger: Logger = Logger(getClass.getName)

  override def validate(operands: Seq[Double]): Boolean = {
    logger.info("validation done for GCD!")
    operands.length == 2
  }

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    findGCD(operands.head, operands(1))
  }

  @tailrec
  private def findGCD(firstOperand: Double, secondOperand: Double): Seq[Double] = {
    if (secondOperand == 0) Seq(firstOperand)
    else findGCD(secondOperand, firstOperand % secondOperand);
  }
}

//Validation and execution of operands for FibonacciSeries
case object FibonacciSeries extends Operator {
  private val logger: Logger = Logger(getClass.getName)

  override def validate(operands: Seq[Double]): Boolean = {
    logger.info("validation done for getting fibonacci series!")
    operands.length == 1
  }

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = execute(operands)

  override def execute(operands: Seq[Double]): Seq[Double] = {
    fibonacciSeries(operands.head)
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
