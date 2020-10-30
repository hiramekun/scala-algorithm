package chap5.EducationalDP

import scala.io.StdIn

object Main extends App {
  val n = StdIn.readInt
  val h = StdIn.readLine.split(" ").map(_.toInt)

  val inf = 1e9.toInt
  val dp = Array.fill[Int](n)(inf)

  def rec(now: Int): Int = {
    if (dp(now) != inf) dp(now)
    else if (now == 0) 0
    else {
      if (now >= 1) dp(now) = math.min(dp(now), rec(now - 1) + (h(now) - h(now - 1)).abs)
      if (now >= 2) dp(now) = math.min(dp(now), rec(now - 2) + (h(now) - h(now - 2)).abs)
      dp(now)
    }
  }

  println(rec(n - 1))
}
