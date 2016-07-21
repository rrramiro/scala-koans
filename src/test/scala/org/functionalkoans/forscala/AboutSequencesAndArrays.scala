package org.functionalkoans.forscala

import org.scalatest.{ FunSuite, Matchers }

class AboutSequencesAndArrays extends FunSuite with Matchers with KoanSuite {

  test("A list can be converted to an array") {
    val l = List(1, 2, 3)
    val a = l.toArray
    a should equal(Array(__, __, __))
  }

  test("Any sequence can be converted to a list") {
    val a = Array(1, 2, 3)
    val s = a.toSeq
    val l = s.toList
    l should equal(__)
  }

  test("You can create a sequence from a for comprehension") {
    val s = for (v <- 1 to 4) yield v
    s.toList should be(__)
  }

  test("You can create a sequence from a for comprehension with a condition") {
    val s = for (v <- 1 to 10 if v % 3 == 0) yield v
    s.toList should be(__)
  }

  test("You can filter any sequence based on a predicate") {
    val s = Seq("hello", "to", "you")
    val filtered = s.filter(_.length > 2)
    filtered should be(Seq(__, __))
  }

  test("You can also filter Arrays in the same way") {
    val a = Array("hello", "to", "you", "again")
    val filtered = a.filter(_.length > 3)
    filtered should be(Array(__, __))
  }

  test("You can map values in a sequence through a function") {
    val s = Seq("hello", "world")
    val r = s map {
      _.reverse
    }

    r should be(__)
  }

}
