package chap5.EducationalDP

import scala.io.StdIn

object Main extends App {
  val n = StdIn.readInt()
  val abc = Array.ofDim[Int](n, 3)
  for (i <- 0 until n) {
    abc(i) = StdIn.readLine().split(" ").map(_.toInt)
  }
  val dp = Array.ofDim[Int](n + 1, 3)

  def rec(idx: Int, item: Int): Int = {
    if (idx == 0) 0
    else if (dp(idx)(item) > 0) dp(idx)(item)
    else {
      var temp = 0
      for (i <- 0 until 3 if i != item) {
        temp = math.max(temp, rec(idx - 1, i) + abc(idx - 1)(item))
      }
      dp(idx)(item) = math.max(dp(idx)(item), temp)
      dp(idx)(item)
    }
  }

  def rrec: Int = (for {i <- 0 until 3} yield rec(n, i)).max

  println(rrec)
}
