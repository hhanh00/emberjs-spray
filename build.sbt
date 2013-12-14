packageArchetype.java_application

name := "ember-scala"

scalaVersion := "2.10.3"

resolvers += "spray repo" at "http://repo.spray.io"

libraryDependencies ++= Seq(
  "io.spray" % "spray-can" % "1.2.0",
  "io.spray" % "spray-routing" % "1.2.0",
  "io.spray" %%  "spray-json" % "1.2.5",
  "com.typesafe.akka" %% "akka-actor" % "2.2.3")