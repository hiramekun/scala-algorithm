package leetcode

import scala.collection.mutable

object Solution {
  def containsDuplicate(nums: Array[Int]): Boolean = {
    val map = mutable.Set.empty[Int]
    nums.exists { i =>
      if (map.contains(i)) {
        true
      } else {
        map += i
        false
      }
    }
  }
}