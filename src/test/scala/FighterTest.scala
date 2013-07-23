import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter

import sclack.domain.{Fighter, Character}
import sclack.testing.Common

/** 
 * The test suite for the Fighter class 
 * @author Simon Symeonidis
 */
class FighterTest extends FunSpec with BeforeAndAfter{
  
  var fighter : Fighter = _

  before {
    fighter = new Fighter()
  }

  describe("Fighter traits") {
    it("should be an instance of Character") {
      assert(fighter.isInstanceOf[Character])
    }

    it("should be observable") {
      assert(Common.hasMethod("observe", fighter))
    }
    
    it("should be demonstratable") {
      assert(Common.hasMethod("demonstrate", fighter))
    }
  }

  /* Whatever attributest the fighter has, eg hp, mp etc */
  describe("Fighter attributes") {
  }
}
