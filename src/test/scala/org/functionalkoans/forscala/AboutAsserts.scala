package org.functionalkoans.forscala

import com.github.ghik.silencer.silent
import org.scalatest.Matchers

// meditate on AboutAsserts to see how the Scala Koans work
@silent
class AboutAsserts extends KoanFunSuite with Matchers {

  koan("asserts can take a boolean argument") {
    assert(false) // should be true
  }

  koan("asserts can include a message") {
    assert(false, "This should be true")
  }

  koan("true and false values can be compared with should matchers") {
    false should be(true) // should be true
  }

  koan("booleans in asserts can test equality") {
    val v1 = 4
    val v2 = 4
    v1 === __ // === is an assert. It is from ScalaTest, not from the Scala language
  }

  koan("sometimes we expect you to fill in the values") {
    assert(__ == 1 + 1)
  }
}
