package sclack.ui

import swing._
import scala.swing._
import swing.event._
import javax.swing.border.EmptyBorder

import sclack.ui.factories.{TextFieldFactory, TextAreaFactory}

/**
 * The Credits dialog to respect the artists (and ego whoring :D)
 * @author Simon Symeonidis 
 */ 
class Credits extends Dialog {

  val tff = TextFieldFactory
  val taf = TextAreaFactory

  val programmingLabel = new Label{ text = "Programming: " }
  val authorField      = tff.disabledTextField("Simon (psyomn) Symeonidis")
  val thanksLabel      = new Label{ text = "Thanks to: " }
  val thanksArea       = taf.disabledTextArea(
    "Jerom for the fantasy tileset:\n"
    + "  http://opengameart.org/sites/default/files/tileset_16x16_Jerom_CC-BY-SA-3.0_1.png&nid=17136\n\n"
    + "Gwes for the NES style tileset:\n"
    + "  http://opengameart.org/content/16x16-dungeon-tiles-nes-remake")
  val back             = new Button{ text = "Back" }

  val components : Array[Component] = 
    Array[Component](programmingLabel, authorField, thanksLabel, 
                     thanksArea, back)

  title   = "Credits" 
  modal   = true

  preferredSize = new Dimension(700,400)
  maximumSize   = new Dimension(700,400)
  minimumSize   = new Dimension(700,400)

  contents = new BoxPanel(Orientation.Vertical) {
    contents ++= components
     
    border = new EmptyBorder(10,10,10,10)
  }
 
  listenTo(back)
  reactions += {
    case ButtonClicked(b) =>
      dispose
  }

  centerOnScreen()
  open()
}
