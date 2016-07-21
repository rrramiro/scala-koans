package org.kafecho.scalajozi.koans

import org.functionalkoans.forscala.KoanSuite
import org.scalatest.{ FunSuite, Matchers }

import scala.annotation.tailrec

class Koan16Recursion extends FunSuite with Matchers with KoanSuite {

  test("Recursive factorial") {

    /**
     * This implementation of factorial is not tail recursive.
     * The last method that it calls is not itself.
     * Therefore, if n is large, it will run out of stack space.
     */
    def fact(n: Int): Int = {
      if (n <= 1) 1
      else n * fact(n - 1)
    }
  }

  test("Tail recursive factorial") {

    def fact(n: Int): Int = {

      /** This implementation is tail recursive. The compiler re-writes this as a loop. */
      @tailrec def tailRecFact(acc: Int, n: Int): Int = {
        if (n <= 1) acc
        else tailRecFact(acc * n, n - 1)
      }

      tailRecFact(1, n)
    }
  }

}
