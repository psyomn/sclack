package sclack.ui.widgets

import javax.swing.border.EmptyBorder
import javax.swing.ImageIcon
import java.awt.Dimension
import swing._
import swing.event._
import scala.swing._
import Array._

import sclack.domain.Rogue

/** 
 * This is where all the stats information of the character are put, along with
 * dialogs in order to add equipment, use items, etc.
 * 
 * @author Simon Symeonidis 
 */
object StatsWidget extends BorderPanel {

  val characterStats = new BoxPanel(Orientation.Vertical){
  }

  /**
   * @note Thank to 
   *   http://www.scala-lang.org/old/node/2896 for explaining the cryptic use
   *   of tabbed panes in scala-swing ... 
   */
  val tabs : TabbedPane = new TabbedPane {
    pages += new TabbedPane.Page("Stats", new StatsView(new Rogue()))
    pages += new TabbedPane.Page("Inventory", new Label{text= "Inventory"})
  }

  /* Widget Dimensions */
  preferredSize = new Dimension(400,100)
  maximumSize   = new Dimension(400,100)
  minimumSize   = new Dimension(400,100)
  border        = new EmptyBorder(10,10,10,10)

  /* Add the components here */
  import BorderPanel.Position._
  layout(tabs)          = Center
  layout(ActionButtons) = South
  
}
