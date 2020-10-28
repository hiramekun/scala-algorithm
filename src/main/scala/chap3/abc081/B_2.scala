package chap3.abc081

import java.io.PrintWriter
import java.util.Scanner

// fastest??
// https://atcoder.jp/contests/abc081/submissions/17709351
object Main extends App {
  val sc = new Scanner(System.in)
  val pw = new PrintWriter(System.out)
  val n = sc.nextInt
  val a = Array.fill(n)(sc.nextInt)

  for (i <- 0 until n) {
    var div = a(i)
    var count = 0
    while (div % 2 == 0) {
      div /= 2
      count += 1
    }
    a(i) = count
  }

  pw.println(a.min)
  pw.flush()
}
