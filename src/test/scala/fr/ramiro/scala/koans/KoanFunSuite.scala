package fr.ramiro.scala.koans

import org.scalatest._
import org.scalatest.exceptions.TestPendingException
import org.scalatest.matchers.Matcher

class KoanFunSuite extends FunSuite {
  def koan(testName: String, testTags: Tag*)(testFun: => Unit): Unit = {
    test(testName, testTags: _*)(testFun)
  }

  def __ : Matcher[Any] = throw new TestPendingException

  type ___ = Exception

  def meditate: Assertion with PendingStatement = pending

  override def runTest(testName: String, args: Args): Status = {
    if (!args.stopper.stopRequested) {
      super.runTest(testName, args)
    } else {
      FailedStatus
    }
  }
}
