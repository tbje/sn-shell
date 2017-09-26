package tbje.snShell

import scalanative.native._, stdlib._, stdio._

@extern
object Pipe {
  def popen(cmd: CString, mode: CString): Ptr[FILE]  = extern
  def pclose(file: Ptr[FILE]): Unit = extern
}

object Shell {
  def runCommand(cmd: String, cwd: Option[String] = None): Option[String] =
    Zone { implicit z =>
      val buff = alloc[CChar](100)
      val s = new StringBuilder()
      val fullCmd = cwd.map(dir => s"cd $dir && ").getOrElse("") + cmd
      Pipe.popen(toCString(fullCmd), toCString("r")) match {
        case null =>
          None
        case filePtr =>
          while (fgets(buff, 100, filePtr) != null) {
            s.++=(fromCString(buff))
          }
          Pipe.pclose(filePtr)
          Some(s.result())
      }
    }
}
