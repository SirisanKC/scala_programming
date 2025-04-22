# README.md

## Scala Exception Handling - Exercise 6

### Overview
This project contains the solution for **Exercise 6** of the **Exception Handling in Functional Programming** course (Spring 2025, Lahti). The main objective is to explore conventional exception handling and alternative approaches using `Option` and `Either` data types in Scala, while implementing various tasks that utilize these concepts in a functional programming manner.

### Contents
The Scala file includes implementations for the following tasks:

#### Task 1: Looking for Primes
- **Objective**: Create a function `lookingForPrimes` that takes a list of integers and returns a list of `Either` type values.
- **Logic**: 
  - If the integer is prime, return `Right` with the prime integer.
  - If the integer is not prime, return `Left` with an error message.
- **Implementation**: Use `map` to apply this function to a list of integers and then use `foreach` to print the results or error messages.

#### Task 2: Student Grades
- **Objective**: Create a case class for a student that contains a name, age, and grade (`Option[Int]`).
- **Logic**: 
  - Create a list of students with some missing grade values.
  - Use `flatMap` to extract the grade values from each student, resulting in a list of `Int` values wrapped in `Option`.
  - Use `filter` to remove any `None` values and find the average grade of the remaining students using built-in functions or recursion (Important: No Loops).

#### Task 3: Division Function
- **Objective**: Create a function that takes two integers and returns an `Either` value.
- **Logic**: 
  - If the second integer is zero, return `Left` with an error message.
  - Otherwise, return `Right` with the result of dividing the first integer by the second integer.
- **Implementation**: 
  - Create a list of tuples containing pairs of integers.
  - Use a higher-order function to apply this function to each pair, resulting in a list of `Either` values.
  - Use `partition` to separate the `Right` values from the `Left` values, and use `foldLeft` to find the sum of the `Right` values.

#### Task 4: String Error Check
- **Objective**: Create a function that takes a list of strings and returns an `Option` value.
- **Logic**: 
  - If any of the strings in the list contains the word "error", return `None`.
  - Otherwise, return `Some` with the concatenated string of all strings in the list.
- **Implementation**: 
  - Use a higher-order function to apply this function to a list of strings.
  - Use pattern matching to handle the `Option` value. If `Some`, print the concatenated string. If `None`, print an error message.

### Instructions
To run the Scala file:

1. Ensure you have Scala installed.
2. Navigate to the folder containing the `Exercise06.scala` file.
3. Compile and run the code using:
   ```bash
   scalac Exercise06.scala
   scala Exercise06
   ```

### Additional Notes
- Make sure to handle all edge cases as specified in the tasks.
- Comment your code adequately to explain the logic and flow of the program.

Feel free to reach out if you have any questions or need further clarification on the tasks!
