package sclack.domain

/**
 * A map is a smaller part of the World object.
 *
 * @author Simon Symeonidis 
 * @see World
 */ 
class Map extends Demonstratable with Observable {

  def demonstrate = null

  /**
   * Textual representation of the world.  
   */
  def observe = "You see nothing of interest here."

  var data = Array.fill[Int](25,25){4}

}
