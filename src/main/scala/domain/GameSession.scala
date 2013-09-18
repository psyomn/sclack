package sclack.domain

import sclack.domain.factories.MapFactory

/** 
 * Encapsulate the information for a single game session
 * @author Simon Symeonidis
 */
class GameSession {
  /** The profile of the user. We're not really using this at the moment */
  var user       : User = _

  /** The characters that the user has */
  var characters : Array[Character] = new Array[Character](3)

  /** The seed of the current world */
  var seed       : Long = -1

  /** The world that the user interacts with. If we were to implement the
      application fully, then we would be using this. But for now we just
      use a single map */
  var world      : World = _ 

  /** The map that the game takes place on */
  var map        : Map   = MapFactory.createSingleMap
}
