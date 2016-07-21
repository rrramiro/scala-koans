package org.functionalkoans.forscala

import org.scalatest.{ Args, FailedStatus, Status, Suite }
import org.scalatest.exceptions.TestPendingException
import org.scalatest.matchers.Matcher

trait KoanSuite extends Suite {

  def meditate = pending

  def __ : Matcher[Any] = {
    throw new TestPendingException
  }

  protected class ___ extends Exception {
    override def toString = "___"
  }

  abstract override def runTest(testName: String, args: Args): Status = {
    if (!args.stopper.stopRequested) {
      super.runTest(testName, args)
    } else {
      FailedStatus
    }
  }
}
