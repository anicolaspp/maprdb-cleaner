name := "maprdb-cleaner"

organization := "com.github.anicolaspp"

version := "1.0.0"

scalaVersion := "2.11.8"

resolvers += "MapR Releases" at "http://repository.mapr.com/maven"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.mapr.ojai" % "mapr-ojai-driver" % "6.1.0-mapr",
  "org.apache.hadoop" % "hadoop-client" % "2.7.0-mapr-1808",
  "com.mapr.db" % "maprdb" % "6.1.0-mapr",
  "commons-logging" % "commons-logging" % "1.2" % "provided",
  "xerces" % "xercesImpl" % "2.11.0",
  "com.github.scopt" % "scopt_2.11" % "3.7.0"
)

assemblyJarName := s"maprdbcls-${version.value}.jar"