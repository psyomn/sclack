package sclack.testing

import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter

import sclack.domain.Character

/** 
 * Testing basic stuff for the character class 
 * @author Simon Symeonidis
 */

class CharacterTest extends FunSpec with BeforeAndAfter {

  var character : Character = _
  before {
    character = new Character()
    character.skillpoints = 100
  }

  describe("Character") {
    describe("skillpoints") {
      describe("should decrease by the amount of points assigned to") {
        it("constitution"){
	  character.improveConstitution
	  assert(character.skillpoints == 90)
	}
	it("intelligence"){
	  character.improveIntelligence
	  assert(character.skillpoints == 95)
	}
	it("strength"){
	  character.improveStrength
	  assert(character.skillpoints == 99)
	}
      }
    }

    describe("abilities"){
      describe("improvements"){ 
        it("should increase by one for constitution"){
	  var old = character.constitution
	  character.improveConstitution
          assert(old + 1 == character.constitution)
	}
        it("should increase by one for strength"){
	  var old = character.strength
	  character.improveStrength
	  assert(old + 1 == character.strength)
	}
        it("should increase by one for intelligence"){
	  var old = character.intelligence
	  character.improveIntelligence
	  assert(old + 1 == character.intelligence)
	}
      }
    }
  }

}
