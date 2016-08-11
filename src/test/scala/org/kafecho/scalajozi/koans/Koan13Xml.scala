package org.kafecho.scalajozi.koans

import fr.ramiro.scala.koans.KoanFunSuite
import org.scalatest.Matchers

import scala.xml.XML

class Koan13Xml extends KoanFunSuite with Matchers {

  koan("You can define an xml literal") {
    val xml = <xml>Hello World</xml>
    xml.text should equal("Hello World")
  }

  koan("The xml literal can have String interpolation") {
    val user = "Jacob"
    val xml = <xml>
                Hello
                { user }
              </xml>
    xml.text should equal(__)
  }

  koan("You can use an XPath like syntax to navigate the XML tree") {
    val xml = <foo>
                <bar>
                  <baz/>
                  Yebo
                </bar><bin/>
              </foo>
    val node = xml \ "foo" \ "far" \ "baz"
    node.text should be(__)
  }

  koan("Check the weather for Johannesburg") {
    val xml = XML.load(this.getClass.getResourceAsStream("/weather.xml"))
    //val xml = XML.load("http://weather.yahooapis.com/forecastrss?w=1582504&u=c")
    val temperature = xml \ "channel" \ "item" \ "condition" \ "@temp"
    println(s"The current temperature in Joburg is: $temperature degrees Celsius.")
  }
}
