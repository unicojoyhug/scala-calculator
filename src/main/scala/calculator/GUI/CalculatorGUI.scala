package calculator.GUI

import calculator.Service.Calculator
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.geometry.Pos.Center
import scalafx.scene.Scene
import scalafx.scene.control.{Button, TextField, Tooltip}
import scalafx.scene.layout.{BorderPane, GridPane}
import scalafx.scene.paint.Color
import scalafx.scene.text.Font

object CalculatorGUI {

  def getScene: Scene = {
    new Scene {

      fill = Color.rgb(242,241,240)

      val textField = getTextField

      val pane = getButtonGrid(textField)

      //create content
      content = List(textField, pane)
    }
  }

  private def getTextField: TextField = {
    val textField = new TextField

    //set the sizes
    textField.prefHeight = 65
    textField.prefWidth = 290

    textField.layoutX = 5
    textField.layoutY = 5

    //set input font  and size
    textField.setFont(Font.font("Serif", 22))

    textField
  }

  private def getButtonGrid(text: TextField): GridPane = {
    //define buttons - numbers
    val button0 = new Button("0")
    val button1 = new Button("1")
    val button2 = new Button("2")
    val button3 = new Button("3")
    val button4 = new Button("4")
    val button5 = new Button("5")
    val button6 = new Button("6")
    val button7 = new Button("7")
    val button8 = new Button("8")
    val button9 = new Button("9")

    //define buttons - operator
    val plus  = new Button{text = "+"; tooltip = "Add"}
    val minus  = new Button{text = "-"; tooltip = "Subtract"}
    val multiply = new Button{text = "x"; tooltip = "Multiply"}
    val divide  = new Button{text = "/"; tooltip = "Divide"}

    //define buttons - floatPoint, calculate, and clear button
    val floatPoint  = new Button(".")
    val calculate  = new Button{text = "="; tooltip = "Calculate"}
    val clearDisplay = new Button{text = "C"; tooltip = "Clear Screen"}

    //set buttons size
    val buttonWidth = 68
    val buttonDoubleWidth = 142.8

    button7.prefWidth = buttonWidth
    button8.prefWidth = buttonWidth
    button9.prefWidth = buttonWidth
    divide.prefWidth = buttonWidth

    button4.prefWidth = buttonWidth
    button5.prefWidth = buttonWidth
    button6.prefWidth = buttonWidth
    multiply.prefWidth = buttonWidth

    button1.prefWidth = buttonWidth
    button2.prefWidth = buttonWidth
    button3.prefWidth = buttonWidth
    minus.prefWidth = buttonWidth

    button0.prefWidth = buttonDoubleWidth
    floatPoint.prefWidth = buttonWidth
    plus.prefWidth = buttonWidth

    calculate.prefWidth =  buttonDoubleWidth
    clearDisplay.prefWidth = buttonDoubleWidth

    //set actions
    clearDisplay.onAction  = (e: ActionEvent) => {
      text.text = ""
    }

    button0.onAction  = (e: ActionEvent) => {
      if(text.text.value.length == 1 && text.text.value == "0"){
        e.consume()
      } else text.text = text.text.value + "0"
    }

    button1.onAction  = (e: ActionEvent) => {
      text.text = text.text.value + "1"
    }

    button2.onAction  = (e: ActionEvent) => {
      text.text = text.text.value + "2"
    }

    button3.onAction  = (e: ActionEvent) => {
      text.text = text.text.value + "3"
    }

    button4.onAction  = (e: ActionEvent) => {
      text.text = text.text.value + "4"
    }

    button5.onAction  = (e: ActionEvent) => {
      text.text = text.text.value + "5"
    }

    button6.onAction  = (e: ActionEvent) => {
      text.text = text.text.value + "6"
    }

    button7.onAction  = (e: ActionEvent) => {
      text.text = text.text.value + "7"
    }


    button8.onAction  = (e: ActionEvent) => {
      text.text = text.text.value + "8"
    }

    button9.onAction  = (e: ActionEvent) => {
      text.text = text.text.value + "9"
    }

    divide.onAction  = (e: ActionEvent) => {
      text.text = checkOperation(text) + "/"
      floatPoint.setDisable(false)
    }

    multiply.onAction  = (e: ActionEvent) => {
      text.text = checkOperation(text)  + "x"
      floatPoint.setDisable(false)
    }

    plus.onAction  = (e: ActionEvent) => {
      text.text = checkOperation(text) + "+"
      floatPoint.setDisable(false)
    }

    minus.onAction  = (e: ActionEvent) => {
      text.text = checkOperation(text) + "-"
      floatPoint.setDisable(false)
    }

    floatPoint.onAction  = (e: ActionEvent) => {
      floatPoint.setDisable(true)
      text.text = text.text.value + "."
    }

    calculate.onAction  = (e: ActionEvent) => {

      if(text.text.value.length == 0 ){
        e.consume()
      } else text.text  = checkOperation(text)
      floatPoint.setDisable(false)
    }

    //Add pane for buttons
    val pane = new GridPane

    pane.setHgap(5)
    pane.setVgap(10)

    //add buttons to pane
    // row 0
    pane.add(button7,1,0)
    pane.add(button8,2,0)
    pane.add(button9,3,0)
    pane.add(divide,4,0)

    // row 1
    pane.add(button4,1,1)
    pane.add(button5,2,1)
    pane.add(button6,3,1)
    pane.add(multiply,4,1)


    // row 2
    pane.add(button3,1,2)
    pane.add(button2,2,2)
    pane.add(button1,3,2)
    pane.add(minus,4,2)


    // row 3
    pane.add(button0,1,3, 2, 1)
    pane.add(floatPoint,3,3, 1, 1)
    pane.add(plus,4,3,2,1)


    // row 4 - bottom
    pane.add(clearDisplay,1,4, 2, 1)
    pane.add(calculate,3,4, 2, 1)

    //position grid pane
    pane.setLayoutY(80)
    pane.setAlignment(Center)

    //returning GridPane with buttons
    pane
  }

  private def checkOperation(text: TextField): String = {
    val result = (text.text.value.length!=0 && text.text.value.substring(1).matches(".*(\\+|\\-|x|\\/).*"))
    if(result){
      Calculator.getResult(text.text.value)
    } else text.text.value
  }
}
