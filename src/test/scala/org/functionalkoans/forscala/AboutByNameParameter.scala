package org.functionalkoans.forscala

import fr.ramiro.scala.koans.KoanFunSuite
import org.scalatest.Matchers

/**
 * AboutByNameParameter
 * Koan to help understand by name parameters in Scala
 * Prerequisites: AboutEither, AboutHigherOrderFunctions, AboutExceptions,
 *                About Pattern Matching, AboutApply
 */
class AboutByNameParameter extends KoanFunSuite with Matchers {

  koan("""() => Int is a Function type that takes a Unit type. Unit is known as
       | 'void' to a Java programmer. The function and returns an Int.
       | You can place this as a method parameter so that you can you use it
       | as a block, but still it doesn't look quite right.""") {

    def calc(x: () => Int): Either[Throwable, Int] = {
      try {
        Right(x()) //An explicit call the the x function
      } catch {
        case b: Throwable => Left(b)
      }
    }

    //Having explicitly declaring that Unit is a parameter with ()
    val y = calc { () =>
      14 + 15
    }

    y should be(__)
  }

  koan("""A by-name parameter does the same thing as a previous koan but there
        | is no need to explicitly handle Unit or (). This is used extensively
        | in scala to create blocks.""") {
    //x is a call by name parameter
    def calc(x: => Int): Either[Throwable, Int] = {
      try {
        Right(x)
      } catch {
        case b: Throwable => Left(b)
      }
    }

    val y = calc { //This looks like a natural block
      println("Here we go!") //Some superfluous call
      val z = List(1, 2, 3, 4) //Another superfluous call
      49 + 20
    }

    y should be(__)
  }

  koan("""By name parameters can also be used with an Object and apply to make
      |interesting block-like calls""") {
    object PigLatinizer {
      def apply(x: => String) = x.tail + x.head + "ay"
    }

    val result = PigLatinizer {
      val x = "pret"
      val z = "zel"
      x ++ z //concatenate the strings
    }

    result should be(__)
  }
}
