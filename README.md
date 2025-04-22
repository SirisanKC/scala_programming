## Overview
Throughout this course, I engaged with various fundamental concepts of functional programming using Scala. Each exercise provided practical experience and deepened my understanding of the principles and techniques that define functional programming.

## Exercise 1: Basic Scala Syntax
### What I Learned:
- The basic syntax of Scala, including variable declarations (both immutable and mutable).
- Different data types such as Int, Boolean, Char, and Double.
- String composition and interpolation techniques.
- The concept of expressions and how they evaluate to a single value.

### What I Did:
- Created variables to demonstrate the difference between mutable (`var`) and immutable (`val`) types.
- Implemented examples of automatic type inference in Scala.
- Developed a simple function to concatenate my first and last name.

## Exercise 2: Functions & Recursion
### What I Learned:
- How to define functions in Scala and the importance of recursion in functional programming.
- The concept of using recursion to perform iterative tasks instead of traditional loops.

### What I Did:
- Implemented recursive functions for addition, subtraction, multiplication, and division.
- Created a factorial function using recursion and tested it with various inputs.
- Developed a function to check if a number is prime using recursive logic.

## Exercise 3: Higher Order Functions
### What I Learned:
- The definition and significance of higher-order functions (HOFs) in Scala.
- How to manipulate functions as first-class citizens, allowing them to be passed as arguments or returned as results.

### What I Did:
- Created a higher-order function called `operateOnList` to apply a transformation to a list of integers.
- Developed a `filterAndMap` function that filters strings based on length and concatenates their lengths.
- Implemented a polymorphic function `listTransformation` that works with any data type and transformation function.

## Exercise 4: Collections in Scala
### What I Learned:
- The different types of collections in Scala, including Sequences, Sets, and Maps.
- How to use built-in functions to manipulate collections effectively.

### What I Did:
- Created a list of integers and used the `map` method to generate a list of their squares.
- Implemented a function to remove duplicates from a sequence of strings using `foldLeft`.
- Developed a function to find common elements between two sets.

## Exercise 5: Type Parameterization
### What I Learned:
- The concept of type parameterization and its importance in creating generic code.
- Variance annotations (Covariant, Contravariant, Invariant) and their applications.

### What I Did:
- Implemented a generic function to compute the average of a list of numeric values.
- Created a class hierarchy for animals and used covariance to return a list of sounds from different animal types.
- Developed a type class for sorting objects and tested it with various data types.

## Exercise 6: Exception Handling
### What I Learned:
- The traditional approach to exception handling using try-catch blocks and its limitations.
- Functional alternatives like `Option` and `Either` for safer error handling.

### What I Did:
- Created functions that utilize `Option` and `Either` to handle potential errors without using traditional exception handling.
- Implemented error detection in a list of integers and strings using functional programming techniques.

## Exercise 7: Tail Recursion and Functional Error Handling
### What I Learned:
- The concept of tail recursion and its optimization in Scala.
- How to wrap exception-oriented APIs into functional wrappers for safer code.

### What I Did:
- Wrote a tail-recursive function to calculate the sum of a list of integers.
- Developed a function to concatenate strings while checking for errors, returning an `Option[String]`.

## Conclusion
This course has significantly enhanced my understanding of functional programming in Scala. I have gained practical experience in writing clean, efficient, and robust code while applying functional programming principles. Each exercise contributed to my growth as a programmer, equipping me with the skills to tackle real-world programming challenges using Scala.
