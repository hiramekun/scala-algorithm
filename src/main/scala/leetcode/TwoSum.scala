package leetcode

object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val zipped = nums.zipWithIndex
    val map = zipped.toMap

    zipped.collectFirst(Function.unlift {
      case (n, i) =>
        if (2 * n == target) map.get(n).find(_ > i).map(Array(_, i))
        else map.get(target - n).map(Array(_, i))
    }).get
  }
}