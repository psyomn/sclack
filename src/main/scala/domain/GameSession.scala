package sclack.domain

/** 
 * Encapsulate the information for a single game session
 * @author Simon Symeonidis
 */
class GameSession {
  /** The profile of the user */
  var user       : User = _

  /** The characters that the user has */
  var characters : Array[Character] = new Array[Character](3)

  /** The seed of the current world */
  var seed       : Long = -1

  /** The world that the user interacts with */
  var world      : World = _ 
}
