import Util._

import scala.io.StdIn._

object Main extends App {
  val n = readInt()
  val p = readLine.split(" ").map(_.toInt)

  val values = n * p.max + 1
  val dp = Array.ofDim[Boolean](n + 1, values) // dp(i)(j): i番目の問題までで、j点が達成できるか

  dp(0)(0) = true

  rep(n) { i =>
    rep(values) { j =>
      if (dp(i)(j)) {
        dp(i + 1)(j) = true
        dp(i + 1)(j + p(i)) = true
      }
    }
  }
  println(dp.last.count(_ == true))
}

object Util {
  def rep(n: Int)(f: Int => Unit): Unit = for (i <- 0 until n) f(i)

  def repYield[T](n: Int)(f: Int => T): IndexedSeq[T] = for (i <- 0 until n) yield f(i)

  implicit class Extend[T](value: T) {
    def also(func: T => Unit): T = {
      func(value)
      value
    }

    def let[A](func: T => A): A = func(value)
  }

}
