package leetcode

object Solution {
  def lengthOfLongestSubstring(s: String): Int = {
    var chars = collection.mutable.Map.empty[Char, Int]

    var left = 0
    var right = 0

    var res = 0
    while (right < s.length()) {
      val r = s(right)
      chars += (r -> (chars.getOrElse(r, 0) + 1))

      while (chars.getOrElse(r, 0) > 1) {
        val l = s(left)
        chars += (l -> (chars.getOrElse(l, 0) - 1))
        left += 1
      }

      res = res max (right - left + 1)

      right += 1
    }
    res
  }
}
