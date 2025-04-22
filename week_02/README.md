# Scala Functions & Recursion - Exercise 2

## Overview

This project contains the solution for **Exercise 2** of the **Functions & Recursion in Functional Programming** course (Spring 2025, Lahti). The focus of this assignment is to understand and implement recursive functions in Scala, simulating iterative behaviors without using loops.

## Contents

The Scala file includes solutions and examples for:

- **Recursive Function Definitions**
- Implementing arithmetic operations using recursion:
  - `addition` – Recursively adds two integers.
  - `subtraction` – Uses `addition` to calculate difference.
  - `multiplication` – Uses `addition` for repeated addition.
  - `division` – Uses `subtraction`, includes division-by-zero handling.
- `factorial` – Calculates factorial of a non-negative integer using recursion.
- `isPrime` – Checks if a number is prime through recursive logic.
- Conceptual questions:
  - **Memory impact** of recursion vs loops
  - **Variable scope**: local vs global, with examples (including closures)

## Instructions

To run the Scala file:

1. Ensure Scala is installed and working.
2. Open terminal in the directory with the `.scala` file.
3. Compile and execute using:
   ```bash
   scalac Assignment2.scala
   scala Assignment2

