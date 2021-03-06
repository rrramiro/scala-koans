package org.functionalkoans.forscala

import fr.ramiro.scala.koans.KoanFunSuite
import org.scalatest.matchers.should.Matchers

import scala.reflect.runtime.universe._

class Candy

class AboutTypeTags extends KoanFunSuite with Matchers {

  koan("""TypeTags can be used to determine a type used
         |   before it erased by the VM by using an implicit TypeTag argument.""") {
    def inspect[T](l: List[T])(implicit tt: TypeTag[T]) = {
      tt.tpe.typeSymbol.name.decodedName.toString
    }
    val list = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
    inspect(list) should be(__)
  }

  koan("""TypeTags can also be """) {
    def inspect[T: TypeTag](l: List[T]) = typeOf[T].typeSymbol.name.decodedName.toString
    val list = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
    inspect(list) should be(__)
  }

  koan("""TypeTags can be attached to classes. TypeTags have other
        | meta-information about
         |  the type erased""") {
    class Barrel[T](implicit tt: TypeTag[T]) {
      //Simple-name of the class erased
      def +(t: T) = "1 %s has been added".format(tt.tpe.typeSymbol.name.decodedName.toString)
    }
    val candyBarrel = new Barrel[Candy]
    (candyBarrel + new Candy) should be(__)
  }
}
