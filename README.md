# Competitive Programming Template

This template provides an overview of key algorithms and data structures that are commonly used in competitive programming. It serves as a starting point for coding contests and practice sessions. The goal is to provide a well-structured and easy-to-reference guide that will help you tackle a wide range of problems efficiently.

## About Me

I'm an enthusiastic competitive programmer with a passion for problem-solving and algorithmic thinking. With experience in solving problems across various platforms, I'm always looking to improve efficiency and learn new techniques. My approach is centered around optimizing solutions for time and space complexity, ensuring robustness and correctness in every solution.

I'm actively involved in competitive programming contests and enjoys mentoring other enthusiasts. My key strengths include my problem-solving skills and my focus on implementing efficient algorithms.

## Table of Contents

- [Class Definitions](#class-definitions)
- [Common Algorithms](#common-algorithms)
  - [Modular Exponentiation](#modular-exponentiation)
  - [Greatest Common Divisor (GCD)](#greatest-common-divisor-gcd)
  - [Least Common Multiple (LCM)](#least-common-multiple-lcm)
  - [Extended GCD](#extended-gcd)
- [Mathematical Utilities](#mathematical-utilities)
  - [Sieve of Eratosthenes](#sieve-of-eratosthenes)
- [Data Structures](#data-structures)
  - [Binary Lifting](#binary-lifting)
  - [Union-Find](#union-find)
  - [Binary Indexed Tree](#binary-indexed-tree)
- [Input and Output Helpers](#input-and-output-helpers)
- [Main Function](#main-function)

## Class Definitions

### Pair Class

A class for storing pairs of elements. It is often used to represent two related values together, such as coordinates, key-value pairs, or any two entities that need to be handled together. It provides a simple structure for managing and manipulating pairs efficiently.

### Tuple Class

A class for storing triplets of values. This is useful for problems that require handling three related values at once, such as (x, y, z) coordinates or any combination of three entities.

## Common Algorithms

### Modular Exponentiation

Modular exponentiation is used to efficiently calculate large powers under a modulus. This technique is essential for problems where numbers grow exponentially, and you need to reduce the size of the numbers while retaining the correct value. It uses the fast exponentiation technique, which reduces the complexity to logarithmic time.

### Greatest Common Divisor (GCD)

The GCD of two numbers is the largest integer that divides both of them without leaving a remainder. It can be computed efficiently using the Euclidean algorithm. This algorithm is commonly used in problems involving fractions, number theory, or finding common divisors between multiple numbers.

### Least Common Multiple (LCM)

The LCM of two numbers is the smallest number that is divisible by both. The LCM can be derived from the GCD of the numbers. It is used in problems where you need to align cycles or find common multiples of values.

### Extended GCD

Extended GCD computes not only the GCD of two numbers but also the coefficients of the equation `ax + by = gcd(a, b)`. This is useful in solving Diophantine equations and applications such as modular inverses.

## Mathematical Utilities

### Sieve of Eratosthenes

The Sieve of Eratosthenes is an efficient algorithm to generate all prime numbers up to a given limit. It works by iteratively marking the multiples of each prime starting from 2. This algorithm is widely used in problems involving prime numbers or factorization.

## Data Structures

### Binary Lifting

Binary Lifting is a technique used to solve problems related to Lowest Common Ancestor (LCA) in trees. It allows querying the ancestor of a node at a specific distance in logarithmic time. This technique is widely used in tree-based problems such as finding the LCA or path queries.

### Union-Find

The Union-Find (or Disjoint Set Union, DSU) data structure is used to efficiently perform union and find operations on a set of elements. It is widely used in problems related to connected components, graph connectivity, and dynamic connectivity.

### Binary Indexed Tree (BIT)

The Binary Indexed Tree (BIT) is a data structure that allows efficient updates and prefix sum queries. It is often used in problems involving range queries and updates, such as finding the sum of elements in a range or updating the value of an element.

## Input and Output Helpers

Efficient input and output handling is crucial in competitive programming, especially when dealing with large inputs and outputs. Fast input and output functions reduce the overhead and improve the runtime of the program. These helpers handle reading and writing data quickly, ensuring that the program runs within time limits.

## Main Function

The main function serves as the entry point for a competitive programming problem. It reads the input, processes the data, and outputs the result. In some cases, it may need to handle multiple test cases, manage large inputs, or implement specific algorithms. The main function is designed to be modular and efficient.

---

This template serves as a quick reference for common algorithms, data structures, and techniques that are often needed in competitive programming. It is designed to help you quickly implement solutions during coding contests and practice sessions. Feel free to customize the template and add more features as you learn new concepts. Happy coding! 😊
