import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter

import sclack.domain.Die
import sclack.testing.Common

/** 
 * The test suite for the die class 
 * @author Simon Symeonidis
 */
class DieTest extends FunSpec with BeforeAndAfter{
  
  var die : Die = _

  before {
    die = new Die(6)
  }

  /* Whatever attributest the fighter has, eg hp, mp etc */
  describe("Die") {
    describe("attributes") {
      it("should have a roll method") {
        assert(Common.hasMethod("roll", die))
      }
    }
  }
}
