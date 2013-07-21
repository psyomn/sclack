package sclack.domain

/** 
 * Characters are the in game characters that you can use (for example fighters
 * wizards, rogues etc).
 * 
 * @author Simon Symeonidis
 */
class Character extends Entity with Observable with Demonstratable{

  def observe = "Default implementation"

  def demonstrate = null

  /** Hitpoints are the current life of the character */
  var hitpoints    = 10

  /** Constitution is the max life of the character */
  var constitution = 10

  /** Intelligence of the character */
  var intelligence = 10

  /** Current magic points of the character */
  var magicPoints  = 10

}
