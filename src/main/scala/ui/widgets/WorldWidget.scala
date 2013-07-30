package sclack.ui.widgets

import javax.swing.border.EmptyBorder
import javax.swing.ImageIcon
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.geom.Line2D
import swing._
import swing.event._
import scala.swing._

/** 
 * This is the widget where the world is demonstrated upon. Whatever happens to
 * the domain version of the world should be represented here.
 * 
 * @author Simon Symeonidis 
 */
object WorldWidget extends Panel {
  var graphics : Graphics2D = null

  preferredSize = new Dimension(400,400)
  maximumSize   = new Dimension(400,400)
  minimumSize   = new Dimension(400,400)
  border        = new EmptyBorder(10,10,10,10)

  /** 
   * Draw the required stuff on screen by overidding
   * whatever else might have been needed...
   */ 
  override def paint(g: Graphics2D) {
    g.draw(new Line2D.Double(0,0,400,400));
  }
}
