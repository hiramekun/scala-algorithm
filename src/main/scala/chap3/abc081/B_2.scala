package chap3.abc081

import scala.io.StdIn

// https://atcoder.jp/contests/abc081/submissions/17709351
object Main extends App {
  val n = StdIn.readInt
  val a = StdIn.readLine.split(" ").map { s =>
    var v = s.toInt
    var count = 0
    while (v % 2 == 0) {
      v /= 2
      count += 1
    }
    count
  }

  println(a.min)
}
