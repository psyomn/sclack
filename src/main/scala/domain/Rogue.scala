package sclack.domain

/**
 * Rogues are the Ninjas of the fantasy world! Better not make one angry, or 
 * you won't be sleeping alone tonight...
 * @author Simon Symeonidis
 */
class Rogue extends Character {
  override def observe = "You see a ninja like person"
  def combinedStrength = strength + 1
  def combinedIntelligence = intelligence + 3
  def combinedConstitution = constitution + 1
  def combinedDexterity = dexterity + 10
}

