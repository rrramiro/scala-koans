package org.scalakoans

import org.functionalkoans.forscala.KoanSuite
import org.scalatest.{ FunSuite, Matchers }
import scala.language.postfixOps

class AboutMethods extends FunSuite with Matchers with KoanSuite {

  test("method declaration") {
    def add2(i: Int): Int = {
      return i + 2
    }

    add2(2) should __

    meditate
    // define add3
    // add3(2) should be(5)
  }

  test("return not always necssary") {
    def add2(i: Int): Int = {
      i + 2
    }

    add2(3) should __
  }

  test("return type necessity") {
    def add2(i: Int) = {
      i + 2
    }

    add2(4) should __
  }

  test("nested methods") {

    def add2(i: Int) = {
      def add(x: Int, y: Int) = {
        x + y
      }

      add(2, i)
    }

    add2(5) should __

    meditate
    // add3(2) should be(5)
  }

  test("method without a return") {
    var x = 2
    def add2ToX() {
      x += 2
    }

    add2ToX()

    x should __
  }

  test("brackets around the method body aren't always necessary for simple expressions") {
    def add2(i: Int) = i + 2

    add2(2) should __
  }

  test("named arguments") {
    def add2(i: Int) = i + 2

    add2(i = 5) should __
  }

  test("default arguments") {
    def addNumbers(first: Int, second: Int = 2) = first + second

    addNumbers(3) should __

    meditate
    // def addNumbers2(first: Int = 2, second: Int) = first + second
    // addNumbers2(3)
  }

  test("by-name arguments make lazy arguments") {
    var x = 0
    def addOneToXAndReturnX() = { x += 1; x }

    x should __
    addOneToXAndReturnX should __
    x should __

    def add2(i: => Int) = {
      2 + i
    }

    add2(addOneToXAndReturnX) should __

    x should __

    val i = add2 {
      3 + 4
    }

    i should __
  }

  test("operators are just methods") {
    val x = 2

    val i = x + 2
    i should __

    val j = x.+(3)
    j should __
  }

  test("methods can be invoked like operators") {
    val s = "hello"
    s.length should __

    (s length) should __

    (s contains "x") should __
  }

}