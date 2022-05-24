object IntertwineLists extends App {
  intertwineLists(List("a", "b", "c", "d"), List(1, 2)).foreach(println)

  def intertwineLists(first: List[Any], second: List[Any]): List[Any] = {
    first.zipAll(second, (), ()).flatMap(_.productIterator.toList).filterNot(_ == ())
  }
}
