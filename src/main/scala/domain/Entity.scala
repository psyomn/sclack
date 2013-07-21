package sclack.domain

/** 
 * An entity may be anything on the map.
 * @author Simon Symeonidis
 */
trait Entity {
  var position_x : Int = -1
  var position_y : Int = -1
  def observe : String
}

