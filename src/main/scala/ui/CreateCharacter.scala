package sclack.ui

import javax.swing.ImageIcon
import javax.swing.border.EmptyBorder
import java.awt.Dimension
import swing._
import swing.event._
import scala.swing._

/* lib */
import sclack.domain.{Character, Rogue, Fighter, Wizard}

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

  /* Stats */
  var player       : Character          = new Character

  var constitutionLabel : Label = 
    new Label{ text = "Constitution : " + player.constitution }
  var intelligenceLabel : Label = 
    new Label{ text = "Intelligence : " + player.intelligence }
  var strengthLabel     : Label = 
    new Label{ text = "Strength : " + player.strength }

  var statsList         : Array[Label] = Array[Label](constitutionLabel, intelligenceLabel, strengthLabel)

  /* UI Setup start */
  title   = "Create your character" 
  modal   = true

  preferredSize = new Dimension(400,400)
  maximumSize   = new Dimension(400,400)
  minimumSize   = new Dimension(400,400)

  /* Make the radios */

  val bottomButtons = new BoxPanel(Orientation.Horizontal) {
    contents += ok
    contents += cancel
  }

  val classRadios = new BoxPanel(Orientation.Horizontal) {
    for (rc <- radioClasses) radios :+= new RadioButton(rc)
    radioGroup = new ButtonGroup(radios:_*)
    contents ++= radios
  }

  val buttonsAndRadios = new BoxPanel(Orientation.Vertical) {
    contents += classRadios
    contents += bottomButtons
  }

  val statsLabels = new BoxPanel(Orientation.Vertical){
    contents ++= statsList
  }

  contents = new BorderPanel {
    import BorderPanel.Position._
    layout(statsLabels)      = East
    layout(characterIco)     = Center
    layout(buttonsAndRadios) = South
    border = new EmptyBorder(10,10,10,10)
  }

  /* UI Setup end */

  centerOnScreen()
  open()
}
