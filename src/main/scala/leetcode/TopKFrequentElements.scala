package leetcode

object Solution {
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
    nums.groupBy(i => i).toSeq.sortBy(_._2.sizeIs * -1).map(_._1).take(k).toArray
  }
}