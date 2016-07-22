package org.scalakoans

import java.util.Date

import com.github.ghik.silencer.silent
import org.functionalkoans.forscala.KoanFunSuite
import org.scalatest.Matchers

@silent
class AboutTuples extends KoanFunSuite with Matchers {

  koan("Tuples can be created easily") {
    val tuple = ("apple", "dog")

    tuple should __
  }

  koan("Tuple items may be accessed individually") {
    val tuple = ("apple", "dog", "tree")
    val fruit = tuple._1
    val animal = tuple._2

    fruit should be("apple")
    animal should be("dog")
    __ should be("tree")

    tuple.isInstanceOf[(String, String, String)] should __
    __.isInstanceOf[(String, String, String)] should be(true)
  }

  koan("Tuples are immutable") {
    val tuple = ("abc", "def")
    tuple._1 should __

    // what happens when you uncomment
    // tuple._1 = "ghi"
  }

  koan("Tuples may be of mixed type") {
    val tuple5 = ("a", 1, 2.2, new Date(), BigDecimal(5))

    tuple5._1 should be("a")
    tuple5._2 should __
    tuple5._3 should be(2.2)
    tuple5._4.after(new Date()) should be(false)
    __ should be(BigDecimal(5))
  }

  koan("Pair is a tuple of 2 things") {
    val tuple = (123, "abc")

    tuple.isInstanceOf[(Int, String)] should __
    __.isInstanceOf[(Int, String)] should be(true)
  }

  koan("-> creates a Pair") {
    val p = 123 -> "abc"

    p.isInstanceOf[(Int, String)] should __
  }

}
