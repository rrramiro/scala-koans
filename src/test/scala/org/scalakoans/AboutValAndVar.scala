package org.scalakoans

import fr.ramiro.scala.koans.KoanFunSuite
import org.scalatest.matchers.should.Matchers

class AboutValAndVar extends KoanFunSuite with Matchers {

  koan("basic assignment") {
    val a: Int = 5

    a should __
  }

  koan("type inference makes type declaration unecessary") {
    val a = 5

    a should __
  }

  koan("assignment with var may be reassigned") {
    var a = 5
    a should be(5)

    a = 7
    a should __
  }

  koan("assignment with val may not be reassigned") {
    val a = 5
    a should be(5)

    meditate
    // What happens if you uncomment these lines?
    // a = 7
    // a should be (5)
  }

}
