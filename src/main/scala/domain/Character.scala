package sclack.domain

/** 
 * Characters are the in game characters that you can use (for example fighters
 * wizards, rogues etc).
 * 
 * @author Simon Symeonidis
 */
abstract class Character extends Entity with Observable with Demonstratable{

  def observe = "Default implementation"

  def demonstrate = null

  /** Hitpoints are the current life of the character */
  var hitpoints    : Int = 10

  /** Constitution is the max life of the character */
  var constitution : Int = 10

  /** Intelligence of the character */
  var intelligence : Int = 5

  /** Current magic points of the character */
  var magicPoints  : Int = 0

  /** Strength of the character */ 
  var strength     : Int = 1

  /** Dexterity */
  var dexterity    : Int = 1

  /** Skillpoints that may be used in order to improve stats */
  var skillpoints  : Int = 0

  /** Somewhat cosmetic thing that shows us the current level */
  var level        : Int = 1

  /** The experience points of the character */ 
  var experience   : Int = 0

  /** TODO maybe some other formula for this one */
  def levelUp {
    skillpoints += 2 * level
  }
  
  def improveConstitution = increaseConstitution
  def improveIntelligence = increaseIntelligence
  def improveStrength     = increaseStrength
  
  /** Class + Armor combination for stat */
  def combinedStrength : Int
  
  /** Class + Armor combination for stat */
  def combinedIntelligence : Int
  
  /** Class + Armor combination for stat */
  def combinedConstitution : Int

  /** Class + Armor combination for stat */
  def combinedDexterity : Int

  private def increaseStrength { 
    if (enoughSkillpoints(strength)){
      skillpoints -= strength
      strength    += 1
    }
  }

  private def increaseIntelligence {
    if (enoughSkillpoints(intelligence)){
      skillpoints  -= intelligence
      intelligence += 1
    }
  }
  
  private def increaseConstitution {
    if (enoughSkillpoints(constitution)){
      skillpoints  -= constitution
      constitution += 1
    }
  }

  private def enoughSkillpoints(abilityAmount : Int) : Boolean = 
    skillpoints >= abilityAmount;
      
}
