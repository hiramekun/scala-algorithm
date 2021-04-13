package chap6.practice

import chap6.practice.Implicits._

import scala.annotation.tailrec

object Implicits {
  implicit def binarySearchWrap[T](arr: Vector[T])(implicit ord: Ordering[T]): BinarySearch[T] = BinarySearch(arr)
}

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

object BinarySearch extends App {
  final val n = 8
  final val arr = Vector(3, 5, 8, 10, 14, 7, 21, 39)
  assert(arr.find(10).get == 3)
  assert(arr.find(3).get == 0)
  assert(arr.find(-100).isEmpty)
  assert(arr.find(9).isEmpty)
  assert(arr.find(100).isEmpty)
  println("find: Success!!")

  assert(arr.lowerBound(10).get == 3)
  assert(arr.lowerBound(3).get == 0)
  assert(arr.lowerBound(-100).get == 0)
  assert(arr.lowerBound(9).get == 3)
  assert(arr.lowerBound(100).isEmpty)
  println("lowerBound: Success!!")
}