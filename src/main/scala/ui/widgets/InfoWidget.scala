package sclack.ui.widgets

import javax.swing.border.EmptyBorder
import javax.swing.ImageIcon
import java.awt.Dimension
import swing._
import swing.event._
import scala.swing._

/** 
 * The info widget of the main window. The user may read information about what
 * the character is doing more precisely in the text displayed in this widget. 
 * There are other facilities available in order to make this more usable 
 * (clear text etc) 
 * 
 * @author Simon Symeonidis 
 */
object InfoWidget extends BorderPanel {
  val tmpButts : Array[String] = Array("Clear", "Derp", "Herp", "Derpa")
  val buttons = new BoxPanel(Orientation.Horizontal) {
    for (s <- tmpButts)
      contents += new Button{ text = s }
  }

  preferredSize = new Dimension(600,200)
  maximumSize   = new Dimension(600,200)
  minimumSize   = new Dimension(600,200)
  border        = new EmptyBorder(10,10,10,10)

  val infoList : ListView[String] = new ListView[String]
  infoList.fixedCellHeight = 100
  infoList.fixedCellWidth  = 100

  import BorderPanel.Position._
  layout(infoList) = Center
  layout(buttons)  = South
}

