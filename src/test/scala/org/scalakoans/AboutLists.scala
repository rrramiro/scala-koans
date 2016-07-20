package org.scalakoans

import org.functionalkoans.forscala.KoanMatcher
import org.scalatest.{ FunSuite, Matchers }

class AboutLists extends FunSuite with Matchers with KoanMatcher {

  test("Nil lists are identical, even of different types") {
    val a: List[String] = Nil
    val b: List[Int] = Nil

    (a == Nil) should be(true)
    (a eq Nil) should be(true)

    (b == Nil) should be(true)
    (b eq Nil) should be(true)

    (a == b) should be(true)
    (a eq b) should be(true)
  }

  test("Lists are easily created") {
    val a = List(1, 2, 3)
    a should equal(List(1, 2, 3))
  }

  test("Lists can be accessed via head and tail") {
    val a = List(1, 2, 3)
    a.head should equal(1)
    a.tail should equal(List(2, 3))
  }

  test("Lists can accessed at random") {
    val a = List(1, 3, 5, 7, 9)
    a(0) should equal(1)
    a(2) should equal(5)
    a(4) should equal(9)

    intercept[NoSuchElementException] {
      println(a(5))
    }
  }

  test("Lists are immutable") {
    val a = List(1, 3, 5, 7, 9)
    val b = a.filterNot(v => v == 5) // remove where value is 5

    a should equal(List(1, 3, 5, 7, 9))
    b should equal(List(1, 3, 7, 9))
  }

  test("Lists have many useful methods") {
    val a = List(1, 3, 5, 7, 9)

    // get the length of the list
    a.length should equal(5)

    // reverse the list
    a.reverse should equal(List(9, 7, 5, 3, 1))

    // convert the list to a string representation
    a.toString should equal("List(1, 3, 5, 7, 9)")

    // map a function to double the numbers over the list
    a.map { v => v * 2 } should equal(List(2, 6, 10, 14, 18))

    // filter out any values divisible by 3 in the list
    a.filter { v => v % 3 == 0 } should equal(List(3, 9))
  }

  test("Functions over lists can use _ as shorthand") {
    val a = List(1, 2, 3)
    a.map { _ * 2 } should equal(List(2, 4, 6))
    a.filter { _ % 2 == 0 } should equal(List(2))
  }

  test("Functions over lists can use () instead of {}") {
    val a = List(1, 2, 3)
    a.map(_ * 2) should equal(List(2, 4, 6))
    a.filter(_ % 2 != 0) should equal(List(1, 3))
  }

  test("Lists can be 'reduced' with a mathematical operation") {
    val a = List(1, 3, 5, 7)
    // note the two _s below indicate the first and second args respectively
    a.reduceLeft(_ + _) should equal(16)
    a.reduceLeft(_ * _) should equal(105)
  }

  test("Foldleft is like reduce, but with an explicit starting value") {
    val a = List(1, 3, 5, 7)
    // foldLeft uses a form called currying that we will explore later
    a.foldLeft(0)(_ + _) should equal(16)
    a.foldLeft(10)(_ + _) should equal(26)
    a.foldLeft(1)(_ * _) should equal(105)
    a.foldLeft(0)(_ * _) should equal(0)
  }

  test("You can create a list from a range") {
    val a = (1 to 5).toList
    a should be(List(1, 2, 3, 4, 5))
  }

}
