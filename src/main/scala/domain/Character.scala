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
  var hitpoints    : Int = 10

  /** Constitution is the max life of the character */
  var constitution : Int = 10

  /** Intelligence of the character */
  var intelligence : Int = 5

  /** Current magic points of the character */
  var magicPoints  : Int = 0

  /** Strength of the character */ 
  var strength     : Int = 1

  /** Skillpoints that may be used in order to improve stats */
  var skillpoints  : Int = 0;

  /** Somewhat cosmetic thing that shows us the current level */
  var level        : Int = 1;

  /** The experience points of the character */ 
  var experience   : Int = 0;

  /** TODO maybe some other formula for this one */
  def levelUp {
    skillpoints += 2 * level
  }
  
  def improveConstitution = improve("constitution")
  def improveIntelligence = improve("intelligence")
  def improveStrength     = improve("strength")

  /**
   * Improve one of the character's ability by using the skillpoints 
   */
  def improve(ability: String){
    ability match { 
      case "constitution" => increaseConstitution
      case "intelligence" => increaseIntelligence
      case "strength"     => increaseStrength
    }
  }

  def increaseStrength { 
    if (enoughSkillpoints(strength)){
      skillpoints -= strength
      strength    += 1
    }
  }

  def increaseIntelligence {
    if (enoughSkillpoints(intelligence))
      skillpoints  -= intelligence
      intelligence += 1
  }
  
  def increaseConstitution {
    if (enoughSkillpoints(constitution))
      skillpoints  -= constitution
      constitution += 1
  }

  def enoughSkillpoints(abilityAmount : Int) : Boolean = {
    if (skillpoints >= abilityAmount) {
      return true;
    }
    else {
      throw new SclackException("Not enough skillpoints to increase ability");
    }
  }
      
}
