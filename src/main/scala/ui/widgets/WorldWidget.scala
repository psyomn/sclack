package sclack.ui.widgets

import javax.swing.border.EmptyBorder
import javax.swing.ImageIcon
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.geom.Line2D
import swing._
import swing.event._
import scala.swing._

import sclack.tech.TileManager

/** 
 * This is the widget where the world is demonstrated upon. Whatever happens to
 * the domain version of the world should be represented here.
 * 
 * @author Simon Symeonidis 
 */
object WorldWidget extends Panel {
  preferredSize = new Dimension(400,400)
  maximumSize   = new Dimension(400,400)
  minimumSize   = new Dimension(400,400)
  border        = new EmptyBorder(10,10,10,10)

  /** 
   * Draw the required stuff on screen by overidding
   * whatever else might have been needed...
   */ 
  override def paint(g: Graphics2D) {
    import scala.util.Random 
    var rand = new Random()

    var tm = TileManager
    
    for (i <- 0 to 25){
      for (j <- 0 to 25){
        g.drawImage(tm.tile("fan", 1 + rand.nextInt.abs % 10),i*16,j*16,16,16,null)
      }
    }

    g.finalize()
  }
}
