val shared = Seq(
   organization := "hu.zomg",
   name := "TumblrPlus",
   version := "0.1.0-SNAPSHOT",
   scalaVersion := "2.12.3",
   // scalatraVersion := "2.2.2"
)

val scalatraVersion = "2.5.1"

lazy val projectRoot = (project in file("."))
    .enablePlugins(ScalatraPlugin)
    .settings(shared,
      libraryDependencies ++= Seq(
        "net.databinder.dispatch" %%  "dispatch-core"   % "0.13.2",
        "org.scalatra"            %%  "scalatra"        % scalatraVersion,
        "org.scalatra.scalate"    %%  "scalate-core"    % "1.8.0",
        "org.scalatra"            %%  "scalatra-specs2" % scalatraVersion       % "test",
        "ch.qos.logback"          %   "logback-classic" % "1.0.6"               % "runtime",
        "org.eclipse.jetty"       %   "jetty-webapp"    % "9.4.7.v20170914",
        "org.eclipse.jetty.orbit" %   "javax.servlet"   % "3.0.0.v201112011016" // % "container;provided;test" artifacts Artifact("javax.servlet", "jar", "jar")
      ))
