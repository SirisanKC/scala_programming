

object Homework6 {

  // ========== Task 1: Prime Number Check with Either ==========
  /**
   * Checks if a number is prime.
   * @param n The number to check
   * @return Boolean indicating primality
   */
  def isPrime(n: Int): Boolean = {
    if (n <= 1) false
    else if (n == 2) true
    else !(2 to Math.sqrt(n).toInt).exists(x => n % x == 0)
  }

  /**
   * Processes a list of numbers, classifying each as either prime (Right) or not prime (Left).
   * @param numbers List of integers to check
   * @return List of Either[String, Int] where Left contains error message and Right contains prime numbers
   */
  def lookingForPrimes(numbers: List[Int]): List[Either[String, Int]] = {
    numbers.map { n =>
      if (isPrime(n)) Right(n)
      else Left(s"$n is not a prime number")
    }
  }

  def executeTask1(): Unit = {
    println("===== Task 1 Results =====")
    val numbers = List(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    lookingForPrimes(numbers).foreach {
      case Right(prime) => println(s"$prime is a prime number")
      case Left(error)  => println(error)
    }
  }

  // ========== Task 2: Average Grade Calculation ==========
  /**
   * Case class representing a student with optional grade.
   * @param name Student's name
   * @param age Student's age
   * @param grade Optional integer representing student's grade
   */
  case class Student(name: String, age: Int, grade: Option[Int])

  // Sample list of students with some missing grades
  val students = List(
    Student("Alice", 20, Some(85)),
    Student("Bob", 21, None),
    Student("Charlie", 22, Some(90)),
    Student("Diana", 19, None),
    Student("Eve", 20, Some(78)),
    Student("Frank", 21, Some(92)),
    Student("Grace", 22, None)
  )

  /**
   * Calculates and prints the average grade of students, handling missing grades.
   * Demonstrates working with Option types in collections.
   */
  def calculateAverageGrade(): Unit = {
    println("\n===== Task 2 Results =====")

    // Extract all existing grades using flatMap to ignore None values
    val grades = students.flatMap(_.grade)

    // Calculate average only if there are grades available
    val average = if (grades.nonEmpty) Some(grades.sum.toDouble / grades.length) else None

    println("Valid grades:")
    println(grades)

    average match {
      case Some(avg) => println(f"Average grade: $avg%.2f")
      case None      => println("No grades available to calculate average")
    }
  }

  // ========== Task 3: Safe Division with Either ==========
  /**
   * Performs safe division operation using Either for error handling.
   * @param a Dividend
   * @param b Divisor
   * @return Either[String, Int] where Left contains error message and Right contains result
   */
  def safeDivide(a: Int, b: Int): Either[String, Int] = {
    if (b == 0) Left(s"Division by zero error: $a / $b")
    else Right(a / b)
  }

  def executeTask3(): Unit = {
    println("\n===== Task 3 Results =====")
    val pairs = List((10, 2), (5, 0), (8, 4), (7, 0), (12, 3), (9, 3), (15, 0))
    val results = pairs.map { case (a, b) => safeDivide(a, b) }

    // Partition results into errors and successes
    val (errors, successes) = results.partition(_.isLeft)

    println("Error messages:")
    errors.collect { case Left(msg) => msg }.foreach(println)

    println("\nSuccessful divisions:")
    successes.collect { case Right(value) => value }.foreach(println)

    // Calculate sum of all successful divisions
    val total = successes.foldLeft(0) {
      case (acc, Right(value)) => acc + value
      case (acc, _)           => acc
    }
    println(s"\nSum of successful divisions: $total")
  }

  // ========== Task 4: Error Checking in Strings with Option ==========
  /**
   * Concatenates strings if none contain the word "error" (case insensitive).
   * @param strings List of strings to concatenate
   * @return Option[String] where None indicates an error was found in input strings
   */
  def concatenateStrings(strings: List[String]): Option[String] = {
    if (strings.exists(_.toLowerCase.contains("error"))) None
    else Some(strings.mkString)
  }

  def executeTask4(): Unit = {
    println("\n===== Task 4 Results =====")
    val stringLists = List(
      List("No", "issues", "here"),
      List("This", "has", "an", "error"),
      List("Everything", "is", "fine"),
      List("Critical", "ERROR", "found"),
      List("Silent", "eRrOr", "detected")
    )

    stringLists.foreach { list =>
      concatenateStrings(list) match {
        case Some(result) => println(s"Concatenated string: $result")
        case None         => println("Error found in strings")
      }
    }
  }

  // ========== Main Method ==========
  /**
   * Entry point that executes all demonstration tasks.
   */
  def main(args: Array[String]): Unit = {
    executeTask1()
    calculateAverageGrade()
    executeTask3()
    executeTask4()
  }
}