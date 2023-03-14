package leetcode

object Solution {
  def longestConsecutive1(nums: Array[Int]): Int = {
    val set = collection.mutable.Set.from(nums)
    val nxt = collection.mutable.Set.empty[Int]
    var mxLen = 0
    while (set.nonEmpty) {
      val n1 = set.head
      set -= n1
      nxt += n1

      var tmp = 0
      while (nxt.nonEmpty) {
        val n = nxt.head
        nxt -= n
        tmp += 1
        if (set.remove(n + 1)) nxt += (n + 1)
        if (set.remove(n - 1)) nxt += (n - 1)
      }

      mxLen = tmp max mxLen
    }

    mxLen
  }

  def longestConsecutive2(nums: Array[Int]): Int = {
    val sorted = nums.sorted.distinct
    var mxLen = 0

    var idx = 0
    while (idx < sorted.length) {
      var tmp = 1
      while (idx + 1 < sorted.length && sorted(idx) + 1 == sorted(idx + 1)) {
        tmp += 1
        idx += 1
      }
      mxLen = tmp max mxLen
      idx += 1
    }
    mxLen
  }
}