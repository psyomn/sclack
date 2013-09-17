package sclack.domain.factories

import sclack.domain.{Character, Fighter, Wizard, Rogue}

/** 
 * Factory class that helps create Characters, because the creation is a
 * complex process.
 * 
 * @author Simon Symeonidis 
 */

object CharacterFactory  {
  /** Create a wizard with random stats */
  def createWizard : Wizard = {
    var wizard = new Wizard()
    return wizard
  }

  /** Create a fighter with random stats */
  def createFighter : Fighter = {
    var fighter = new Fighter()
    return fighter
  }

  /** Create a rogue with random stats */
  def createRogue : Rogue = {
    var rogue = new Rogue
    return rogue
  }
}
