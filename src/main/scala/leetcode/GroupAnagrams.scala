package leetcode

object Solution {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    strs.toList.zipWithIndex.map {
      case (s, i) => s.toSeq.sorted.unwrap -> i
    }.groupBy(_._1).values.map(_.map { case (_, i) => strs(i) }).toList
  }
}