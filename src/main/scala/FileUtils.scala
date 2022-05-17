import java.io.File

object FileUtils extends App {
  getFilePaths("attach.dll").foreach(println)

  def getFilePaths(filename: String): Seq[String] = {
    sys.env("PATH")
      .split(File.pathSeparator)
      .filter(path => new File(path + s"${File.separator}$filename").exists())
      .toSet
      .toList
  }
}
