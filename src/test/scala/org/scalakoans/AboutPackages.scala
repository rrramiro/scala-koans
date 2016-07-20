package org.scalakoans

import org.functionalkoans.forscala.KoanMatcher
import org.scalatest.{ FunSuite, Matchers }

class AboutPackages extends FunSuite with Matchers with KoanMatcher {

  test("packages contain classes and objects") {
    val packageOfThisClass = classOf[AboutPackages].getName.split("\\.").dropRight(1).mkString(".")

    packageOfThisClass should be(__)
  }

  test("package namespaces") {
    // package is defined below
    val p = new abc.Person
    p.isInstanceOf[___] should be(true)
    p.isInstanceOf[___] should be(true)
  }

  test("imports are relative to existing imports") {
    // package is defined below
    import first._
    import inside._
    import evenMoreInside.Animal

    val a = new Animal
    a.isInstanceOf[___] should be(true)
  }

  test("import an object's methods") {
    object Colors {
      val BLUE = "BLUE"
      val RED = "RED"
    }

    import Colors._

    BLUE should be(__)
  }

  test("importing a variable's methods") {
    case class Person(val firstName: String)

    val person = Person("Lou")

    import person._

    firstName should be(__)
  }
}

package abc {
  class Person
}

package first {
  package inside {
    package evenMoreInside {
      class Animal
    }
  }
}

