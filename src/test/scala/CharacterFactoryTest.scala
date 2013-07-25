package sclack.testing
import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter

import sclack.domain.{Fighter, Rogue, Wizard}
import sclack.domain.factories.CharacterFactory
import sclack.testing.Common

/** 
 * The test suite for the Fighter class 
 * @author Simon Symeonidis
 */
class CharacterFactoryTest extends FunSpec with BeforeAndAfter{
  
  describe("CharacterFactory") {
    it("should create Wizards") {
      assert(CharacterFactory.createWizard
                             .isInstanceOf[Wizard])
    }

    it("should create Fighters") {
      assert(CharacterFactory.createFighter
                             .isInstanceOf[Fighter])
    }
    
    it("should create Rogues") {
      assert(CharacterFactory.createRogue
                             .isInstanceOf[Rogue])
    }
  }

}
