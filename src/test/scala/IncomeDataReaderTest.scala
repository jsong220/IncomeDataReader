import IncomeDataReader._
import org.scalatest._

class IncomeDataReaderTest extends org.scalatest.funsuite.AnyFunSuite {
  test("IncomeDataReader.toInt(stringInt)") {
    assert(IncomeDataReader.toInt("1").getOrElse(0) === 1)
    // assert("One" === "One")
  }

  test("IncomeDataReader.toInt(numString)") {
    assert(IncomeDataReader.toInt("One").getOrElse(0) === 0)
    // assert("One" === "One")
  }

  test("IncomeDataReader.toInt(blank)") {
    assert(IncomeDataReader.toInt("").getOrElse(0) === 0)
    // assert("One" === "One")
  }

  test("IncomeDataReader.toInt(gibberish)") {
    assert(IncomeDataReader.toInt("shdjkfhskj").getOrElse(0) === 0)
    // assert("One" === "One")
  }

    test("IncomeDataReader.toInt(failTest)") {
    assert(IncomeDataReader.toInt("IshouldFail").getOrElse(0) === 1)
    // assert("One" === "One")
  }
}
