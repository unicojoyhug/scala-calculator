package calculator

import calculator.Service.Calculator
import org.scalatest.funsuite.AnyFunSuite

/**
 * ref: https://www.scalatest.org/user_guide/selecting_a_style
 */
class CalculationTests extends AnyFunSuite{
  test("division"){
    assertThrows[ArithmeticException](Calculator.divide(1, 0))
    assertThrows[ArithmeticException](Calculator.divide(0, 0))
    assert(Calculator.divide(0, 1) == 0)
    assert(Calculator.divide(0.3, 0.7) == 0.428571429 )
  }

  test("calculation getResult"){
    assert(Calculator.getResult("123+123")=="246")
    assert(Calculator.getResult("123-123")=="0")
    assert(Calculator.getResult("123/123")=="1")
    assert(Calculator.getResult("123x123")=="15129")
  }
}
