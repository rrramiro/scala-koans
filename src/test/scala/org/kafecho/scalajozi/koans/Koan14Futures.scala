package org.kafecho.scalajozi.koans

import org.functionalkoans.forscala.KoanMatcher
import org.scalatest.{ FunSuite, Matchers }

import scala.concurrent._
import scala.concurrent.duration._
import scala.language.postfixOps

class Koan14Futures extends FunSuite with Matchers with KoanMatcher {
  test("Create futures, compose them, and wait for them to complete.") {
    import ExecutionContext.Implicits.global

    // Let's think hard about what the meaning of life could be.
    val answer: Future[Int] = Future {
      Thread.sleep(2000)
      41
    }

    // Once we eventually have the answer, we check if it is correct.
    val checkAnswer: Future[Boolean] = answer.map(v => v == 42)

    // Block for the result.
    val check = Await.result(checkAnswer, 3 seconds)
    check should equal(__)
  }

  test("Use futures with for comprehension") {
    import ExecutionContext.Implicits.global

    // Let's think hard about what the meaning of life could be.
    val answer: Future[Int] = Future {
      Thread.sleep(2000)
      42
    }

    val checkAnswer: Future[Boolean] = for (a <- answer) yield (a == 42)

    // Block for the result.
    val check = Await.result(checkAnswer, 3 seconds)
    check should equal(__)
  }
}