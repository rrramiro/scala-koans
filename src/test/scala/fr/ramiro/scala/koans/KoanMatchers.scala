package fr.ramiro.scala.koans

import org.scalatest.exceptions.TestPendingException
import org.scalatest.matchers.Matcher

trait KoanMatchers {

  def __ : Matcher[Any] = {
    throw new TestPendingException
  }

  type ___ = Exception

}
