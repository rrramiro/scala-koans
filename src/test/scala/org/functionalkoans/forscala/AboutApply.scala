package org.functionalkoans.forscala

import fr.ramiro.scala.koans.KoanFunSuite
import org.scalatest.matchers.should.Matchers

class AboutApply extends KoanFunSuite with Matchers {
  koan("""The apply method is a magical method in Scala, it is a method that
        | doesn't require you to leave out the entire method name!""") {

    class Counter(val seed: Int) {
      def apply(n: Int) = new Counter(seed + n)
    }

    var a = new Counter(10)
    a = a.apply(20)
    a.seed should be(__)
    a = a(40) //Whoa! Look Ma! No apply!
    a.seed should be(__)
  }

  koan("""The apply method can also be used in singleton objects as well,
        | in fact, it is the most common way to create a factory method in
        | an object""") {

    //private constructor!
    class Employee(val firstName: String, val lastName: String)

    object Employee {
      def apply(firstName: String, lastName: String) =
        new Employee(firstName, lastName)
    }

    var a = Employee.apply("Aleksander", "Neufied")
    a.firstName should be(__)
    val b = Employee("Jamie", "Pindar")
    a.lastName should be(__)
  }
}
