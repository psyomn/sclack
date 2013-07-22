package sclack.domain

/** 
 * Encapsulate the information for a single game session
 * @author Simon Symeonidis
 */
class GameSession {
  /** The profile of the user */
  val user       : User = null

  /** The characters that the user has */
  val characters : Array[Character] = null

  /** The seed of the current world */
  val seed       : Long = -1

  /** The world that the user interacts with */
  val world      : World = new World()
}
