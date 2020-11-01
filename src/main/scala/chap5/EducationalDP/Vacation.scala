package chap5.EducationalDP

import scala.io.StdIn

object Main extends App {
  val n = StdIn.readInt()
  val abc = Array.ofDim[Int](n, 3)
  for (i <- 0 until n) {
    abc(i) = StdIn.readLine().split(" ").map(_.toInt)
  }
  val dp = Array.ofDim[Int](n + 1, 3)
  for (i <- 0 until n; j <- 0 until 3; k <- 0 until 3 if j != k) {
    dp(i + 1)(k) = math.max(dp(i + 1)(k), dp(i)(j) + abc(i)(k))
  }
  println(dp.last.max)
}
