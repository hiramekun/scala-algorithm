package chap4.practice

import scala.annotation.tailrec

object Main extends App {
  @tailrec
  def GCD(m: Int, n: Int): Int = {
    if (n == 0) m
    else GCD(n, m % n)
  }

  assert(GCD(51, 15) == 3)
  assert(GCD(15, 51) == 3)
}

