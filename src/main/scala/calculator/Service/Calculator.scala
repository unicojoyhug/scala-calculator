package calculator.Service

import java.lang.NumberFormatException

import org.slf4j.LoggerFactory
import java.text.DecimalFormat

object Calculator{
  def logger = LoggerFactory.getLogger(this.getClass)

  def getResult(input:String):String ={
    //parse input with left / operator / right
    val format = new DecimalFormat("0.#########")

    val operator = List ('+', '-', '/', 'x').find(input.contains(_))

    val inputList = input.replaceAll("\\s", "").split(operator.last).map(_.toDouble)

    try{
      format.format( operator match {
        case Some('+') => plus(inputList)
        case Some('-') => minus(inputList)
        case Some('x') => multiply(inputList)
        case Some('/') => divide(inputList)
        case None => {
          logger.debug(input)
          throw new ArithmeticException("Unknown operator")}
      })
    } catch {
      case x : NumberFormatException => {"Wrong input"}
    }
  }

  def plus (inputArray: Array[Double]): Double = inputArray(0) + inputArray(1)

  def minus (inputArray: Array[Double]): Double = inputArray(0) - inputArray(1)

  def multiply (inputArray: Array[Double]):Double = inputArray(0) * inputArray(1)

  def divide (inputArray: Array[Double]):Double = {
    if(inputArray(1) == 0) {
      throw new ArithmeticException("Division by zero is undefined.")
    } else {
      BigDecimal(inputArray(0) / inputArray(1)).setScale(9, BigDecimal.RoundingMode.HALF_UP).toDouble
    }

  }
}

