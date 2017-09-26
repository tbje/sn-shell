package tbje.snShell

import utest._
import Shell._
import java.nio.file.Paths

object ShellTests extends TestSuite{
  val tests = Tests{
    'currentDir  - {
      val path = Paths.get(".")
      val res = runCommand("pwd")
      assert (res.isDefined == true)
      val pathString = path.toAbsolutePath().toString.replace("/.", "")
      val resSome = res.get.trim
      assert(resSome == pathString)
    }
    'rootDir  - {
      val res = runCommand("pwd", Some("/"))
      assert (res.isDefined == true)
      val resSome = res.get.trim
      assert(resSome == "/")
    }
  }
}
