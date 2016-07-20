package org.functionalkoans.forscala

import org.scalatest.{ FunSuite, Matchers }

class AboutNamedAndDefaultArguments() extends FunSuite with Matchers with KoanMatcher {

  class WithoutClassParameters() {
    def addColors(red: Int, green: Int, blue: Int) = {
      (red, green, blue)
    }

    def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) = {
      (red, green, blue)
    }
  }

  class WithClassParameters(val defaultRed: Int, val defaultGreen: Int, val defaultBlue: Int) {
    def addColors(red: Int, green: Int, blue: Int) = {
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
    }

    def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) = {
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
    }
  }

  class WithClassParametersInClassDefinition(val defaultRed: Int = 0, val defaultGreen: Int = 255,
      val defaultBlue: Int = 100) {
    def addColors(red: Int, green: Int, blue: Int) = {
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
    }

    def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) = {
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
    }
  }

  test("can specify arguments in any order if you use their names") {
    val me = new WithoutClassParameters()

    // what happens if you change the order of these parameters (nothing)
    val myColor = me.addColors(green = 0, red = 255, blue = 0)

    // for koan, remove the values in the should equal
    myColor should equal(__, __, __)
  }

  test("can default arguments if you leave them off") {
    val me = new WithoutClassParameters()
    val myColor = me.addColorsWithDefaults(green = 255)

    myColor should equal(__, __, __)
  }

  test("can access class parameters and specify arguments in any order if you use their names") {
    val me = new WithClassParameters(40, 50, 60)
    val myColor = me.addColors(green = 50, red = 60, blue = 40)

    myColor should equal(__, __, __)
  }

  test("can access class parameters and default arguments if you leave them off") {
    val me = new WithClassParameters(10, 20, 30)
    val myColor = me.addColorsWithDefaults(green = 70)

    myColor should equal(__, __, __)
  }

  test("can default class parameters and have default arguments too") {
    val me = new WithClassParametersInClassDefinition()
    val myColor = me.addColorsWithDefaults(green = 70)

    myColor should equal(__, __, __)
  }

  test("default parameters can be functional too") {
    def reduce(a: Int, f: (Int, Int) => Int = _ + _): Int = f(a, a)

    reduce(5) should equal(__)
    reduce(5, _ * _) should equal(__)
  }
}
