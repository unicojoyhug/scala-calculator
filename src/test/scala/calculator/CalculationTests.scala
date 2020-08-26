package calculator

import calculator.Service.Calculator
import org.scalatest.funsuite.AnyFunSuite

/**
 * ref: https://www.scalatest.org/user_guide/selecting_a_style
 */
class CalculationTests extends AnyFunSuite{

  test("Addition"){
    assert(Calculator.plus(Array(1,10)) == 11)
    assert(Calculator.plus(Array(1, -20)) == -19)
    assert(Calculator.plus(Array(-1, -20)) == -21)
    assert(Calculator.plus(Array(0, 0)) != 1)
  }

  test("Subtraction"){
    assert(Calculator.minus(Array(1,10)) == -9)
    assert(Calculator.minus(Array(1, -20)) == 21)
    assert(Calculator.minus(Array(-1, -20)) == 19)
    assert(Calculator.minus(Array(0, 0)) != 1)
  }

  test("division"){
    assertThrows[ArithmeticException](Calculator.divide(Array(1, 0)))
    assertThrows[ArithmeticException](Calculator.divide(Array(0, 0)))
    assert(Calculator.divide(Array(0, 1)) == 0)
    assert(Calculator.divide(Array(0.3, 0.7)) == 0.428571429 )
  }

  test("multiplication"){
    assert(Calculator.multiply(Array(1,10)) == 10)
    assert(Calculator.multiply(Array(1, -20)) == -20)
    assert(Calculator.multiply(Array(-1, -20)) == 20)
    assert(Calculator.multiply(Array(0, 0)) == 0)
    assert(Calculator.multiply(Array(0, 1)) == 0)
    assert(Calculator.multiply(Array(1, 0)) == 0)

  }

  test("calculation getResult"){
    assert(Calculator.getResult("123+123")=="246")
    assert(Calculator.getResult("123-123")=="0")
    assert(Calculator.getResult("123/123")=="1")
    assert(Calculator.getResult("123x123")=="15129")
  }

}
