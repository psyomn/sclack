import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter

import sclack.tech.TileHelper
import sclack.testing.Common

/** 
 * The test suite for the tilehelper 
 * @author Simon Symeonidis
 */
class TileHelperTest extends FunSpec with BeforeAndAfter{
  
  private val dungeonTilesetName = "/16x16-dungeon-tiles-nes-remake.png"
  private val dungeonTilesetRes  = getClass.getResource(dungeonTilesetName)

  var tileHelper : TileHelper = _

  describe("TileHelper") {
    describe("Attributes"){
      before {
        tileHelper = new TileHelper(16, 16, 0, dungeonTilesetRes)
      }
      it("should include a tile method"){
        assert(Common.hasMethod("tile", tileHelper))
      }
      it("should include a width method"){
        assert(Common.hasMethod("width", tileHelper))
      }
      it("should include a height method"){
        assert(Common.hasMethod("height", tileHelper))
      }
      it("should include a tileset method"){
        assert(Common.hasMethod("tileset", tileHelper))
      }
    }
  }
}
