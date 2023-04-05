package leetcode

class Solution {
  def maxArea(height: Array[Int]): Int = {
    var maxArea = 0
    var left = 0
    var right = height.length - 1
    while (left < right) {
      val width = right - left
      maxArea = math.max(maxArea, math.min(height(left), height(right)) * width)
      if (height(left) <= height(right)) {
        left += 1
      } else {
        right -= 1
      }
    }
    maxArea
  }
}
