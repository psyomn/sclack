package sclack.ui

import javax.swing.ImageIcon
import java.awt.Dimension
import swing._
import swing.event._
import scala.swing._

import sclack.domain.commands.{CreateNewGame, DeleteGame, LoadGame}

/** 
 * The main menu of the application. This is where the user specifies whether
 * we want a new game, to load a game, or to delete a game.
 * @author Simon Symeonidis 
 */
object MainMenu extends SimpleSwingApplication {

  val newGameText      = "New Game" 
  val loadGameText     = "Load Game" 
  val deleteGameText   = "Delete Game"
  val resourceDir      = getClass.getResource("/title.png")

  var newGameButton    = new Button {text = newGameText}
  var loadGameButton   = new Button {text = loadGameText}
  var deleteGameButton = new Button {text = deleteGameText}
  var logoIcon         = new ImageIcon(resourceDir)
  var labelIcon        = new Label{icon = logoIcon}

  def top = new MainFrame {
    title            = "Sclack v" + Sclack.version 

    contents = new BoxPanel(Orientation.Vertical){ 
      contents += labelIcon
      contents += newGameButton
      contents += loadGameButton
      contents += deleteGameButton
    }
  }

  listenTo(newGameButton, loadGameButton, deleteGameButton)
  reactions += {
    case ButtonClicked(b) => 
      b.text match {
         case `newGameText`    =>
           
         case `loadGameText`   =>
         case `deleteGameText` =>
      }
  }
}
