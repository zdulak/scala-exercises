import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatest.prop.TableDrivenPropertyChecks._

class PartitionCountSpec extends AnyFlatSpec with should.Matchers {
  behavior of " The partitionCount method"

  it should "return number of ways to partition the given number" in {
    val args = Table(
      ("n", "result"),
      (0, 1),
      (1, 1),
      (2, 2),
      (3, 3),
      (4, 5),
      (5, 7),
      (6, 11),
      (7, 15),
      (8, 22),
      (9, 30),
      (10, 42),
      (11, 56)
    )

    forAll(args) {
      (n, result) => PartitionCount.partitionCount(n) shouldBe result
    }
  }

}
