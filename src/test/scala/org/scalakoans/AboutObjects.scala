package org.scalakoans

import fr.ramiro.scala.koans.KoanFunSuite
import org.scalatest.matchers.should.Matchers

class AboutObjects extends KoanFunSuite with Matchers {

  koan("singleton objects") {
    object Thing {
      def add2(i: Int) = i + 2
    }

    Thing.add2(2) should __

    meditate
    // Thing.add3(4) should be(7)
  }

  koan("singleton objects can extend classes") {
    class Cat(val name: String)

    object LouFerigno extends Cat("Lou")
    LouFerigno.name should __

    meditate
    // LouFerigno.meow should be("meow")
  }

  koan("Singleton objects are good for constants") {
    object Constants {
      val RED = "RED"
      val GREEN = "green"
    }

    Constants.RED should __
  }

}
