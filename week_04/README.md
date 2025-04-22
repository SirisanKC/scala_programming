# Scala Collections - Exercise 4

## Overview

This project contains the solution for **Exercise 4** of the **Collections in Functional Programming** course (Spring 2025, Lahti). The main objective is to practice using different types of collections in Scala, including Sequences, Sets, and Maps, while utilizing Higher Order Functions (HOFs).

## Contents

The Scala file includes implementations for the following tasks:

1. **Task 0: Sequences, Sets & Maps Built-in Functions**  
   - Create a list of integers from 1 to 10.
   - Generate a list of squares of these integers.
   - Filter the even squares from the squares list.
   - Create a set of even numbers from the original list.
   - Calculate the sum of all elements in the even set using `foldLeft`.
   - Create a map that associates each number with its square.
   - Use `getOrElse` to retrieve the square of the number 11, returning 0 if not present.

2. **Task 1: Remove Duplicates**  
   - Implement a function `removeDuplicates` that removes duplicates from a sequence of strings using `foldLeft`.

3. **Task 2: Find Common Elements**  
   - Write a function `findCommonElements` that finds common elements in two different sets.

4. **Task 3: Remove Keys from Map**  
   - Create a function `removeKeys` that removes specified keys from an immutable map.

5. **Task 4: Word Frequency Count**  
   - Write a Scala program that reads a text file and counts the occurrence of each word, storing the results in an immutable map.

## Instructions

To run the Scala file:

1. Ensure you have Scala installed.
2. Navigate to the folder containing the `Exercise04.scala` file.
3. Compile and run the code using:
   ```bash
   scalac Exercise04.scala
   scala Exercise04
