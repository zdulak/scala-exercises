import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatest.prop.TableDrivenPropertyChecks._

class CesarCipherSpec extends AnyFlatSpec with should.Matchers {
  behavior of "CesarCipher.cesar"

  it should "return a string with each letter of the input string Caesar shifted by the given offset" in {
    val args = Table(
      ("string", "offset", "result"),
      ("a", 1, "b"),
      ("abcz", 1, "bcda"),
      ("irk", 13, "vex"),
      ("fusion", 6, "layout"),
      ("dailyprogrammer", 6, "jgorevxumxgsskx"),
      ("jgorevxumxgsskx", 20, "dailyprogrammer")
    )

    forAll(args) {
      (str, offset, result) => CaesarCipher.cesar(str, offset) shouldBe result
    }
  }
}
