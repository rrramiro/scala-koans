addCommandAlias("koans", "~testOnly org.functionalkoans.forscala.Koans")

addCommandAlias("koans2", "~testOnly org.kafecho.scalajozi.koans.Koans")

addCommandAlias("koans3", "~testOnly org.scalakoans.Koans")

name := "scala-koans"

version := "1.0"

scalaVersion := "2.13.5"

logLevel := Level.Info

// append -deprecation to the options passed to the Scala compiler
scalacOptions ++= Seq("-encoding", "UTF-8", "-deprecation", "-feature", "-unchecked")

// disable updating dynamic revisions (including -SNAPSHOT versions)
offline := true

libraryDependencies ++= Seq(
//  "com.github.ghik" % "silencer-lib" % "0.4",
  "org.scalatest" %% "scalatest" % "3.2.6" % "test" withSources() withJavadoc()
)

javacOptions ++= Seq("-encoding", "UTF-8")

javaOptions in (Test,run) += "-Xmx512M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=256m"

lazy val silencerVersion = "1.7.3"

ThisBuild / libraryDependencies ++= Seq(
  compilerPlugin("com.github.ghik" % "silencer-plugin" % silencerVersion cross CrossVersion.full),
  "com.github.ghik" % "silencer-lib" % silencerVersion % Provided cross CrossVersion.full
)

import scalariform.formatter.preferences._

scalariformPreferences := scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
  .setPreference(DoubleIndentConstructorArguments, false)
  .setPreference(DanglingCloseParenthesis, Preserve)


Global / onChangedBuildSource := ReloadOnSourceChanges