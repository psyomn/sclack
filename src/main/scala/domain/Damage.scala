package sclack.domain

import sclack.domain.Element._

/** 
 * Class that represents damage to be dealt between enemies.
 * @author Simon Symeonidis
 */       
class Damage(amount: Int, element: Element){
  def amt = amount
  def elmnt = element
}
