package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    // Exercise 1
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }

    // Exercise 2
//    var str1 = "(if (zero? x) max (/ 1 x))"
//    var str2 = "I told him (that it’s not (yet) done). (But he wasn’t listening)\n"
//    var str3 = ":-)"
//    var str4 = "())("
//
//    println("Balance " + str1)
//    println(balance(str1.toList))
//
//    println("Balance " + str2)
//    println(balance(str2.toList))
//
//    println("Balance " + str3)
//    println(balance(str3.toList))
//
//    println("Balance " + str4)
//    println(balance(str4.toList))

    // Exercise 3
//    println(countChange(4, List(1,2)))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || (c == r)) 1
    else pascal(c-1, r-1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */

  def balance(chars: List[Char]): Boolean = {

    var parCount = chars.count(_ == '(') + chars.count(_ == ')')

    if (parCount % 2 != 0 || chars.head == ')' || chars.tail == '(') false
    else {
      if (parCount == 0) true
      else {
        var spIndex = chars.lastIndexOf('(')
        var patchedString = chars.patch(spIndex, "", 1)
        balance(patchedString.patch(patchedString.indexOf(')', spIndex), "", 1))
      }
    }
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    if(money == 0) 1
    else if(money > 0 && !coins.isEmpty)
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    else 0

  }
}
