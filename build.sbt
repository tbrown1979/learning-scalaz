name := """learning-scalaz"""

scalaVersion := "2.11.2"

val scalazVersion = "7.1.0"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.1.1",
  "org.specs2" %% "specs2-core" % "3.0.1" % "test",
  "org.scalaz" %% "scalaz-core" % scalazVersion,
  "org.scalaz" %% "scalaz-effect" % scalazVersion,
  "org.scalaz" %% "scalaz-typelevel" % scalazVersion,
  "org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion % "test"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalacOptions += "-feature"

scalacOptions in Test ++= Seq("-Yrangepos")

initialCommands in console := "import scalaz._, Scalaz._"
