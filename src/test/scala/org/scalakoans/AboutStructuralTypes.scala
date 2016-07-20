package org.scalakoans

import org.functionalkoans.forscala.KoanMatcher
import org.scalatest.{ FunSuite, Matchers }

class AboutStructuralTypes extends FunSuite with Matchers with KoanMatcher {

  test("stuctural types") {
    def sayHello(person: { def name: String }) = "Hello, " + person.name

    case class Person(name: String)

    val p = new Person("Lou")

    sayHello(p) should be(__)

    class Person2
    val p2 = new Person2
    meditate
    //sayHello(p2) should be(__)
  }

  test("defined structural type") {
    type HasName = { def name: String }

    def sayHello(person: HasName) = "Hello, " + person.name

    case class Person(name: String)

    val p = new Person("Lou")
    sayHello(p) should be(__)
  }

}
