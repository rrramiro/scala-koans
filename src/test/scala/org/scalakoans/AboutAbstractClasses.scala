package org.scalakoans

import org.functionalkoans.forscala.KoanSuite
import org.scalatest.{ FunSuite, Matchers }

class AboutAbstractClasses extends FunSuite with Matchers with KoanSuite {

  test("Abstract Classes") {
    abstract class Super {
      def sayHello(name: String): String
    }

    class Thing extends Super {
      def sayHello(name: String) = "Hello " + name
    }

    (new Thing).sayHello("Lou") should be(__)

    meditate
    // class Thing2 extends Super {
    // }
  }

}