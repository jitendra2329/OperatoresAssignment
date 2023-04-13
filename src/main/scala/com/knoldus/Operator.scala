package com.knoldus

trait Operator extends Validator{
  def validateAndExecute(operands: Seq[Double]): Seq[Double]
  def execute(operands: Seq[Double]): Seq[Double]
}