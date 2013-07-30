package sclack.ui.widgets

import javax.swing.border.EmptyBorder
import javax.swing.ImageIcon
import java.awt.Dimension
import swing._
import swing.event._
import scala.swing._
import Array._

/** 
 * This is where all the stats information of the character are put, along with
 * dialogs in order to add equipment, use items, etc.
 * 
 * @author Simon Symeonidis 
 */
object StatsWidget extends BorderPanel {
  val characterStats = new BoxPanel(Orientation.Vertical){
      var myArr = Array("Level", "Name", "Health", "Strength",
                        "Intelligence", "Mana", "Skillpoints", "Experience")
      for (s <- myArr)
        contents += new Label{ text = s }
    }

  val panes : TabbedPane = null

  preferredSize = new Dimension(400,100)
  maximumSize   = new Dimension(400,100)
  minimumSize   = new Dimension(400,100)
  border        = new EmptyBorder(10,10,10,10)

  /* Add the components here */
  import BorderPanel.Position._
  layout(characterStats) = Center
  
}
