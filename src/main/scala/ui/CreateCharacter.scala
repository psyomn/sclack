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
  val okText       : String = "Ok"
  val cancelText   : String = "Cancel" 
  val wizardText   : String = "Wizard" 
  val fighterText  : String = "Fighter" 
  val rogueText    : String = "Rogue"

  var radioClasses : Array[String]      = 
    Array(wizardText, fighterText, rogueText)

  var radioGroup   : ButtonGroup        = null
  var radios       : Array[RadioButton] = new Array[RadioButton](0)
  var radioPanel   : BoxPanel           = new BoxPanel(Orientation.Horizontal)
  var ok           : Button             = new Button{ text = okText }
  var cancel       : Button             = new Button{ text = cancelText }
  var characterIco : Label              = new Label{ text = "todo char ico" }

  /* Stats */
  var player : Character = new Wizard

  var constitutionLabel : Label = 
    new Label{ text = "Constitution : " + player.combinedConstitution }
  
  var intelligenceLabel : Label = 
    new Label{ text = "Intelligence : " + player.combinedIntelligence }
  
  var strengthLabel     : Label = 
    new Label{ text = "Strength : " + player.combinedStrength }

  var nameLabel         : Label = 
    new Label{ text = "Name : " }

  var nameEdit          : TextField = new TextField()

  var namePanel = new BoxPanel(Orientation.Vertical) {
    contents ++= List(nameLabel, nameEdit)
  }

  var statsList : Array[Component] = 
    Array[Component](namePanel, constitutionLabel, 
                     intelligenceLabel, strengthLabel)

  /* UI Setup start */
  title = "Create your character" 
  modal = true

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

  /* Reactions */
  listenTo(radios:_*)
  listenTo(ok, cancel)
  reactions += {
    case ButtonClicked(b) => 
      b.text match {
        case `okText`      => reactOnOk
        case `cancelText`  => reactOnCancel
        case `fighterText` => chooseFighter
        case `wizardText`  => chooseWizard
        case `rogueText`   => chooseRogue
      }
  }

  /* End Reactions */ 

  private def chooseFighter { player = new Fighter(); update }
  private def chooseWizard  { player = new Wizard();  update }
  private def chooseRogue   { player = new Rogue();   update }

  /** 
   * The reaction to do on an ok click
   */
  private def reactOnOk {
    modal = false 
  }
  
  /** 
   * The reaction to do on a cancel click
   */
  private def reactOnCancel {
  }

  private def update {
    println("update")
    constitutionLabel.text = "Constitution : " + player.combinedConstitution
    strengthLabel.text     = "Strength : "     + player.combinedStrength
    intelligenceLabel.text = "Intelligence : " + player.combinedIntelligence
  }

  /**
   * Method to check if all the form conditions have been satisfied. In this
   * case if the user has chosen a class, and has given the character a name
   * longer than 3 characters
   * @note We can use Scala's Unit here in order to feed these predicates as
   *   parameters and actions to perform as well. Hence this behaviour can be
   *   later on extracted as a trait. 
   */
  private def satisfiedFormConditions {
  }

  centerOnScreen()
  open()
}

