package org.scalakoans

import org.functionalkoans.forscala.KoanMatcher
import org.scalatest.{ FunSuite, Matchers }

class AboutLiterals extends FunSuite with Matchers with KoanMatcher {
  test("integer literals") {
    val i = 1

    i.isInstanceOf[Int] should __
  }

  test("double literals") {
    val f = 2.0

    f.isInstanceOf[Double] should be(__)
  }

  test("string literals") {
    val s = "abcd"

    s.isInstanceOf[___] should be(true)

    s.toUpperCase() should __
    s.length() should __

    s.isInstanceOf[java.lang.String] should __

    // sadly no string interpolation
    val str = "%s - %d".format("abc", 123)
    str should __
  }

  test("symbol literals") {
    val s = 'abc

    s.isInstanceOf[___] should be(true)

    __ should be theSameInstanceAs ('abc)
  }
}
