package leetcode

object Solution {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val n = nums.sizeIs
    val is = nums.indices
    val leftProducts = new Array[Int](n + 1)
    val rightProducts = new Array[Int](n + 1)
    leftProducts(0) = 1
    rightProducts(0) = 1

    for (i <- is) {
      leftProducts(i + 1) = leftProducts(i) * nums(i)
      rightProducts(i + 1) = rightProducts(i) * nums(n - i - 1)
    }

    is.map(i => leftProducts(i) * rightProducts(n - i - 1)).toArray
  }
}