

object Exercise04 {

  /**
   * Task 0: Basic Collection Operations
   *
   * Demonstrates fundamental operations on different collection types:
   * - List creation and transformation
   * - Set operations
   * - Map creation and access
   *
   * Shows usage of common higher-order functions like map, filter, and foldLeft.
   */
  def task0(): Unit = {
    println("\n=== Task 0: Collection Basics ===")

    // Create a range of numbers from 1 to 10 as an immutable List
    val nums: List[Int] = (1 to 10).toList
    println(s"Original list: $nums")

    // Transform each number to its square using map
    val squares: List[Int] = nums.map(x => x * x)
    println(s"Squares: $squares")

    // Filter to keep only even numbers from the squares list
    val evenSquares: List[Int] = squares.filter(_ % 2 == 0)
    println(s"Even squares: $evenSquares")

    // Convert even numbers to a Set to eliminate duplicates (though none exist here)
    val evenSet: Set[Int] = nums.filter(_ % 2 == 0).toSet
    println(s"Even set: $evenSet")

    // Calculate sum using foldLeft (more functional alternative to sum)
    val sumEven: Int = evenSet.foldLeft(0)(_ + _)
    println(s"Sum of even numbers: $sumEven")

    // Create a mapping from numbers to their squares
    val squaresMap: Map[Int, Int] = nums.map(n => (n, n * n)).toMap
    println(s"Squares map: $squaresMap")

    // Safely get a value from map with default if key doesn't exist
    val squareOf11: Int = squaresMap.getOrElse(11, 0)
    println(s"Square of 11: $squareOf11")
  }

  /**
   * Task 1: Remove Duplicates from Sequence
   *
   * @param seq Input sequence of strings that may contain duplicates
   * @return Sequence with only unique elements, preserving first occurrence order
   *
   * Implementation uses foldLeft to build result incrementally:
   * - Start with empty sequence
   * - For each element, check if already in accumulator
   * - If not present, append to accumulator
   */
  def removeDuplicates(seq: Seq[String]): Seq[String] = {
    seq.foldLeft(Seq.empty[String]) { (acc, elem) =>
      if (acc.contains(elem)) acc else acc :+ elem
    }
  }

  /**
   * Task 2: Find Common Elements Between Sets
   *
   * @param set1 First input set of generic type A
   * @param set2 Second input set of same type
   * @return New set containing only elements present in both input sets
   *
   * Uses Scala's built-in intersect method which is optimized for set operations.
   * Works with any type that implements proper equality comparison.
   */
  def findCommonElements[A](set1: Set[A], set2: Set[A]): Set[A] = {
    set1.intersect(set2)
  }

  /**
   * Task 3: Remove Specified Keys from Map
   *
   * @param map Original immutable map
   * @param keysToRemove List of keys to remove
   * @return New map with specified keys removed
   *
   * Uses foldLeft to apply multiple removals sequentially.
   * If a key doesn't exist in original map, it's safely ignored.
   */
  def removeKeys[K, V](map: Map[K, V], keysToRemove: List[K]): Map[K, V] = {
    keysToRemove.foldLeft(map)((currentMap, key) => currentMap - key)
  }

  /**
   * Task 4: Word Frequency Counter
   *
   * @param filename Path to text file to analyze
   * @return Map where keys are words and values are their counts
   *
   * Handles file operations safely with try-finally.
   * Processing steps:
   * 1. Read lines from file
   * 2. Split each line into words (split on non-word characters)
   * 3. Filter out empty strings
   * 4. Count occurrences using immutable map with foldLeft
   */
  def countWords(filename: String): Vector[(String, Int)] = {
    val source = scala.io.Source.fromFile(filename)
    try {
      val words = source.getLines()
        .flatMap(_.split("\\s+")) // Split on whitespace
        .filter(_.nonEmpty) // Remove empty strings
        .toVector

      // Create a case-insensitive map for counting
      val countMap = words.foldLeft(Map.empty[String, Int]) { (map, word) =>
        val lowerWord = word.toLowerCase
        map + (lowerWord -> (map.getOrElse(lowerWord, 0) + 1))
      }

      // Get unique words in order of first appearance (case-sensitive)
      val uniqueWords = words.foldLeft(Vector.empty[String]) { (acc, word) =>
        if (acc.exists(_.equalsIgnoreCase(word))) acc else acc :+ word
      }

      // Create result with original case but case-insensitive counts
      uniqueWords.map { word =>
        (word, countMap(word.toLowerCase))
      }
    } finally {
      source.close()
    }
  }

  /**
   * Main Program - Demonstrates All Tasks
   *
   * Shows example usage of each implemented function with:
   * - Clear section headers
   * - Sample inputs
   * - Formatted output
   * - Graceful error handling for file operations
   */
  def main(args: Array[String]): Unit = {
    // Demonstrate basic collection operations
    task0()

    // Task 1 - Remove duplicates
    println("\n=== Task 1: removeDuplicates ===")
    val testSeq = Seq("hello", "world", "hello", "scala", "world")
    println(s"Input sequence: ${testSeq.mkString(", ")}")
    val uniqueSeq = removeDuplicates(testSeq)
    println(s"Unique elements: ${uniqueSeq.mkString(", ")}")

    // Task 2 - Set intersection
    println("\n=== Task 2: findCommonElements ===")
    val setA = Set(1, 2, 3, 4, 5)
    val setB = Set(3, 4, 5, 6, 7)
    println(s"Set 1: ${setA.toList.sorted.mkString(", ")}")
    println(s"Set 2: ${setB.toList.sorted.mkString(", ")}")
    val commonElements = findCommonElements(setA, setB)
    println(s"Common elements: ${commonElements.toList.sorted.mkString(", ")}")

    // Task 3 - Map key removal
    println("\n=== Task 3: removeKeys ===")
    val testMap = Map("a" -> 1, "b" -> 2, "c" -> 3, "d" -> 4)
    val keysToRemove = List("b", "d")
    println(s"Original map: ${testMap.mkString(", ")}")
    println(s"Keys to remove: ${keysToRemove.mkString(", ")}")
    val reducedMap = removeKeys(testMap, keysToRemove)
    println(s"Map after removal: ${reducedMap.mkString(", ")}")

    // Task 4 - Word counting with fallback demo
    println("\n=== Task 4: countWords ===")
    try {
      val wordCounts = countWords("sample.txt")
      println("Word counts:")
      wordCounts.foreach { case (word, count) => println(s"$word\t$count") }
    } catch {
      case _: java.io.FileNotFoundException =>
        println("File not found. Using sample text for demonstration:")
        val sampleText =
          """This is a test file.
            |It contains several lines.
            |Each line has some words.
            |Some words are repeated.
            |Others appear only once.""".stripMargin
        val words = sampleText.split("\\s+").filter(_.nonEmpty).toVector
        val countMap = words.foldLeft(Map.empty[String, Int]) { (map, word) =>
          val lowerWord = word.toLowerCase
          map + (lowerWord -> (map.getOrElse(lowerWord, 0) + 1))
        }
        val uniqueWords = words.foldLeft(Vector.empty[String]) { (acc, word) =>
          if (acc.exists(_.equalsIgnoreCase(word))) acc else acc :+ word
        }
        val wordCounts = uniqueWords.map { word =>
          (word, countMap(word.toLowerCase))
        }
        println("Word counts:")
        wordCounts.foreach { case (word, count) => println(s"$word\t$count") }
    }
  }
}