package org.functionalkoans.forscala

import fr.ramiro.scala.koans.KoanFunSuite
import org.scalatest.matchers.should.Matchers

class AboutRange extends KoanFunSuite with Matchers {

  koan("Range are not inclusive at end of range") {
    val someNumbers = Range(0, 10)

    someNumbers.size should be(__)
  }

  koan("Range can specify a step for an increment") {
    val someNumbers = Range(2, 10, 3)

    someNumbers.size should be(__)
  }

  koan("Range does not include the last item, even in a step increment") {
    val someNumbers = Range(0, 34, 2)
    someNumbers.contains(33) should be(__)
    someNumbers.contains(32) should be(__)
    someNumbers.contains(34) should be(__)
  }

  koan("Range can specify to include the last value") {
    val someNumbers = Range(0, 34).inclusive

    someNumbers.contains(34) should be(__)
  }

}
