object NLastElements extends App {
  lastNElements(List(1,2,3,4,5,6,7), 3).foreach(println)

  def lastNElements(elems: Seq[Any], n: Int): Seq[Any] = {
    elems.foldLeft(List.empty[Any])((result, elem) => if (result.length < n) result :+ elem else result.tail :+ elem)
  }

}
