import org.scalatest.FunSpec

/** 
 * Just leave this here so I remember what a specification file looks like in
 * Scalatest.
 * @author Simon Symeonidis
 */
class SanityTest extends FunSpec {
  describe("Sanity") {
    it("should be ok...?") {
      assert(1 == 1)
    }
  }
}
