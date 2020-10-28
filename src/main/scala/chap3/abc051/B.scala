package chap3.abc051

import java.util.Scanner

// https://atcoder.jp/contests/abc051/submissions/17709252
object Main extends App {
  val sc = new Scanner(System.in)
  val k, s = sc.nextInt
  val ans = (0 to k).foldLeft(0) { (acc1, x) =>
    (0 to k).foldLeft(acc1) { (acc2, y) =>
      val z = s - x - y
      acc2 + (if (0 <= z && z <= k) 1 else 0)
    }
  }
  println(ans)
}
