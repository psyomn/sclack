package sclack.domain

/** 
 * Create npcs that say random stuff when you talk to them this way. 
 * 
 * @author Simon Symeonidis 
 */
class NonPlayableCharacter(speech: String) extends Entity {
  def observe = speech
}

