package fr.ramiro.scala.koans

import org.scalatest.{ FunSuite, Tag }

class KoanFunSuite extends FunSuite with KoanSuite {
  def koan(testName: String, testTags: Tag*)(testFun: => Unit): Unit = {
    test(testName, testTags: _*)(testFun)
  }
}
