package org.scalakoans

import org.functionalkoans.forscala.KoanSuite
import org.scalatest.{ FunSuite, Matchers }

class AboutTraits extends FunSuite with Matchers with KoanSuite {

  test("traits") {
    trait SaysHello {
      def sayHello(name: String) = "hello " + name
    }

    class Thing extends SaysHello

    (new Thing).sayHello("Lou") should be(__)
  }

  test("traits can have abstract members which must be implemented") {
    trait SaysHello {
      val name: String
      def sayHello = "hello " + name
    }

    case class Person(name: String) extends SaysHello
    val p = Person("lou")

    p.sayHello should be(__)
  }

  test("multiple traits can be mixed in") {
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

  test("traits cannot have a constructor") {
    meditate
    // trait SaysHello(name: String) {
    //   def sayHello = "hello " + name
    // }
  }

}