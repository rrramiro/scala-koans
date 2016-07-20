package org.kafecho.scalajozi.koans

import org.functionalkoans.forscala.KoanMatcher
import org.scalatest.{ FunSuite, Matchers }

class Koan03Strings extends FunSuite with Matchers with KoanMatcher {

  test("Get the nth character of a String") {
    val msg = "Hello world"
    msg(0) should equal('H')
    msg(4) should equal(__)
  }

  test("The Apply method applied to Strings") {
    val msg = "Hello world"

    msg(0) should equal(msg.apply(0))

    msg.apply(4) should equal(__)
  }

  test("From Scala 2.10, you can do string interpolation.") {
    val whom = "Jozi"
    val greeting = s"Hello $whom"
    greeting should equal(__)
  }
}

