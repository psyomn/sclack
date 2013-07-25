package sclack.testing

import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter

import sclack.domain.Damage
import sclack.domain.Element._
import sclack.testing.Common

/** 
 * The test suite for the damage class 
 * @author Simon Symeonidis
 */
class DamageTest extends FunSpec with BeforeAndAfter{
  
  var damage : Damage = _

  before {
    damage = new Damage(10, fire)
  }

  /* Whatever attributest the fighter has, eg hp, mp etc */
  describe("Damage attributes") {
    it("should have an amnt method") {
      assert(Common.hasMethod("amt", damage))
    }
    it("should have an elmnt method") {
      assert(Common.hasMethod("elmnt", damage))
    }
    it("should be of type fire") {
      assert(damage.elmnt == fire)
    }
  }
}
