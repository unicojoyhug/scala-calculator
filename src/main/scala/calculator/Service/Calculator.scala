package calculator.Service

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
        case Some('+') => calculate((a, b)  => a + b)(inputList(0), inputList(1))
        case Some('-') => calculate((a, b)  => a - b)(inputList(0), inputList(1))
        case Some('x') => calculate((a, b)  => a * b)(inputList(0), inputList(1))
        case Some('/') => calculate((a, b) => divide(a, b))(inputList(0), inputList(1))
        case None => {
          logger.debug(input)
          throw new ArithmeticException("Unknown operator")}
      })
    } catch {
      case x : NumberFormatException => {"Wrong input"}
    }
  }

  def calculate(f:(Double, Double)=> Double)(a: Double, b: Double):Double = f(a, b)

  def divide (inputLeft:Double, inputRight:Double):Double = {
    if(inputRight == 0) {
      throw new ArithmeticException("Division by zero is undefined.")
    } else {
      BigDecimal(inputLeft / inputRight).setScale(9, BigDecimal.RoundingMode.HALF_UP).toDouble
    }
  }
}

