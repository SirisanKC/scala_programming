# Scala Higher-Order Functions - Exercise 3

## Overview

This project contains the solution for **Exercise 3** of the **Higher Order Functions in Functional Programming** course (Spring 2025, Lahti). The main objective is to practice defining and using higher-order functions (HOFs), polymorphism, currying, and partially applied functions in Scala.

## Contents

The Scala file includes implementations for the following tasks:

1. **operateOnList**  
   A higher-order function that converts all odd integers in a list to even ones using a provided transformation function (`oddToEven`).

2. **filterAndMap**  
   A function that filters a list of strings based on length using a predicate function (`greaterLength`) and transforms them using a mapping function (`concat`).

3. **listTransformation**  
   A polymorphic higher-order function that accepts any data type list and a transformation function. Tested with:
   - Strings → their lengths
   - Integers → doubled values

4. **Currying and Partially Applied Functions**
   - A **curried function** that multiplies three integers.
   - A **partially applied function** to fix one argument.
   - Demonstration in a main function with at least three different test cases.

## Instructions

To run the Scala file:

1. Ensure you have Scala installed.
2. Navigate to the folder containing the `.scala` file.
3. Compile and run the code using:
   ```bash
   scalac HigherOrderFunctions.scala
   scala HigherOrderFunctions

