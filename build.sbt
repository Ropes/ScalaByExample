name := "Scala Examples"

version := "0.1"

scalaVersion := "2.10.4"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.1.3"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

libraryDependencies +=
    "com.typesafe.akka" %% "akka-actor" % "2.3.2"

exportJars := true
