package sclack.domain

import javax.swing.ImageIcon
import java.awt.image.BufferedImage

/** 
 * Create npcs that say random stuff when you talk to them this way. 
 * 
 * @author Simon Symeonidis 
 */
class NonPlayableCharacter(speech: String, ico: BufferedImage) 
      extends Entity with Demonstratable {
  def observe     = speech
  def demonstrate = ico
}

