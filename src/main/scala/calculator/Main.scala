package calculator

import calculator.GUI.CalculatorGUI
import scalafx.application.JFXApp

object Main extends JFXApp {

  stage = new JFXApp.PrimaryStage {
    title.value = "Scala Calculator"
    resizable = false

    width = 300
    height = 300
    centerOnScreen()

    scene = CalculatorGUI.getScene
  }
}
