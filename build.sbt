lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.13.3"
    )),
    name := "scalatest-example"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.9.0"
//for logging but maybe dont need
// libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
// libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"
