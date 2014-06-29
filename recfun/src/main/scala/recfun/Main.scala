package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c==0 || r == c) 1
    else pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def bal(chars: List[Char], numOpen: Int): Boolean =
      if (chars.isEmpty) numOpen == 0
      else if (chars.head == '(') bal(chars.tail,numOpen+1)
      else if (chars.head == ')') numOpen > 0 && bal(chars.tail, numOpen-1)
      else bal(chars.tail,numOpen)
    bal(chars,0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def cnt(cap: Int, change: List[Int]): Int = {
      if (cap == 0) 1
      else if (cap < 0) 0
      else if (change.isEmpty && cap >= 1) 0
      else cnt(cap, change.tail) + cnt(cap - change.head, change)
    }
    cnt(money, coins.sortWith(_.compareTo(_) < 0))
  }
}
