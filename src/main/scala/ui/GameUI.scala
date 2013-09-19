package sclack.ui

import javax.swing.ImageIcon
import java.awt.Dimension
import swing._
import swing.event._
import scala.swing._

import sclack.ui.widgets.{InfoWidget, StatsWidget, WorldWidget,
                          ActionButtons}
import sclack.domain.GameSession

/**
 * Main game user interface.
 * 
 * @see    DeleteGame
 * @see    LoadGame
 * @author Simon Symeonidis
 */
class GameUI(sess: GameSession) extends Dialog {
  title = "SCLACK! SCLACK! SCLACK!"
  modal = true

  var session = sess

  /** Thanks to http://vimeo.com/13900342 (Ken Scambler) */
  contents = new BorderPanel{
    import BorderPanel.Position._

    /* Some standard initializement */
    WorldWidget.currMap   = session.map
    ActionButtons.session = session

    /* Add the components to the main ui layout */
    layout(StatsWidget) = East
    layout(WorldWidget) = Center
    layout(InfoWidget)  = South
  }

  centerOnScreen()
  open()
}

