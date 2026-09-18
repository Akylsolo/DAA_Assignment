# Design and Analysis of Algorithms - Assignment 1

## Student Information
- **Name:** Akyl Muratbek
- **Group:** SE 2523
- **Course:** Design and Analysis of Algorithms
- [🔗 Посмотреть проект на GitHub](https://github.com/Akylsolo/DAA_Assignment.git)

## Project Overview
This academic project focuses on the comprehensive implementation, automated benchmarking, unit testing, and asymptotic performance analysis of four fundamental algorithms in computer science:
1. **Insertion Sort** — A simple comparison-based sorting algorithm efficient for small datasets.
2. **Merge Sort** — An efficient, stable, divide-and-conquer sorting algorithm with a guaranteed O(n log n) time complexity.
3. **Quick Sort** — A fast, in-place sorting algorithm utilizing partitioning and recursion, optimized with a 3-way partition approach.
4. **Quick Select** — A selection algorithm to find the k-th smallest element in an unordered list in linear average-case time.

The project evaluates execution time (in milliseconds), operation comparisons, and maximum recursion depth across various input data distributions (randomized arrays, pre-sorted arrays, and arrays with a high density of duplicate elements) for input sizes ranging from n = 1,000 up to n = 1,000,000.

---

## System Requirements
- **Java Development Kit (JDK):** Version 17 or newer.
- **Build Automation Tool:** Apache Maven.
- **IDE:** IntelliJ IDEA (Recommended) or any standard Java environment.

---
### Detailed Pros and Cons of Implemented Algorithms

#### 1. Insertion Sort
* **Pros:**
    * Extremely fast and efficient on small datasets or nearly sorted input arrays.
    * Low memory overhead (operates entirely in-place) and straightforward implementation logic.
* **Cons:**
    * Poor performance on large datasets due to quadratic time complexity ($O(n^2)$).
    * Highly inefficient when handling reverse-sorted or completely random large inputs.

#### 2. Merge Sort
* **Pros:**
    * Guaranteed worst-case time complexity of $O(n \log n)$ across all input distributions.
    * Highly stable sorting algorithm that performs consistently and predictably.
* **Cons:**
    * Requires additional auxiliary memory space proportional to the array size for merging operations, which can be restrictive under strict memory constraints.

#### 3. Quick Sort
* **Pros:**
    * Excellent average-case performance with $O(n \log n)$ time complexity and great cache locality.
    * Typically faster in practice than other $O(n \log n)$ sorts due to in-place partitioning.
* **Cons:**
    * Worst-case time complexity degrades to $O(n^2)$ if pivot selection results in extremely unbalanced partitions.
    * Unstable sorting mechanism by default.

#### 4. Quick Select
* **Pros:**
    * Highly efficient for finding the k-th smallest element with an average-case linear time complexity of $O(n)$.
    * Operates in-place, modifying the working array directly without needing full sorting.
* **Cons:**
    * Performance can degrade to $O(n^2)$ in the worst-case scenario depending on partition outcomes, and it alters the initial order of array elements.