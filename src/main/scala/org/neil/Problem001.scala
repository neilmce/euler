package org.neil

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
object Problem001 {

  def main(args: Array[String]):Unit = {

    // Brute force solution is O(n)
    def bruteForce(): Int = {
      val multiples = for (i <- 1 until 1000 if i % 3 == 0 || i % 5 == 0) yield i
      multiples.sum
    }

    // This more elegant solution uses some basic maths and is O(1)
    def moreElegant(): Int = {
      def sumOfMultiples(num: Int, upTo: Int): Int = {
        // Consider:
        // num = 3; upTo = 10
        // sum of multiples = (1 * 3) + (2 * 3) + (3 * 3)
        //
        // more generally:
        // sum of multiples = num + 2num + 3num + ... to (upTo/num)num
        //                  = upTo/num * ((upTo/num + 1) / 2)
        val highestMultipleFactor: Int = upTo / num // this will be rounded down e.g. (8 / 3) = 2. 2nd multiple
        num * highestMultipleFactor * (highestMultipleFactor + 1) / 2
      }
      sumOfMultiples(3, 999) + sumOfMultiples(5, 999) - sumOfMultiples(15, 999)
    }

    println(s"Brute force sum = ${bruteForce()}")
    println(s"More elegant sum = ${moreElegant()}")
  }
}
