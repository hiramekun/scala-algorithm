package leetcode

object Solution {
  def isAnagram(s: String, t: String): Boolean = {
    s.toSeq.sorted == t.toSeq.sorted
  }
}