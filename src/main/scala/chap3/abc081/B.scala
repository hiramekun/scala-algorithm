package chap3.abc081

import java.util.Scanner

// https://atcoder.jp/contests/abc081/submissions/17709290
object Main extends App {
  val sc = new Scanner(System.in)
  val n = sc.nextInt
  var a = Array.fill(n)(sc.nextInt)
  var ans = 0

  while (!a.exists(_ % 2 == 1)) {
    a = a.map(_ / 2)
    ans += 1
  }
  println(ans)
}
