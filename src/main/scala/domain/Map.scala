package sclack.domain

/**
 * A map is a smaller part of the World object.
 *
 * @author Simon Symeonidis 
 * @see World
 */ 
class Map {

  def at(x: Int, y: Int) = data(x)(y)

  def width  : Int = data.head.length

  def height : Int = data.length

  var data : Array[Array[Int]] = Array.fill[Int](25,25){4}

  var obstructions = Array.fill[Int](25,25){0}

  var entities : Array[(Int, Int, NonPlayableCharacter)] = _
}
