package org.functionalkoans.forscala

import org.scalatest.{ Args, FailedStatus, Status, Suite }
import org.scalatest.exceptions.TestPendingException
import org.scalatest.matchers.Matcher

trait KoanSuite extends Suite with KoanMatchers {

  def meditate = pending

  abstract override def runTest(testName: String, args: Args): Status = {
    if (!args.stopper.stopRequested) {
      super.runTest(testName, args)
    } else {
      FailedStatus
    }
  }
}
