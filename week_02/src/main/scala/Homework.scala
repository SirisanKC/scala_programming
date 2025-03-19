object Homework {

  def addition(a: Int, b: Int): Int = {
    if (b == 0) a
    else addition(a + 1, b - 1)
  }



  def subtraction(a: Int, b: Int): Int = {
    addition(a, -b)
  }


  def multiplication(a: Int, b: Int): Int = {
    if (b == 0) 0
    else addition(a, multiplication(a, b - 1))
  }


  def division(a: Int, b: Int): Either[String, Int] = {
    if (b == 0) Left("Error: Division by zero")
    else {
      var count = 0
      var dividend = a
      while (dividend >= b) {
        dividend -= b
        count += 1
      }
      Right(count)
    }
  }


  def factorial(n: Int): Int = {
    if (n == 0) 1
    else n * factorial(n - 1)
  }


  def isPrime(n: Int): Boolean = {
    if (n <= 1) false
    else {
      for (i <- 2 until n) {
        if (n % i == 0) return false
      }
      true
    }
  }


  def main(args: Array[String]): Unit = {
    println("\n--- Answer for Question 1 ---")
    println("Addition of 5 and 3: " + addition(5, 3))
    println("\n--- Answer for Question 2 ---")
    println("Subtraction of 5 and 3: " + subtraction(5, 3))
    println("\n--- Answer for Question 3 ---")
    println("Multiplication of 5 and 3: " + multiplication(5, 3))
    println("\n--- Answer for Question 4 ---")
    println("Division of 6 by 2: " + division(6, 2))
    println("Division of 6 by 0: " + division(6, 0))
    println("\n--- Answer for Question 5 ---")
    println("Factorial of 5: " + factorial(5))
    println("\n--- Answer for Question 6 ---")
    println("Is 7 a prime number? " + isPrime(7))
    println("Is 8 a prime number? " + isPrime(8))


    println("\n--- Answer for Question 7 ---")
    println(
      """How the memory is impacted by loops and recursions?
        |
        |Loops are memory-efficient because they reuse the same memory space for each iteration.
        |For example, in a loop like:
        |  def sumUsingLoop(n: Int): Int = {
        |    var result = 0
        |    for (i <- 1 to n) {
        |      result += i
        |    }
        |    result
        |  }
        |The memory usage is constant because only one variable `result` is updated in each iteration.
        |
        |Recursion, on the other hand, can be memory-intensive because each recursive call creates a new stack frame.
        |For example, in a recursive function like:
        |  def sumUsingRecursion(n: Int): Int = {
        |    if (n == 0) 0
        |    else n + sumUsingRecursion(n - 1)
        |  }
        |Each recursive call adds a new stack frame, which can lead to a stack overflow for large `n`.
        |
        |However, Scala supports tail recursion optimization, which reuses the same stack frame for tail-recursive functions,
        |making them as memory-efficient as loops. For example:
        |  def sumUsingTailRecursion(n: Int, acc: Int = 0): Int = {
        |    if (n == 0) acc
        |    else sumUsingTailRecursion(n - 1, acc + n)
        |  }
        |This function is optimized to use constant memory.
        |""".stripMargin)

    // Printing the answer for Question 8
    println("\n--- Answer for Question 8 ---")
    println(
      """What is the difference between local scope and global scope of variables (i.e., var/val)?
        |
        |Local Scope:
        |- Variables declared inside a function or block have local scope.
        |- They are only accessible within that function or block and are destroyed once the function or block completes execution.
        |- Example:
        |  def exampleFunction(): Unit = {
        |    val localVar = 10 // Local variable
        |    println(localVar) // Accessible here
        |  }
        |  // println(localVar) // Error: localVar is not accessible outside the function
        |
        |Global Scope:
        |- Variables declared outside of all functions or blocks have global scope.
        |- They are accessible from anywhere in the program, including inside functions and blocks.
        |- Example:
        |  val globalVar = 20 // Global variable
        |  def anotherFunction(): Unit = {
        |    println(globalVar) // Accessible here
        |  }
        |  println(globalVar) // Also accessible here
        |
        |Closure Concept:
        |- A closure is a function that captures variables from its surrounding environment (scope).
        |- Example:
        |  val globalVal = 5 // Global variable
        |  def outerFunction(x: Int): Int => Int = {
        |    val localVal = 10 // Local variable
        |    (y: Int) => x + y + localVal + globalVal // Closure capturing x, localVal, and globalVal
        |  }
        |  val closure = outerFunction(2)
        |  println(closure(3)) // Output: 20 (2 + 3 + 10 + 5)
        |""".stripMargin)
  }
  }






