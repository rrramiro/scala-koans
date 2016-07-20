package org.functionalkoans.forscala

import org.scalatest.events.{TestFailed, TestPending, _}
import org.scalatest.{Status, _}
import scala.language.reflectiveCalls

abstract class KoansSuites(suitesToNest: Suite*) extends Suites(suitesToNest: _*){
  private class ReportToTheMaster(other: Reporter, stopper: Stopper) extends Reporter {
    private type KoanEven = {
      val ordinal : Ordinal
      val suiteName: String
      val testName: String
    }
    private def failure(event: KoanEven) =  {
      stopper.requestStop
      InfoProvided(
        ordinal = event.ordinal,
        message = Seq(
          "*****************************************",
          "*****************************************",
          "",
          "",
          "",
          "Please meditate on koan \"%s\" of suite \"%s\"" format(event.testName, event.suiteName),
          "",
          "",
          "",
          "*****************************************",
          "*****************************************"
        ).mkString("\n", "\n", ""),
        nameInfo = Some(NameInfo("Koan", "koan", None,None))
      )
    }

    def apply(event: Event) {
      event match {
        case e: TestIgnored => other(failure(e))
        case e: TestFailed  => other(failure(e))
        case e: TestPending => other(failure(e))
        case _ =>
      }
      other(event)
    }
  }

  override def run(testName: Option[String], args: Args): Status = {
    super.run(testName, args.copy(reporter = new ReportToTheMaster(args.reporter, args.stopper)))
  }
}
