package sclack.domain

/** 
 * An entity may be anything on the map.
 * @author Simon Symeonidis
 */
trait Entity {
  /** Position on the map */
  var position_x : Int = -1

  /** Position on the map */
  var position_y : Int = -1

  /** @return a String that describes what the entity looks like */
  def observe : String
}

