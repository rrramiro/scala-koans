package fr.ramiro.scala.koans

import org.scalatest.events.{ TestFailed, TestPending, _ }
import org.scalatest.{ Status, _ }
import System.lineSeparator
import scala.language.reflectiveCalls

abstract class KoansSuites(
  columnSize: Int = 50,
  showFailures: Boolean = false,
  borderPattern: String = "*"
)(suitesToNest: Suite*) extends Suites(suitesToNest: _*) {

  private type TestEvent = {
    val ordinal: Ordinal
    val suiteName: String
    val suiteId: String
    val testName: String
    val suiteClassName: Option[String]
  }

  private def wordWrap(s: String, maxLength: Int): String = {
    s.replaceAll("\\s+", " ").split(" ").foldLeft(Array(""))((out, in) => {
      if ((out.last + " " + in).trim.length > maxLength) {
        out :+ in
      } else {
        out.updated(out.length - 1, out.last + " " + in)
      }
    }).mkString(lineSeparator()).trim
  }

  private def formatBorder(pattern: String) = {
    if (pattern.nonEmpty) {
      pattern * (columnSize / pattern.length)
    } else {
      "*" * columnSize
    }
  }

  private def meditationMessage(event: TestEvent) = {
    NoteProvided(
      ordinal = event.ordinal,
      message = Seq(
        formatBorder(borderPattern),
        "",
        wordWrap(
          s"""Please meditate on koan "${event.testName.stripMargin}"""",
          columnSize
        ),
        "",
        formatBorder(borderPattern)
      ).mkString(lineSeparator(), lineSeparator(), ""),
      nameInfo = Some(
        NameInfo(event.suiteName, event.suiteId, event.suiteClassName, None)
      )
    )
  }

  override def run(testName: Option[String], args: Args): Status = super.run(
    testName = testName,
    args = args.copy(
      reporter = {
        case e @ (_: TestIgnored | _: TestFailed | _: TestPending) =>
          args.stopper.requestStop()
          args.reporter(meditationMessage(e.asInstanceOf[TestEvent]))
          if (showFailures) {
            args.reporter(e)
          }
        case event: Event =>
          args.reporter(event)
      }
    )
  )
}
