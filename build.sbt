addCommandAlias("koans", "~testOnly org.functionalkoans.forscala.Koans")

addCommandAlias("koans2", "~testOnly org.kafecho.scalajozi.koans.Koans")

addCommandAlias("koans3", "~testOnly org.scalakoans.Koans")

name := "scala-koans"

version := "1.0"

scalaVersion := "2.12.2"

traceLevel := -1

logLevel := Level.Info

// disable printing timing information, but still print [success]
showTiming := false

// disable printing a message indicating the success or failure of running a task
showSuccess := false

// append -deprecation to the options passed to the Scala compiler
scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

// disable updating dynamic revisions (including -SNAPSHOT versions)
offline := true

libraryDependencies ++= Seq(
  "com.github.ghik" % "silencer-lib" % "0.4",
  "org.scalatest" %% "scalatest" % "3.0.2" % "test" withSources() withJavadoc()
)

javacOptions ++= Seq("-encoding", "UTF-8")

javaOptions in (Test,run) += "-Xmx512M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=256m"

addCompilerPlugin("com.github.ghik" % "silencer-plugin" % "0.4")

import scalariform.formatter.preferences._

scalariformPreferences := scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
  .setPreference(DoubleIndentConstructorArguments, false)
  .setPreference(DanglingCloseParenthesis, Preserve)
