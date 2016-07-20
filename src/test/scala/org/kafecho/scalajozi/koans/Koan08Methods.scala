package org.kafecho.scalajozi.koans

import org.functionalkoans.forscala.KoanMatcher
import org.scalatest.{ FunSuite, Matchers }

class Koan08Methods extends FunSuite with Matchers with KoanMatcher {
  test("Let's define a method") {
    def add2(i: Int): Int = {
      return (i + 2)
    }

    add2(0) should equal(__)
  }

  test("Return is optional") {
    def add2(i: Int): Int = {
      i + 2
    }

    add2(0) should equal(__)
  }

  test("Return type is optional") {
    def add2(i: Int) = i + 2

    add2(0) should equal(__)
  }

  test("Nested method") {
    def add2(i: Int) = {
      def add1(x: Int) = x + 1
      add1(add1(i))
    }

    add2(0) should equal(__)

  }
}