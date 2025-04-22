

object Exercise07 {
  import scala.annotation.tailrec

  // Task 1 - Tail Recursive Sum
  /**
   * Calculates the sum of a list of integers using tail recursion
   * @param lst The list of integers to sum
   * @return The sum of all elements in the list
   */
  @tailrec
  def sumList(lst: List[Int], accumulator: Int = 0): Int = lst match {
    case Nil => accumulator
    case head :: tail => sumList(tail, accumulator + head)
  }

  // Task 2 - Error Detection in String List
  /**
   * Concatenates strings unless any contains "error" (case insensitive)
   * @param strings List of strings to process
   * @return Some(concatenated string) if no "error" found, None otherwise
   */
  def concatUnlessError(strings: List[String]): Option[String] = {
    if (strings.exists(_.toLowerCase.contains("error"))) None
    else Some(strings.mkString)
  }

  // Task 3 - Reflective Analysis
  /*
   * Functional programming offers clear benefits like immutability reducing side effects and making
   * code more predictable, especially for concurrent operations. The declarative style leads to
   * concise solutions for data transformations. However, I've found the learning curve steep when
   * transitioning from imperative programming. While pattern matching and Options provide robust
   * error handling, they can make simple tasks feel verbose. Performance optimization in pure FP
   * can be challenging compared to traditional approaches. Overall, FP's advantages in code
   * reliability and maintainability make it valuable, though pragmatic mixing with OOP often
   * works best in real-world projects.
   */

  // Test cases
  def main(args: Array[String]): Unit = {
    // Test sumList
    println("Task 1 - sumList:")
    println(sumList(List(1, 2, 3)))  // Should print 6
    println(sumList(List(10, 20)))   // Should print 30
    println(sumList(List()))         // Should print 0

    // Test concatUnlessError
    println("\nTask 2 - concatUnlessError:")
    println(concatUnlessError(List("Hello", "World")))      // Some("HelloWorld")
    println(concatUnlessError(List("error", "found")))      // None
    println(concatUnlessError(List("No", "ERROR", "here"))) // None
    println(concatUnlessError(List("Safe", "string")))      // Some("Safestring")
  }
}