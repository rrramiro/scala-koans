package org.functionalkoans.forscala

import fr.ramiro.scala.koans.KoanFunSuite
import org.scalatest.matchers.should.Matchers

class AboutLiteralBooleans extends KoanFunSuite with Matchers {

  koan("""Boolean literals are either true or false,
      | using the true or false keyword""") {
    val a = true
    val b = false
    val c = 1 > 2
    val d = 1 < 2
    val e = a == c
    val f = b == d
    a should be(__)
    b should be(__)
    c should be(__)
    d should be(__)
    e should be(__)
    f should be(__)
  }

}
