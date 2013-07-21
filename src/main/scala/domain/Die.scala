package sclack.domain

import scala.util.Random

/**
 * A die class to be used in conjuction with attacks, spells, etc.
 * specifications
 * @author Simon Symeonidis 
 */
class Die(sides: Int){

  /**
   * Roll the dice 
   * @return A random number based on the number of sides specified
   */
  def roll = random.nextInt.abs % sides + 1

  /** Delegate randomness to random random object.*/
  val random = new Random()
}

