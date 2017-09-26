## sn-shell - simple lib for running shell commands for ScalaNative

Wrapper over using popen to run shell commands.

Example:
```scala
import tbje.snShell.Shell._

runCommand("ls -l").foreach{ _.lines.foreach(x => println ("  " + x)) }

runCommand("pwd", cwd = Some("test"))
```

In build.sbt or somewhere in the project directory :
```
libraryDependencies += "com.github.tbje" %%% "sn-shell" % "0.1-SNAPSHOT"
```
