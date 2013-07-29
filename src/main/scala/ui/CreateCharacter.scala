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
  val okText       : String             = "Ok"
  val cancelText   : String             = "Cancel" 
  val radioClasses : Array[String]      = Array("Wizard", "Fighter", "Rogue")
  var radioGroup   : ButtonGroup        = null
  var radios       : Array[RadioButton] = new Array[RadioButton](10)
  var ok           : Button             = new Button{ text = okText }
  var cancel       : Button             = new Button{ text = cancelText }

  title = "Create your character" 
  modal = true
  visible = true

  // for (s <- radioClasses) radios :+ (new Button{ text = s })

  // radioGroup = new ButtonGroup(radios:_*)

  contents = new BorderPanel{
    import BorderPanel.Position._
    layout(new Label{text = "herp"}) = South
  }
}
