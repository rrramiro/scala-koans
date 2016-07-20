package org.kafecho.scalajozi.koans


import org.functionalkoans.forscala.KoanMatcher
import org.scalatest.{FunSuite, Matchers}

class Koan10Objects extends FunSuite with Matchers with KoanMatcher {
  test("An object can used as a collection of things.") {
    object Settings {
      val volume = 5
    }

    Settings.volume should be(__)
  }

  test("You can nest objects") {
    object Lounge {

      object TV {
        var volume = 5
      }

    }
    Lounge.TV.volume should be(__)
  }

  test("Objects can extends classes") {
    class SuperHero(val realName: String)
    object Superman extends SuperHero("Clark Kent")

    Superman.realName should be(__)
  }

  test("Use a singleton object as a container of static methods") {
    object Math {
      def add2(n: Int) = n + 2
    }

    // Note Scala takes care of threading issues here.
    Math.add2(5) should be(__)
  }

  test("A companion object goes with the class of the same name.") {
    class Foo(x: Int)

    object Foo {
      def apply(x: Int) = new Foo(x)
    }

    // No need to use new, as we are calling the method on the companion object.
    Foo(42)
  }
}

