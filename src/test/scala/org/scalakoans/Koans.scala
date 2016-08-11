package org.scalakoans

import fr.ramiro.scala.koans.KoansSuites

class Koans extends KoansSuites()(
  new AboutAsserts,
  new AboutValAndVar,
  new AboutLiterals,
  new AboutTuples,
  new AboutMethods,
  new AboutClasses,
  new AboutObjects,
  new AboutPackages,
  new AboutAbstractClasses,
  new AboutStructuralTypes,
  new AboutTraits,
  new AboutEmptyValues
)
