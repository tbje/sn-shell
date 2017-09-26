scalaVersion := "2.11.11"

organization := "com.github.tbje"

testFrameworks += new TestFramework("utest.runner.Framework")

nativeLinkStubs := true

enablePlugins(ScalaNativePlugin)

addCommandAlias("prep", ";publishLocal;cleanCache")

libraryDependencies := Seq(
  "com.lihaoyi" %%% "utest" % "0.5.3" % "test"
)

publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

// Your profile name of the sonatype account. The default is the same with the organization value
sonatypeProfileName := "org.github.tbje"

// To sync with Maven central, you need to supply the following information:
publishMavenStyle := true

// License of your choice
licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
homepage := Some(url("https://github.com/tbje/sn-shell"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/tbje/sn-shell"),
    "https://github.com/tbje/sn-shell.git"
  )
)
developers := List(
  Developer(id="tbje", name="Trond Bjerkestrand", email="trond@groosker.com", url=url("https://trondbjerkestrand.no"))
)
