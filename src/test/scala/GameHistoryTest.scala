import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter

import sclack.domain.GameHistory
import sclack.testing.Common

/** 
 * The test suite for the GameHistory class 
 * @author Simon Symeonidis
 */
class GameHistoryTest extends FunSpec with BeforeAndAfter{
  
  var history : GameHistory = _

  describe("GameHistory") {
    before {
      history = new GameHistory()
      for (i <- List.range(1, 200)) history.log("his : " + i)
    }

    it("should only contain a maximum of 100 logs"){
      assert(history.count == 100)
    }
  }
  
}
