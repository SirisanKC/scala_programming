

// ========== Task 1: Generic Average Calculation ==========
/**
 * Demonstrates type parameterization by creating a generic function that
 * works with any numeric type (Int, Double, Float, etc.)
 */
object Task1 {
  /**
   * Calculates the average of a list of numbers using tail recursion
   *
   * @param list The list of numbers to average
   * @param num Implicit Numeric typeclass that provides math operations
   * @tparam A The numeric type (Int, Double, etc.)
   * @return The average value
   * @throws IllegalArgumentException if the input list is empty
   *
   * Note: Uses tail recursion for efficient stack usage with large lists
   */
  def average[A](list: List[A])(implicit num: Numeric[A]): A = {
    import num._ // Bring Numeric operations into scope

    // Inner tail-recursive helper function to calculate sum
    @annotation.tailrec
    def sumRecursive(remaining: List[A], accumulator: A): A = {
      remaining match {
        case Nil => accumulator // Base case: return accumulated sum
        case head :: tail => sumRecursive(tail, accumulator + head) // Recursive case
      }
    }

    if (list.isEmpty) {
      throw new IllegalArgumentException("Cannot compute average of empty list")
    } else {
      val total = sumRecursive(list, zero) // Calculate total sum
      num.fromInt(total.toInt / list.length) // Convert back to original type
    }
  }

  // Test cases demonstrating the function with different numeric types
  def test(): Unit = {
    println("\n=== Task 1 ===")
    println(s"Int average (1, 2, 3, 4, 5): ${average(List(1, 2, 3, 4, 5))}") // Expected: 3
    println(s"Double average (1.5, 2.5, 3.5): ${average(List(1.5, 2.5, 3.5))}") // Expected: 2.0
    println(s"Float average (1.0f, 2.0f, 3.0f): ${average(List(1.0f, 2.0f, 3.0f))}") // Expected: 2.0
  }
}

// ========== Task 2: Animal Hierarchy with Variance ==========
/**
 * Demonstrates covariance through a class hierarchy of animals.
 * Shows how lists of subtypes can be treated as lists of supertype.
 */
sealed trait Animal {
  /** @return The sound this animal makes */
  def makeSound: String
}

class Bird extends Animal {
  override def makeSound: String = "Chirp!" // Birds chirp
}

class Mammal extends Animal {
  override def makeSound: String = "Roar!" // Mammals roar
}

object Task2 {
  /**
   * Collects sounds from a list of animals
   *
   * @param animals List of Animal objects (accepts subtypes via covariance)
   * @return List of sounds as Strings
   *
   * Note: Works with any List[Animal] including List[Bird], List[Mammal], etc.
   */
  def makeAllSounds(animals: List[Animal]): List[String] = {
    animals.map(_.makeSound) // Transform each animal to its sound
  }

  // Test cases showing covariance in action
  def test(): Unit = {
    println("\n=== Task 2 ===")

    // Create lists of different animal types
    val birds = List(new Bird, new Bird)
    val mammals = List(new Mammal, new Mammal)
    val mixed = List(new Bird, new Mammal)

    // All these work due to List's covariance
    println(s"Birds say: ${makeAllSounds(birds)}") // List(Chirp!, Chirp!)
    println(s"Mammals say: ${makeAllSounds(mammals)}") // List(Roar!, Roar!)
    println(s"Mixed animals say: ${makeAllSounds(mixed)}") // List(Chirp!, Roar!)
  }
}

// ========== Task 3: Sortable Typeclass ==========
/**
 * Demonstrates type constraints using a typeclass pattern.
 * Allows sorting of different types while ensuring they have ordering.
 */
trait Sortable[A] {
  /** Sorts a list of elements that have an ordering */
  def sort(list: List[A]): List[A]
}

object Sortable {
  // Int sorter implementation
  implicit val intSortable: Sortable[Int] = new Sortable[Int] {
    def sort(list: List[Int]): List[Int] = list.sorted
  }

  // Double sorter implementation
  implicit val doubleSortable: Sortable[Double] = new Sortable[Double] {
    def sort(list: List[Double]): List[Double] = list.sorted
  }

  // String sorter implementation
  implicit val stringSortable: Sortable[String] = new Sortable[String] {
    def sort(list: List[String]): List[String] = list.sorted
  }
}

object Task3 {
  /**
   * Generic sorting function using the Sortable typeclass
   *
   * @param list The list to sort
   * @param ev Implicit Sortable instance for type A
   * @tparam A The element type that must have a Sortable instance
   * @return The sorted list
   */
  def sortList[A](list: List[A])(implicit ev: Sortable[A]): List[A] = {
    ev.sort(list) // Delegate to the typeclass implementation
  }

  // Test cases for different sortable types
  def test(): Unit = {
    println("\n=== Task 3 ===")
    println(s"Sorted integers: ${sortList(List(3, 1, 2))}")
    println(s"Sorted doubles: ${sortList(List(3.0, 1.0, 2.0))}")
    println(s"Sorted strings: ${sortList(List("c", "a", "b"))}")
  }
}

// ========== Task 4: Palindrome Checker ==========
/**
 * Demonstrates pattern matching with recursion to solve problems.
 * Checks if strings are palindromes (read the same forwards and backwards).
 */
object Task4 {
  /**
   * Determines if a string is a palindrome
   *
   * @param s The string to check
   * @return true if palindrome, false otherwise
   *
   * Uses recursive pattern matching:
   * - Empty/single-character strings are palindromes
   * - Compares first/last characters, then checks middle
   */
  def isPalindrome(s: String): Boolean = {
    s match {
      case "" => true // Empty string is palindrome
      case single if single.length == 1 => true // Single character is palindrome
      case _ if s.head == s.last => // First and last match
        isPalindrome(s.substring(1, s.length - 1)) // Check middle
      case _ => false // First/last don't match
    }
  }

  // Test cases for palindrome checking
  def test(): Unit = {
    println("\n=== Task 4 ===")
    println(s""""rotator" is palindrome: ${isPalindrome("rotator")}""")
    println(s""""scala" is palindrome: ${isPalindrome("scala")}""")
  }
}

// ========== Main Program ==========
/**
 * Entry point that runs all test cases
 */
object Homework5 {
  def main(args: Array[String]): Unit = {
    Task1.test() // Test generic average
    Task2.test() // Test animal sounds
    Task3.test() // Test sorting
    Task4.test() // Test palindrome checker

  }
}