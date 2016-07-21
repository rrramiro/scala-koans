package org.scalakoans

import org.functionalkoans.forscala.KoanSuite
import org.scalatest.{ FunSuite, Matchers }

class AboutValAndVar extends FunSuite with Matchers with KoanSuite {

  test("basic assignment") {
    val a: Int = 5

    a should __
  }

  test("type inference makes type declaration unecessary") {
    val a = 5

    a should __
  }

  test("assignment with var may be reassigned") {
    var a = 5
    a should be(5)

    a = 7
    a should __
  }

  test("assignment with val may not be reassigned") {
    val a = 5
    a should be(5)

    meditate
    // What happens if you uncomment these lines?
    // a = 7
    // a should be (5)
  }

}
