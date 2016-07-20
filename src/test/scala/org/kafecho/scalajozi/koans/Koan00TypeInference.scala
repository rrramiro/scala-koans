package org.kafecho.scalajozi.koans

import org.functionalkoans.forscala.KoanMatcher
import org.scalatest.{ FunSuite, Matchers }

class Koan00TypeInference extends FunSuite with Matchers with KoanMatcher {
  test("Types and ; can be inferred") {
    val x: Int = 42
    val y = 42
    (x == y) should be(__)

    // No need for semicolons
    val a = 42;

    val b = 42

    // Type inference works with collections.
    val capitalToCountry: Map[String, String] = Map("Paris" -> "France", "Pretoria" -> "SA")
    val countryToCapital = Map("France" -> "France", "SA" -> "Pretoria")
  }
}