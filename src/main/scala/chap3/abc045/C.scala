package chap3.abc045

import java.io.PrintWriter
import java.util.Scanner

// verified with https://atcoder.jp/contests/abc045/submissions/17696811
object Main extends App {
  val sc = new Scanner(System.in)
  val pw = new PrintWriter(System.out)
  val s = sc.next.map(_.toString.toInt)
  val pow2 = math.pow(2, s.length - 1).toInt

  var sum = 0L
  for (i <- 0 until pow2) {
    var now = 0L
    for (j <- 0 until s.length - 1) {
      now = now * 10 + s(j)
      if ((i & (1 << j)) > 0) {
        sum = sum + now
        now = 0
      }
    }
    now = now * 10 + s.last // 最後だけ別扱い
    sum = sum + now
  }
  pw.println(sum)
  pw.flush()
}
