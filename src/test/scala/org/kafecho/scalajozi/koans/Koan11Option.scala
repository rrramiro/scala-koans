package org.kafecho.scalajozi.koans

import fr.ramiro.scala.koans.KoanFunSuite
import org.scalatest.Matchers

class Koan11Option extends KoanFunSuite with Matchers {
  koan("An option represents an optional typed value.") {
    val optionA: Option[Int] = Some(5)
    val optionB: Option[Int] = None

    optionA.isDefined should be(true)
    optionB.isDefined should be(__)
  }

  koan("You can think of an Option as a container for a single value") {
    val optionA = Some(10)
    val optionB = optionA.map(value => value * 10)
    optionB should equal(Some(100))
  }

  koan("Chain options with orElse") {
    val optionA = None
    val optionB = Some(10)

    (optionA orElse optionB) should equal(optionB)
  }

  koan("Get default value for option") {
    val user: Option[String] = None
    val name = user.getOrElse("Fred")
    name should equal(__)
  }

}
