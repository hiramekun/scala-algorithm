package leetcode

object Solution {
  def isPalindrome(s: String): Boolean = {
    val s2 = s.filter(_.isLetterOrDigit).toLowerCase
    s2 == s2.reverse
  }
}