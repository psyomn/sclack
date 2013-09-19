package sclack.ui.widgets

import javax.swing.border.EmptyBorder
import javax.swing.ImageIcon
import java.awt.Dimension
import swing._
import swing.event._
import scala.swing._
import GridBagPanel._
import Array._

/** 
 * The buttons that will help to do different actions  
 *
 * @author 
 */ 
object ActionButtons extends GridBagPanel {
  val buttonsCaptions : Array[String] = Array[String](
    "?",      "/\\",    "?", 
    "<",      "center", ">",
    "Attack", "V",      "Observe")

  val buttCapNorth    = buttonsCaptions(1)
  val buttCapSouth    = buttonsCaptions(7)
  val buttCapEast     = buttonsCaptions(5)
  val buttCapWest     = buttonsCaptions(3)
  val buttCapAttack   = buttonsCaptions(6)
  val buttCapObserve  = buttonsCaptions(8)
  val buttCapCenter   = buttonsCaptions(4)
  val buttCapSpecial1 = buttonsCaptions(0)
  val buttCapSpecial2 = buttonsCaptions(2)

  val constraints = new Constraints
  var ix = 0
  var iy = 0 

  val buttons : Array[Button] = buttonsCaptions.map(new Button(_))

  /** Add the action buttons to the layout */
  constraints.fill = Fill.Horizontal
  for(x <- 0 to 8) {
    constraints.gridx = x % 3
    constraints.gridy = (x / 3.0).toInt
    add(buttons(x), constraints) 
  }

  listenTo(buttons:_*)
  reactions += {
    case ButtonClicked(b) => 
      b.text match {
        case `buttCapSpecial1` => reactSpecial1
        case `buttCapSpecial2` => reactSpecial2
        case `buttCapNorth`    => reactNorth
        case `buttCapWest`     => reactWest
        case `buttCapCenter`   => reactCenter
        case `buttCapEast`     => reactEast
        case `buttCapAttack`   => reactAttack
        case `buttCapSouth`    => reactSouth
        case `buttCapObserve`  => reactObserve
      }
  }

  private def reactNorth = println("up")
  private def reactSouth =println("down")
  private def reactEast =println("east")
  private def reactWest =println("west")
  private def reactCenter =println("center")
  private def reactAttack =println("attack")
  private def reactObserve =println("observe")
  private def reactSpecial1 =println("spec1")
  private def reactSpecial2 =println("spec2")
}
