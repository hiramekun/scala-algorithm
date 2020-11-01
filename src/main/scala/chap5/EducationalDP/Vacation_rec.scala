package chap5.EducationalDP

import scala.io.StdIn._

object Main {

  import Util._

  private def solve(): Unit = {
    val n = readInt()
    val abc = Array.ofDim[Int](n, 3)
    rep(n) {
      abc(_) = readLine().split(" ").map(_.toInt)
    }
    val dp = Array.ofDim[Int](n + 1, 3)

    def rec(idx: Int, item: Int): Int = {
      if (idx == 0) 0
      else if (dp(idx)(item) > 0) dp(idx)(item)
      else {
        var temp = 0
        rep(3) { i =>
          if (i != item) {
            temp = math.max(temp, rec(idx - 1, i) + abc(idx - 1)(item))
          }
        }
        dp(idx)(item) = math.max(dp(idx)(item), temp)
        dp(idx)(item)
      }
    }

    def rrec: Int = repYield(3)(rec(n, _)).max

    println(rrec)
  }

  def main(args: Array[String]): Unit = solve()
}

private object Util {
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
