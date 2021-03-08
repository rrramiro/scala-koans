package org.kafecho.scalajozi.koans

import fr.ramiro.scala.koans.KoanFunSuite
import org.scalatest.matchers.should.Matchers

import scala.language.postfixOps

class Koan15ImplicitConversions extends KoanFunSuite with Matchers {

  koan("Working with frequencies") {
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
