package leetcode

object Solution {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    strs.toList.groupBy(_.sorted).values.toList
  }
}