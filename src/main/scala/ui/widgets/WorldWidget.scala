package sclack.ui.widgets

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

  /** 
   * Draw the required stuff on screen by overidding
   * whatever else might have been needed...
   */ 
  override def paint(g: Graphics2D) {
    g.draw(new Line2D.Double(0,0,10,10));
  }
}
