package Day0
import org.specs2.specification.Scope
import org.specs2.mutable.Specification
import org.specs2.execute._

object Day0Spec extends Specification {

  "Day0 functions should" should {
    import Day0Stuff.Stuff._

    "Should add two strings together" in {
      sum(List("test", "ing")) === "testing"
    }

    "Should add two integers together" in {
      sum(List(1,2,3,4,5)) === 15
    }

    "Should use new operator to add ints" in {
      (1 |+| 3) === 4
    }
  }
}
