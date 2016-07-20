package org.functionalkoans.forscala

import com.github.ghik.silencer.silent
import org.scalatest.{ FunSuite, Matchers }

// meditate on AboutAsserts to see how the Scala Koans work
class AboutAsserts extends FunSuite with Matchers with KoanMatcher {

  test("asserts can take a boolean argument") {
    assert(false) // should be true
  }

  test("asserts can include a message") {
    assert(false, "This should be true")
  }

  test("true and false values can be compared with should matchers") {
    false should be(true) // should be true
  }

  test("booleans in asserts can test equality") {
    val v1 = 4
    val v2 = 4
    v1 === __ // === is an assert. It is from ScalaTest, not from the Scala language
  }

  test("sometimes we expect you to fill in the values") {
    assert(__ == 1 + 1): @silent
  }
}
