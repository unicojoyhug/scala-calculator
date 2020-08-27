name := "scala-calculator"

version := "0.1"

scalaVersion := "2.13.3"

libraryDependencies += "org.scalafx" %% "scalafx" % "14-R19"
libraryDependencies += "org.scalatest" %% "scalatest-funsuite" % "3.2.0" % "test"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.9"


// Add OS specific JavaFX dependencies

val javafxModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux") => "linux"
  case n if n.startsWith("Mac") => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}
libraryDependencies ++= javafxModules.map(m => "org.openjfx" % s"javafx-$m" % "14.0.1" classifier osName)

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

dockerBaseImage := "openjdk:11"
mainClass in Compile := Some("calculator.Main")

//https://blog.elegantmonkeys.com/dockerizing-your-scala-application-6590385fd501

test in assembly := {}
// Simple and constant jar name
assemblyJarName in assembly := s"app-assembly.jar"
// Merge strategy for assembling conflicts
assemblyMergeStrategy in assembly := {
  case PathList("reference.conf") => MergeStrategy.concat
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case _ => MergeStrategy.first
}


// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true
