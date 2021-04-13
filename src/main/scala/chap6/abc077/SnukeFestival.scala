package chap6.abc077

import scala.annotation.tailrec
import scala.io.StdIn._

case class BinarySearch[T](arr: Vector[T])(implicit ord: Ordering[T]) {

  import ord._

  /**
    * @return
    * the index of key element.
    * if does not exists, return None.
    */
  def find(key: T): Option[Int] = {
    @tailrec
    def rec(l: Int, r: Int, key: T): Option[Int] = {
      val mid = (r + l) / 2
      if (r < l) None
      else if (arr(mid) == key) Some(mid)
      else if (arr(mid) > key) rec(l, mid - 1, key)
      else rec(mid + 1, r, key)
    }

    val left = 0
    val right = arr.size - 1
    rec(left, right, key)
  }

  /**
    * @return
    * the minimum index which satisfies condition `arr(idx) > key`.
    * if any index does not satisfies the condition, return None.
    */
  def upperBound(key: T): Option[Int] = recByIndex(_ > key)

  /**
    * @return
    * the minimum index which satisfies condition `arr(idx) >= key`.
    * if any index does not satisfies the condition, return None.
    */
  def lowerBound(key: T): Option[Int] = recByIndex(_ >= key)

  private def recByIndex(condition: T => Boolean): Option[Int] = {
    @tailrec
    def rec(l: Int, r: Int): Option[Int] = {
      val mid = (r + l) / 2
      if (r <= l + 1) {
        if (r == arr.size) None
        else Some(r)
      }
      else if (condition(arr(mid))) rec(l, mid)
      else rec(mid, r)
    }

    rec(-1, arr.size)
  }
}

object Main {
  def solve(): Unit = {
    val n = readInt()
    val A = readLine().split(" ").map(_.toInt).sorted.toVector
    val B = readLine().split(" ").map(_.toInt).sorted.toVector
    val C = readLine().split(" ").map(_.toInt).sorted.toVector

    val binarySearchA = BinarySearch(A)
    val binarySearchC = BinarySearch(C)
    println(
      B.map { b =>
        binarySearchA.lowerBound(b).getOrElse(n).toLong * binarySearchC.upperBound(b).map(n - _).getOrElse(0).toLong
      }.sum
    )
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
