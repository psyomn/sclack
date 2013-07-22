import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter

import sclack.domain.{Wizard, Character}
import sclack.testing.Common

/** 
 * The test suite for the Wizard class 
 * @author Simon Symeonidis
 */
class WizardTest extends FunSpec with BeforeAndAfter{
  
  var wizard : Wizard = _

  before {
    wizard = new Wizard()
  }

  describe("Wizard traits") {
    it("should be an instance of Character") {
      assert(wizard.isInstanceOf[Character])
    }

    it("should be observable") {
      Common.hasMethod("observe", wizard)
    }
    
    it("should be demonstratable") {
      Common.hasMethod("demonstrate", wizard)
    }
  }

  /* Whatever attributest the wizard has, eg hp, mp etc */
  describe("Wizard attributes") {
  }
}
