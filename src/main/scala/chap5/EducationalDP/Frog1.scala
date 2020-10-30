package chap5.EducationalDP

import scala.io.StdIn

object Main extends App {
  val n = StdIn.readInt
  val h = StdIn.readLine.split(" ").map(_.toInt)

  val dp = Array.ofDim[Int](n)
  dp(1) = dp(0) + (h(1) - h(0)).abs
  for (i <- 2 until n) {
    dp(i) = math.min(dp(i - 1) + (h(i - 1) - h(i)).abs, dp(i - 2) + (h(i - 2) - h(i)).abs)
  }
  println(dp(n - 1))
}
