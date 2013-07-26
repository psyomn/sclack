package sclack.ui

import javax.swing.ImageIcon
import java.awt.Dimension
import swing._
import swing.event._
import scala.swing._

import sclack.ui.widgets.{InfoWidget, StatsWidget, WorldWidget}

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

  /** Thanks to http://vimeo.com/13900342 (Ken Scambler) */
  contents = new BorderPanel{
    import BorderPanel.Position._
    layout(StatsWidget) = East
    layout(WorldWidget) = Center
    layout(InfoWidget)  = South
  }

  centerOnScreen()
  open()
}


