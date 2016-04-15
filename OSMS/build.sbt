name := """OSMS"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaCore,
    javaJpa,
     "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
  
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4"
  
)
