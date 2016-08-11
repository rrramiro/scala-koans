package org.kafecho.scalajozi.koans

import fr.ramiro.scala.koans.KoanFunSuite
import org.scalatest.Matchers

class Koan12Traits extends KoanFunSuite with Matchers {
  koan("traits") {
    trait SaysHello {
      def sayHello(name: String) = "hello " + name
    }

    class Thing extends SaysHello

    (new Thing).sayHello("Lou") should be(__)
  }

  koan("traits can have abstract members which must be implemented") {
    trait SaysHello {
      val name: String

      def sayHello = "hello " + name
    }

    case class Person(name: String) extends SaysHello
    val p = Person("lou")

    p.sayHello should be(__)
  }

  koan("multiple traits can be mixed in") {
    trait SaysHello {
      val name: String

      def sayHello = "hello " + name
    }

    trait SaysHelloTwice extends SaysHello {
      override def sayHello = super.sayHello + " " + super.sayHello
    }

    case class Person(name: String) extends SaysHello with SaysHelloTwice

    val p = Person("lou")

    p.sayHello should be(__)
  }

}
