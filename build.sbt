name := "spark-ml"

version := "1.0"

scalaVersion := "2.10.0"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.10" % "test",
  "org.scalatest" %% "scalatest" % "2.1.3" % "test" withSources(),
	"org.apache.spark" %% "spark-core" % "0.9.0-incubating" withSources(),
	"org.apache.spark" %% "spark-mllib" % "0.9.0-incubating" withSources()
)

scalacOptions += "-deprecation"


