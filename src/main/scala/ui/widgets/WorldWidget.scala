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
  /** The current map that we wish to render. */
  var currMap : sclack.domain.Map = _

  var tileMan = TileManager

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

    drawMap(g)
    drawNPCs(g)
    drawPlayer(g)
    
    g.finalize()
  }
 
  /* Isolate drawing logic for maps */
  private def drawMap(g: Graphics2D) {
    /* Should be done in a better way... */
    val width  = currMap.width  - 1
    val height = currMap.height - 1
    var currentTile : Int = 0

    for (i <- 0 to height){
      for (j <- 0 to width){
        currentTile = (height + 1) * i + j
        g.drawImage(
          tileMan.tile("fan", 
          currMap.at(i,j)), /* What to draw */ 
          j * 16, i * 16, null)
      }
    }
  }

  /* Isolate drawing logic for maps */
  private def drawNPCs(g: Graphics2D) {
    for (ent <- currMap.entities){
      g.drawImage(ent._3.demonstrate, ent._1, ent._2, null)
    }
  }

  /* For drawing the main player on the map */
  private def drawPlayer(g: Graphics2D) {
     g.drawImage(
       currMap.mainChar.demonstrate, 
       currMap.mainCharPos._1 * 16,
       currMap.mainCharPos._2 * 16,
       null)
  }
}

