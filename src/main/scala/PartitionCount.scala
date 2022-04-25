import scala.collection.mutable

object PartitionCount {
  def partitionCount(n: Int): BigInt = {
    val partitionsCounts: mutable.Map[Int, BigInt] = mutable.Map.empty[Int, BigInt]

    def partitionCountHelper(n: Int): BigInt = {
      if (n == 0) return 1
      if (partitionsCounts.isDefinedAt(n)) partitionsCounts(n)

      val args = LazyList.from(1)
        .zip(LazyList.from(3, 2))
        .flatMap { case (i, j) => List(i, j)}
        .scanLeft(1)(_ + _)
        .map(n - _)
        .takeWhile(_ >= 0).toList

      val result = args
        .map(partitionCountHelper)
        .zip(LazyList.continually(List(1,1,-1,-1)).flatten)
        .map { case (pn, multiplier) => pn * multiplier }
        .sum

      partitionsCounts(n) = result
//      println(s"$n = $result")
      result
    }

    partitionCountHelper(n)
  }
}
