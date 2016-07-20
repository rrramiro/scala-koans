package org.scalakoans

import org.functionalkoans.forscala.KoanMatcher
import org.scalatest.{ FunSuite, Matchers }

class AboutAsserts extends FunSuite with Matchers with KoanMatcher {

  test("should be true") {
    assert(false) // should be true
  }

  test("should be true with message") {
    assert(false, "This should be true")
  }

  test("should be true with should matchers") {
    false should be(true) // should be true
  }

  test("should match two equal values") {
    val v1 = 4
    val v2 = 3

    meditate
    v1 should be(v2)
  }

  test("can also use equal as a matcher") {
    val v1 = 4
    val v2 = 3

    v1 should equal(v2)
  }

  test("sometimes we expect you to fill in the values") {
    (1 + 1) should __
  }
}
