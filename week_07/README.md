# README.md

## Functional Programming Assignment 07

### Overview
This assignment focuses on **Tail Recursion** and **Functional Error Handling** in Scala. The main objective is to implement tail-recursive functions and explore error handling using `Option` and `Either` data types in a functional programming style.

### Contents
The Scala file includes implementations for the following tasks:

#### Task 1: Tail Recursive Sum
- **Objective**: Write a tail-recursive function `sumList` that takes a list of integers and returns their sum.
- **Requirements**: Use the `@tailrec` annotation to ensure the function is optimized for performance and avoids stack overflow errors.

#### Task 2: Error Detection in String List
- **Objective**: Write a function `concatUnlessError` that takes a list of strings and returns an `Option[String]`.
- **Logic**: 
  - If any string contains the word "error", return `None`.
  - Otherwise, return `Some` with all strings concatenated.
- **Implementation**: Use higher-order functions to implement the logic effectively.

#### Task 3: Reflective Analysis
- **Objective**: Write a reflective analysis of functional programming.
- **Requirements**: Discuss the benefits and disadvantages of using the functional programming paradigm based on personal experience. The length should be equivalent to a paragraph (~5 lines) and added as comments in your `.scala` file.


Feel free to reach out if you have any questions or need further clarification on the tasks!
