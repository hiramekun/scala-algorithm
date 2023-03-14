package leetcode

object Solution {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val n = nums.sizeIs
    val result = new Array[Int](n)
    result(0) = 1
    for (i <- 0 until n - 1) {
      result(i + 1) = result(i) * nums(i)
    }
    var rightProducts = 1
    for (i <- 0 until n) {
      result(n - i - 1) *= rightProducts
      rightProducts *= nums(n - i - 1)
    }
    result
  }
}