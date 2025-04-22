# Scala Exception Handling - Exercise 6

## Overview

This project contains the solution for **Exercise 6** of the **Exception Handling in Functional Programming** course (Spring 2025, Lahti). The main objective is to explore conventional exception handling and alternative approaches using `Option` and `Either` data types in Scala, while implementing various tasks that utilize these concepts in a functional programming manner.

## Contents

The Scala file includes implementations for the following tasks:

1. **Task 1: Looking for Primes**  
   - Create a function `lookingForPrimes` that takes a list of integers and returns a list of `Either` type values. If the integer is prime, return `Right` with the prime integer. If the integer is not prime, return `Left` with an error message. Use `map` to apply this function to a list of integers and then use `foreach` to print the results or error messages.

2. **Task 2: Student Grades**  
   - Create a case class for a student that contains a name, age, and grade (an `Option[Int]`). Create a list of students with some missing grade values. Use `flatMap` to extract the grade values from each student, resulting in a list of `Int` values wrapped in `Option`. Then use `filter` to remove any `None` values and find the average grade of the remaining students using built-in functions or recursion (Important: No Loops).

3. **Task 3: Division Function**  
   - Create a function that takes two integers and returns an `Either` value. If the second integer is zero, return `Left` with an error message. Otherwise, return `Right` with the result of dividing the first integer by the second integer. Create a list of tuples containing pairs of integers, and use a higher-order function to apply this function to each pair, resulting in a list of `Either` values. Then use `partition` to separate the `Right` values from the `Left` values, and use `foldLeft` to find the sum of the `Right` values.

4. **Task 4: String Error Check**  
   - Create a function that takes a list of strings and returns an `Option` value. If any of the strings in the list contains the word "error", return `None`. Otherwise, return `Some` with the concatenated string of all strings in the list. Use a higher-order function to apply this function to a list of strings and then use pattern matching to handle the `Option` value. If `Some`, print the concatenated string. If `None`, print an error message.

## Instructions

To run the Scala file:

1. Ensure you have Scala installed.
2. Navigate to the folder containing the `Exercise06.scala` file.
3. Compile and run the code using:
   ```bash
   scalac Exercise06.scala
   scala Exercise06
