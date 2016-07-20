package org.kafecho.scalajozi.koans

import org.functionalkoans.forscala.KoanMatcher
import org.scalatest.{ FunSuite, Matchers }

import scala.language.postfixOps

class Koan02LookMaNoOperators extends FunSuite with Matchers with KoanMatcher {

  test("In scala, -,+,/,* are methods, not operators") {
    (1 + 1) should equal(__)
    (1.+(1)) should equal(__)
    (1.*(5)) should equal(__)
  }

  test("methods can be invoked like operators") {
    val s = "hello"
    s.length should be(__)

    (s length) should be(__)

    (s contains "x") should be(__)
  }

  test("Simple rationals") {

    case class Rational(num: Int, denum: Int) {
      def *(another: Rational): Rational = {
        Rational(this.num * another.num, this.denum * another.denum)
      }

      Rational(1, 2) * Rational(2, 1) should equal(__)
    }
  }

}