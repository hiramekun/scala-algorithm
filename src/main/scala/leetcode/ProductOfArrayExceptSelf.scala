package leetcode

object Solution {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val n = nums.sizeIs
    val leftProducts = new Array[Int](n + 1)
    val rightProducts = new Array[Int](n + 1)
    leftProducts(0) = 1
    rightProducts(0) = 1

    for ((n, i) <- nums.zipWithIndex) {
      leftProducts(i + 1) = leftProducts(i) * n
    }

    for ((n, i) <- nums.reverse.zipWithIndex) {
      rightProducts(i + 1) = rightProducts(i) * n
    }

    nums.indices.map(i => leftProducts(i) * rightProducts(n - i - 1)).toArray

  }
}