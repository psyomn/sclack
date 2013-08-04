package sclack.domain.commands

import sclack.domain.GameSession
import sclack.domain.Character

/**
 * Create new game command. This should create a new game, and return the 
 * GameSession object
 * @author Simon Symeonidis
 */
class CreateNewGame(character : Character) extends Commandable {
  def execute {
    gameSession = new GameSession()
  }

  var gameSession : GameSession = _
}
