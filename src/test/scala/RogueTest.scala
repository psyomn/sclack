import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter

import sclack.domain.{Rogue, Character}
import sclack.testing.Common

/** 
 * The test suite for the Rogue class 
 * @author Simon Symeonidis
 */
class RogueTest extends FunSpec with BeforeAndAfter{
  
  var rogue : Rogue = _

  before {
    rogue = new Rogue()
  }

  describe("Rogue traits") {
    it("should be an instance of Character") {
      assert(rogue.isInstanceOf[Character])
    }

    it("should be observable") {
      assert(Common.hasMethod("observe", rogue))
    }
    
    it("should be demonstratable") {
      assert(Common.hasMethod("demonstrate", rogue))
    }
  }

  /* Whatever attributest the rogue has, eg hp, mp etc */
  describe("Rogue attributes") {
  }
}
