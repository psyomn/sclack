package sclack.domain

/** 
 * Class that encapsulates the behaviour of a badass wizard. The wizard is 
 * wimpy, but wait until he casts his spells!
 * @author Simon Symeonidis
 */
class Wizard extends Character {
  def combinedStrength = strength - 1
  def combinedIntelligence = intelligence + 5
  def combinedConstitution = constitution - 1
  def combinedDexterity = dexterity - 1
}
