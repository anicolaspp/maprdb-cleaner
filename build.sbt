name := "maprdb-cleaner"

organization := "com.github.anicolaspp"

version := "1.0.0"

scalaVersion := "2.11.8"

resolvers += "MapR Releases" at "http://repository.mapr.com/maven"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.mapr.db" % "maprdb" % "6.1.0-mapr" % "provided",
  "commons-logging" % "commons-logging" % "1.2" % "provided",
  "com.github.scopt" % "scopt_2.11" % "3.7.0"
)

//assemblyMergeStrategy in assembly := {
//  case PathList("org", "apache", "spark", "unused", xs@_*) => MergeStrategy.last
//  case x =>
//    val oldStrategy = (assemblyMergeStrategy in assembly).value
//    oldStrategy(x)
//}

assemblyJarName := s"${name.value}-${version.value}.jar"