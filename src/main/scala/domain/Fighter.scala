package sclack.domain

/** 
 * A fighter class that is proficient in melee combat.
 * @author Simon Symeonidis
 */
class Fighter extends Character {
  def combinedStrength = strength + 5
  def combinedIntelligence = intelligence - 3
  def combinedConstitution = constitution + 2
  def combinedDexterity = dexterity + 1
}

