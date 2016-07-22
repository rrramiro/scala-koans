package org.functionalkoans.forscala

import org.scalatest.events.{ TestFailed, TestPending, _ }
import org.scalatest.{ Status, _ }

import scala.language.reflectiveCalls

abstract class KoansSuites(columnSize: Int = 42)(suitesToNest: Suite*) extends Suites(suitesToNest: _*) {

  private type InhibitedEvent = {
    val ordinal: Ordinal
    val suiteName: String
    val testName: String
  }

  private def wordWrap(s: String, maxLength: Int): String = {
    s.split(" ").foldLeft(Array(""))((out, in) => {
      if ((out.last + " " + in).trim.length > maxLength) {
        out :+ in
      } else {
        out.updated(out.length - 1, out.last + " " + in)
      }
    }).mkString("\n").trim
  }

  private def inhibitOnFailure(stopper: Stopper, event: InhibitedEvent) = {
    stopper.requestStop
    InfoProvided(
      ordinal = event.ordinal,
      message = Seq(
        "*" * columnSize,
        "*" * columnSize,
        "",
        wordWrap(s"""Please meditate on koan "${event.testName.stripMargin}" of suite "${event.suiteName}"""", columnSize),
        "",
        "*" * columnSize,
        "*" * columnSize
      ).mkString("\n", "\n", ""),
      nameInfo = Some(NameInfo("Koans", "koans", None, None))
    )
  }

  override def run(testName: Option[String], args: Args): Status = {
    super.run(testName, args.copy(reporter = new Reporter {
      def apply(event: Event) {
        event match {
          case e @ (_: TestIgnored | _: TestFailed | _: TestPending) =>
            args.reporter(inhibitOnFailure(args.stopper, e.asInstanceOf[InhibitedEvent]))
          case _ =>
            args.reporter(event)
        }
      }
    }))
  }
}
