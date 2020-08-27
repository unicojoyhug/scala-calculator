package calculator.Service

import java.lang.NumberFormatException

import org.slf4j.LoggerFactory
import java.text.DecimalFormat

object Calculator{
  def logger = LoggerFactory.getLogger(this.getClass)

  def getResult(input:String):String ={
    //parse input with left / operator / right
    val format = new DecimalFormat("0.#########")

    val operator = input.replaceAll("\\s", "")

    try {
      if (operator.contains('+')) {
        format.format(plus(input.split('+').map(_.toDouble)))
      } else if (operator.contains('-')) {
        format.format(minus(input.split('-').map(_.toDouble)))
      } else if (operator.contains('/')) {
        format.format(divide(input.split('/').map(_.toDouble)))
      } else if (operator.contains('x')) {
        format.format(multiply(input.split('x').map(_.toDouble)))
      } else throw new ArithmeticException("Unknown operator")
    }catch {
      case x : NumberFormatException => {"Wrong input"}
    }

  }

  def plus (inputArray: Array[Double]): Double = inputArray(0) + inputArray(1)

  def minus (inputArray: Array[Double]): Double = inputArray(0) - inputArray(1)

  def multiply (inputArray: Array[Double]):Double = inputArray(0) * inputArray(1)

  def divide (inputArray: Array[Double]):Double = {
    if(inputArray(1) == 0)
      throw new ArithmeticException("Division by zero is undefined.")
    else {
      BigDecimal(inputArray(0) / inputArray(1)).setScale(9, BigDecimal.RoundingMode.HALF_UP).toDouble
    }
  }
}

