import javax.swing.ImageIcon

/** 
 * This trait is purely for the gui aspect of things. If something is
 * demonstratable then there exists (or at least should exist) a valid name
 * of the tileset, and an id which can be used to map to that particular 
 * graphical region.
 * 
 * @author Simon Symeonidis 
 */
trait Demonstratable {
  def demonstrate : ImageIcon
}
