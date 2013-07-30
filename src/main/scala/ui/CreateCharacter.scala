package sclack.ui

import javax.swing.ImageIcon
import java.awt.Dimension
import swing._
import swing.event._
import scala.swing._

/**
 * Dialog where we can create a particular character for playing the game.
 * @author Simon Symeonidis 
 */
class CreateCharacter extends Dialog {
  var okText       : String             = "Ok"
  var cancelText   : String             = "Cancel" 
  var radioClasses : Array[String]      = Array("Wizard", "Fighter", "Rogue")
  var radioGroup   : ButtonGroup        = null
  var radios       : Array[RadioButton] = new Array[RadioButton](0)
  var radioPanel   : BoxPanel           = new BoxPanel(Orientation.Horizontal)
  var ok           : Button             = new Button{ text = okText }
  var cancel       : Button             = new Button{ text = cancelText }
  var characterIco : Label              = new Label{ text = "todo char ico" }

  /* UI Setup start */
  title   = "Create your character" 
  modal   = true

  /* Make the radios */

  val bottomButtons = new BoxPanel(Orientation.Horizontal) {
    contents += ok
    contents += cancel
  }
 
  val classRadios = new BoxPanel(Orientation.Horizontal) {
    for (rc <- radioClasses) radios :+= new RadioButton(rc)
    radioGroup = new ButtonGroup(new RadioButton{text= "alksdj"})
    contents ++= radios
  }

  contents = new BorderPanel{
    import BorderPanel.Position._
    layout(classRadios)   = North
    layout(characterIco)  = Center
    layout(bottomButtons) = South
  }
  /* UI Setup end */

  centerOnScreen()
  open()
}
