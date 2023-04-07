package leetcode

object Solution {
    def maxProfit(prices: Array[Int]): Int = {
        var now = 10_000
        var result = 0
        for (p <- prices) {
            result = math.max(result, p - now)
            if (p < now) now = p
        }
        result
    }
}