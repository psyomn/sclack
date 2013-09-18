package sclack.domain

import javax.swing.ImageIcon

/** 
 * Create npcs that say random stuff when you talk to them this way. 
 * 
 * @author Simon Symeonidis 
 */
class NonPlayableCharacter(speech: String, ico: ImageIcon) extends Entity with Demonstratable {
  def observe     = speech
  def demonstrate = null
}

