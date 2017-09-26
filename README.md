#: snShell - simple Shell for ScalaNative  :#

Wrapper over using popen to

```scala
import tbje.snShell.Shell._

runCommand("ls -l").foreach{ _.lines.foreach(x => println ("  " + x)) }

runCommand("pwd", cwd = Some("test"))
```
