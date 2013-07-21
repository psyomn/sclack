package sclack.ui

import java.awt.Dimension
import swing._
import swing.event._

/** 
 * The main menu of the application. This is where the user specifies whether
 * we want a new game, to load a game, or to delete a game.
 * @author Simon Symeonidis 
 */
object MainMenu extends SimpleSwingApplication {
  def top = new MainFrame {
   title = "Sclack v" + Sclack.version 
   contents = new Button {text = "New Game"}
  }
}
