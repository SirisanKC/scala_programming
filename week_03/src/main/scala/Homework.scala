/*
 * Exercise 3 - Higher Order Functions in Scala
 * Name: Sirisan KC
 * Student ID: 002321279
 */

object Homework {


  /**
   *Problem 1: operateOnList function
   *
   *
   * Transforms a list of integers by converting odd numbers to even,
   * then filters to keep only even numbers in the result.
   *
   * @param numbers   The input list of integers to process
   * @param oddToEven A function that converts odd integers to even
   * @return A new list containing only even numbers after transformation
   *
   *         Example: operateOnList(List(1,2,3), n => if odd then n+1 else n) returns List(2,2,4)
   */
  def operateOnList(numbers: List[Int], oddToEven: Int => Int): List[Int] = {
    numbers.map(oddToEven).filter(_ % 2 == 0)
  }




  /**
   * Problem 2: filterAndMap function
   *
   *
   * Filters strings based on length predicate and then applies a transformation
   * to each remaining element.
   *
   * @param strings       The input list of strings to process
   * @param greaterLength Predicate function to test string length (>6 characters)
   * @param concat        Transformation function to apply to each filtered string
   * @return A new list of transformed strings that meet the length criteria
   *
   *         Example: filterAndMap(List("hello","world"), s => s.length>5, s => s+s.length)
   *         would return List("world5") if "world" was >5 characters
   */
  def filterAndMap(
                    strings: List[String],
                    greaterLength: String => Boolean,
                    concat: String => String
                  ): List[String] = {
    strings.filter(greaterLength).map(concat)
  }






  /**
   * Problem 3: Polymorphic listTransformation function
   *
   *
   * A polymorphic higher-order function that transforms each element in a list.
   * Works with any input type A and any output type B.
   *
   * @param list          The input list of elements of type A
   * @param transformFunc Function to convert elements from type A to type B
   * @return A new list with all elements transformed to type B
   *
   *         Example 1: listTransformation(List("a","bb"), s => s.length) returns List(1,2)
   *         Example 2: listTransformation(List(1,2), n => n*2.0) returns List(2.0,4.0)
   */
  def listTransformation[A, B](list: List[A], transformFunc: A => B): List[B] = {
    list.map(transformFunc)
  }





  /**
   * Problem 4: Currying and partially applied functions
   *
   *
   * A curried function that calculates the product of three integers.
   * Currying allows partial application of arguments.
   *
   * @param x First multiplicand
   * @param y Second multiplicand
   * @param z Third multiplicand
   * @return The product x * y * z
   */
  def curriedProduct(x: Int)(y: Int)(z: Int): Int = x * y * z



  /**
   * A partially applied function created from curriedProduct,
   * with the first argument fixed as 10. This creates a new
   * function that takes two Ints and multiplies them by 10.
   */
  val multiplyByTen: (Int, Int) => Int = curriedProduct(10)(_)(_)




  // Main function to demonstrate all the implementations
  def main(args: Array[String]): Unit = {
    println("=== Problem 1: operateOnList ===")
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val oddToEvenFunc = (n: Int) => if (n % 2 != 0) n + 1 else n
    val result1 = operateOnList(numbers, oddToEvenFunc)
    println(s"Original list: $numbers")
    println(s"Transformed list (all even): $result1")



    println("\n=== Problem 2: filterAndMap ===")
    val strings = List("apple", "banana", "orange", "grape", "watermelon")
    val greaterLengthFunc = (s: String) => s.length > 6
    val concatFunc = (s: String) => s + s.length
    val result2 = filterAndMap(strings, greaterLengthFunc, concatFunc)
    println(s"Original strings: $strings")
    println(s"Filtered and mapped strings: $result2")




    println("\n=== Problem 3: listTransformation ===")
    println("Example 1")
    val stringList = List("hello", "world", "scala", "functional")
    val stringToLength = (s: String) => s.length
    val result3a = listTransformation(stringList, stringToLength)
    println(s"Strings: $stringList")
    println(s"String lengths: $result3a")

    val intList = List(1, 2, 3, 4, 5)
    val intToDouble = (n: Int) => n * 2
    val result3b = listTransformation(intList, intToDouble)
    println(s"Integers: $intList")
    println(s"Doubled values: $result3b")

    //example 2
    println("\nExample 2")
    val stringList1 = List("python", "java", "programming", "coding")
    val stringToLength1 = (s: String) => s.length
    val result4a = listTransformation(stringList1, stringToLength1)
    println(s"Strings: $stringList1")
    println(s"String lengths: $result4a")

    val intList1 = List(6, 7, 8, 9)
    val intToDouble1 = (n: Int) => n * 2
    val result4b = listTransformation(intList1, intToDouble1)
    println(s"Integers: $intList1")
    println(s"Doubled values: $result4b")





    println("\n=== Problem 4: Currying and Partial Application ===")
    // Using the curried function directly
    val product1 = curriedProduct(2)(3)(4)
    println(s"Product of 2 * 3 * 4: $product1")

    // Using the partially applied function
    val product2 = multiplyByTen(5, 6)
    println(s"Product of 10 * 5 * 6: $product2")

    val product3 = multiplyByTen(9, 4)
    println(s"Product of 10 * 9 * 4: $product3")
  }
}