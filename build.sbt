name := "spark-ml"

version := "1.0"

scalaVersion := "2.10.0"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
	"org.apache.spark" %% "spark-core" % "0.9.0-incubating",
	"org.apache.spark" %% "spark-mllib" % "0.9.0-incubating"
)

scalacOptions += "-deprecation"


