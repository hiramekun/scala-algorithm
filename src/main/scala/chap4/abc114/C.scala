package chap4.abc114

import scala.io.StdIn

// https://atcoder.jp/contests/abc114/submissions/17722890
object Main extends App {
  val n = StdIn.readLong

  def dfs(now: Long, use7: Boolean, use5: Boolean, use3: Boolean): Int = {
    if (now > n) 0
    else {
      (if (use3 && use5 && use7) 1 else 0) +
        dfs(now * 10 + 3, use7, use5, use3 = true) +
        dfs(now * 10 + 5, use7, use5 = true, use3) +
        dfs(now * 10 + 7, use7 = true, use5, use3)
    }
  }

  println(dfs(0, use7 = false, use5 = false, use3 = false))
}
