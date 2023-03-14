package leetcode


object Solution {
  def isPalindrome(s: String): Boolean = {
    val s2 = s.filter(c => 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || '0' <= c && c <= '9').map(_.toLower)
    s2 == s2.reverse
  }
}