package org.kafecho.scalajozi.koans

import org.functionalkoans.forscala.KoanSuite
import org.scalatest.{ FunSuite, Matchers }

import scala.language.postfixOps

class Koan15ImplicitConversions extends FunSuite with Matchers with KoanSuite {

  test("Working with frequencies") {
    case class Hertz(value: Long)
    object Conversions {

      /** Monkey patch a Long to add frequency related methods. */
      implicit class FrequencyConversion(what: Long) {
        def Hz = Hertz(what)

        def kHz = Hertz(what * 1000)

        def MHz = Hertz(what * 1000 * 1000)

        def GHz = Hertz(what * 1000 * 1000 * 1000)
      }

    }

    import Conversions._

    val frequency = 5L GHz

    frequency.isInstanceOf[Hertz] should be(__)

  }
}