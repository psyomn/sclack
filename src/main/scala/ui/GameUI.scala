package sclack.ui

import javax.swing.ImageIcon
import java.awt.Dimension
import swing._
import swing.event._
import scala.swing._

/**
 * Main game user interface
 * 
 * @see    DeleteGame
 * @see    LoadGame
 * @author Simon Symeonidis
 */
class GameUI extends Dialog {
  title = "SCLACK! SCLACK! SCLACK!"
  modal = true

  contents = new BoxPanel(Orientation.Vertical){
    contents += new Button { text = "orly??" }
  }

  centerOnScreen()
  open()
}


