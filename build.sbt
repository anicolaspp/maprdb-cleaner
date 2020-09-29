name := "maprdb-cleaner"

organization := "com.github.anicolaspp"

version := "1.0.1"

scalaVersion := "2.11.8"

resolvers += "MapR Releases" at "http://repository.mapr.com/maven"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.mapr.ojai" % "mapr-ojai-driver" % "6.1.0-mapr" % "provided",
  "org.apache.hadoop" % "hadoop-client" % "2.7.0-mapr-1808" % "provided",
  "com.mapr.db" % "maprdb" % "6.1.0-mapr" % "provided",
  "commons-logging" % "commons-logging" % "1.2" % "provided",
  "xerces" % "xercesImpl" % "2.11.0" % "provided",
  "com.github.scopt" % "scopt_2.11" % "3.7.0"
)  .map(_.exclude("org.slf4j", "slf4j-log4j12"))

libraryDependencies += "com.github.anicolaspp" % "dojai" % "1.0.0"

assemblyJarName := s"maprdbcls-${version.value}.jar"