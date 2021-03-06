package org.scalakoans

import com.github.ghik.silencer.silent
import fr.ramiro.scala.koans.KoanFunSuite
import org.scalatest.matchers.should.Matchers

@silent
class AboutLiterals extends KoanFunSuite with Matchers {
  koan("integer literals") {
    val i = 1

    i.isInstanceOf[Int] should __
  }

  koan("double literals") {
    val f = 2.0

    f.isInstanceOf[Double] should be(__)
  }

  koan("string literals") {
    val s = "abcd"

    s.isInstanceOf[___] should be(true)

    s.toUpperCase() should __
    s.length() should __

    s.isInstanceOf[java.lang.String] should __

    // sadly no string interpolation
    val str = "%s - %d".format("abc", 123)
    str should __
  }

  koan("symbol literals") {
    val s = 'abc

    s.isInstanceOf[___] should be(true)

    __ should be theSameInstanceAs ('abc)
  }
}
