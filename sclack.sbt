import AssemblyKeys._

assemblySettings

name         := "sclack"

version      := "1.0"

scalaVersion := "2.10.0"

libraryDependencies ++= Seq(
  "org.scalatest"           % "scalatest_2.10"     % "1.9.1" % "test",
  "org.scalaquery"          % "scalaquery_2.9.0-1" % "0.9.5",
  "org.xerial"              % "sqlite-jdbc"        % "3.6.16",
  "org.scala-lang"          % "scala-swing"        % "2.10.0"
)

exportJars := true

