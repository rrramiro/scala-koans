package org.scalakoans

import fr.ramiro.scala.koans.KoanFunSuite
import org.scalatest.matchers.should.Matchers

import scala.language.reflectiveCalls

class AboutStructuralTypes extends KoanFunSuite with Matchers {

  koan("stuctural types") {
    def sayHello(person: { def name: String }) = "Hello, " + person.name

    case class Person(name: String)

    val p = new Person("Lou")

    sayHello(p) should be(__)

    class Person2
    val p2 = new Person2
    meditate
    //sayHello(p2) should be(__)
  }

  koan("defined structural type") {
    type HasName = { def name: String }

    def sayHello(person: HasName) = "Hello, " + person.name

    case class Person(name: String)

    val p = new Person("Lou")
    sayHello(p) should be(__)
  }

}
