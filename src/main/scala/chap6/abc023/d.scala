package chap6.abc023

import scala.annotation.tailrec
import scala.io.StdIn._

case class Balloon(id: Int, h: Long, s: Long)

object Main {

  import Util._

  def solve(): Unit = {
    val n = readInt()
    val balloons = repYield(n) { i =>
      val hs = readLine().split(" ")
      val h = hs(0).toLong
      val s = hs(1).toLong
      Balloon(i, h, s)
    }.toVector

    @tailrec
    def rec(l: Long, r: Long, condition: Long => Boolean): Long = {
      val mid = (r + l) / 2
      if (r <= l + 1) r
      else if (condition(mid)) rec(l, mid, condition)
      else rec(mid, r, condition)
    }

    val ans = rec(-1.toLong, 1e15.toLong, { cost =>
      balloons.forall(cost >= _.h) &&
        balloons.map(b => ((cost - b.h).toDouble / b.s).floor.toLong)
          .sorted.zipWithIndex
          .forall(ti => ti._1 >= ti._2)
    })
    println(ans)
  }

  def main(args: Array[String]): Unit = solve()
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


