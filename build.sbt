organization := "hu.zomg"
name := "TumblrPlus"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.12.3"


resolvers += Classpaths.typesafeReleases

val scalatraVersion = "2.5.1"

      libraryDependencies ++= Seq(
        "com.typesafe.akka"       %%  "akka-actor"        % "2.4.12",
        "net.databinder.dispatch" %%  "dispatch-core"     % "0.13.2",
        "org.scalatra"            %%  "scalatra"          % scalatraVersion,
        "org.scalatra"            %%  "scalatra-scalate"  % scalatraVersion,
        "org.scalatra"            %%  "scalatra-specs2"   % scalatraVersion       % "test",
        "ch.qos.logback"          %   "logback-classic"   % "1.1.5"               % "runtime",
        "org.eclipse.jetty"       %   "jetty-webapp"      % "9.4.7.v20170914"     % "container",
        "javax.servlet"           %   "javax.servlet-api" % "3.1.0"               % "provided"
      )

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)
