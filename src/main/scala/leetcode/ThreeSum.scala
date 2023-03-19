package leetcode

import scala.collection.mutable

object Solution {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val map = nums.zipWithIndex.toMap
    (
      for (
        i <- LazyList.range(0, nums.length - 2);
        j <- LazyList.range(i + 1, nums.length - 1);
        total = nums(i) + nums(j);
        l = List(nums(i), nums(j), -total).sorted if map.contains(-total) && map(-total) != i && map(-total) != j
      ) yield l
      ).distinct.toList
  }
}