package sclack.ui

import javax.swing.ImageIcon
import javax.swing.border.EmptyBorder
import java.awt.Dimension
import swing._
import swing.event._
import scala.swing._

/* lib */
import sclack.domain.{Character, Rogue, Fighter, Wizard, GameSession}
import sclack.tech.TileManager

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

  val radioClasses : Array[String]      = 
    Array(wizardText, fighterText, rogueText)

  var thelp = TileManager

  var radioGroup   : ButtonGroup        = null
  var radios       : Array[RadioButton] = new Array[RadioButton](0)
  var radioPanel   : BoxPanel           = new BoxPanel(Orientation.Horizontal)
  var ok           : Button             = new Button{ text = okText; enabled = false}
  var cancel       : Button             = new Button{ text = cancelText }
  var characterIco : Label              = new Label{ icon = new ImageIcon(thelp.tile("dun",1)) }

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

  val namePanel = new BoxPanel(Orientation.Vertical) {
    nameEdit.maximumSize = new Dimension(250, 20)
    contents ++= List(nameLabel, nameEdit)
  }

  var statsList : Array[Component] = 
    Array[Component](namePanel, constitutionLabel, 
                     intelligenceLabel, strengthLabel)

  /* UI Setup start */
  title = "Create your character" 
  modal = true

  preferredSize = new Dimension(300,200)
  maximumSize   = new Dimension(300,200)
  minimumSize   = new Dimension(300,200)

  /* Make the radios */

  val bottomButtons = new BoxPanel(Orientation.Horizontal) {
    contents += ok
    contents += cancel
  }

  val classRadios = new BoxPanel(Orientation.Horizontal) {
    for (rc <- radioClasses) radios :+= new RadioButton(rc)
    radioGroup = new ButtonGroup(radios:_*)
    radioGroup.select(radios.head)
    contents ++= radios
  }

  val buttonsAndRadios = new BoxPanel(Orientation.Vertical) {
    contents += classRadios
    contents += bottomButtons
  }

  val statsLabels = new BoxPanel(Orientation.Vertical){
    maximumSize = new Dimension(200,400)
    minimumSize = new Dimension(200,200)
    preferredSize = new Dimension(200,200)
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
  listenTo(ok, cancel, nameEdit)
  reactions += {
    case ButtonClicked(b) => 
      b.text match {
        case `okText`      => reactOnOk
        case `cancelText`  => reactOnCancel
        case `fighterText` => chooseFighter
        case `wizardText`  => chooseWizard
        case `rogueText`   => chooseRogue
      }
    case _ => satisfiedFormConditions
  }

  /* End Reactions */ 

  /** Switch character, and change graphics */
  private def chooseFighter { 
    player = new Fighter()
    characterIco.icon = new ImageIcon(thelp.tile("dun",1))
    update
  }
  
  /** Switch character, and change graphics */
  private def chooseWizard  { 
    player = new Wizard()
    characterIco.icon = new ImageIcon(thelp.tile("dun",2))
    update 
  }

  /** Switch character, and change graphics */
  private def chooseRogue   { 
    player = new Rogue()
    characterIco.icon = new ImageIcon(thelp.tile("dun",3))
    update 
  }

  /** 
   * The reaction to do on an ok click
   * TODO GameSession object should be created here
   */
  private def reactOnOk {
    var session = new GameSession() 

    session.character = player
    session.map.mainChar = player 
    dispose

    val gameUI = new GameUI(session)
  }
  
  /** 
   * The reaction to do on a cancel click
   */
  private def reactOnCancel {
    dispose
  }

  /** 
   * Update the information on here
   */
  private def update {
    constitutionLabel.text = "Constitution : " + player.combinedConstitution
    strengthLabel.text     = "Strength : "     + player.combinedStrength
    intelligenceLabel.text = "Intelligence : " + player.combinedIntelligence
  }

  /**
   * Method to check if all the form conditions have been satisfied. In this
   * case if the user has chosen a class, and has given the character a name
   * longer than 3 characters
   * 
   * @note We can use Scala's Unit here in order to feed these predicates as
   *   parameters and actions to perform as well. Hence this behaviour can be
   *   later on extracted as a trait. 
   */
  private def satisfiedFormConditions {
    ok.enabled = nameEdit.text.length >= 3 
  }

  centerOnScreen()
  open()
}

