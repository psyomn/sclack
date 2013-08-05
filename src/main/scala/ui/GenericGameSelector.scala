package sclack.ui

import javax.swing.ImageIcon
import java.awt.Dimension
import swing._
import swing.event._
import scala.swing._
import scala.collection.mutable.ListBuffer

import sclack.domain.commands.Commandable

/**
 * Generic menu to choose a game to load or delete (those UIs should delegate
 * or inherit from this class). 
 *
 * @see    DeleteGame
 * @see    LoadGame
 * @author Simon Symeonidis
 * @note thanks to http://stackoverflow.com/questions/6809305 for listbuffer
 *   and listview usage
 */
class GenericGameSelector(actionName: String, command: Commandable) extends Dialog {
 
  val chooseButton  = new Button{text = actionName}

  val gameListLabel = new Label{text = "Games:"}

  val gameList      = new ListBuffer[String]()
    gameList.appendAll(List("Savegame 1", "Savegame 2", "Savegame 3"))

  val gameListView  = new ListView[String](gameList)

  var components : Array[Component] = 
    Array(gameListLabel, gameListView, chooseButton)

  title = "Choose game to " + actionName 
  modal = true

  /* Widget Dimensions */
  preferredSize = new Dimension(300,300)
  maximumSize   = new Dimension(300,300)
  minimumSize   = new Dimension(300,300)

  contents = new BoxPanel(Orientation.Vertical) {
    contents ++= components
  }

  listenTo(chooseButton)
  reactions += {
    case ButtonClicked(b) =>
      b.text match {
        case `actionName` => command.execute
      }
  }

  centerOnScreen()
  open()
}

