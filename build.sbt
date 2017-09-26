scalaVersion := "2.11.11"

organization := "tbje"

libraryDependencies += "com.lihaoyi" %%% "utest" % "0.5.3" % "test"

testFrameworks += new TestFramework("utest.runner.Framework")

nativeLinkStubs := true

enablePlugins(ScalaNativePlugin)
