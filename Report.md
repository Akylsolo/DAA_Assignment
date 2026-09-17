# Design and Analysis of Algorithms - Assignment 1 Report
**Student:** Akyl Muratbek | **Group:** SE 2523

## 1. Asymptotic Bounds

| Algorithm | Best Case | Average Case | Worst Case | Reason |
| :--- | :--- | :--- | :--- | :--- |
| **Insertion Sort** | Omega(n) | Theta(n^2) | O(n^2) | Best case: sorted array. Worst: reversed array. |
| **MergeSort** | Omega(n log n) | Theta(n log n) | O(n log n) | Array is strictly halved at each step. |
| **QuickSort** | Omega(n log n) | Theta(n log n) | O(n^2) | Best/Avg: balanced partitions. Worst: bad pivot splits. |
| **QuickSelect** | Omega(n) | Theta(n) | O(n^2) | Best/Avg: geometric reduction. Worst: linear shrink. |

## 2. Recurrences & Master Theorem

### MergeSort
- Recurrence: T(n) = 2T(n/2) + O(n)
- Parameters: a = 2, b = 2, f(n) = O(n)
- Master Theorem: Case 2 (f(n) = Theta(n))
- Result: Theta(n log n)

### QuickSort (Balanced Split)
- Recurrence: T(n) = 2T(n/2) + O(n)
- Parameters: a = 2, b = 2, f(n) = O(n)
- Explanation: Random pivot ensures balanced partitions on average.
- Result: Theta(n log n)

### QuickSelect (Balanced Split)
- Recurrence: T(n) = T(n/2) + O(n)
- Parameters: a = 1, b = 2, f(n) = O(n)
- Master Theorem: Case 3
- Result: Theta(n)

## 3. Performance Plots

### Execution Time vs Array Size
![Time vs n](time_vs_n.png)

### Max Recursion Depth vs Array Size
![Depth vs n](depth_vs_n.png)

### Asymptotic Ratio Check
![Ratio vs n](ratio_vs_n.png)

## 4. Discussion
The empirical measurements align closely with the theoretical bounds. In the ratio plots, the values for MergeSort and QuickSelect stabilize into horizontal asymptotes. Minor runtime variations at smaller sizes are attributed to JVM JIT compilation warm-up and CPU cache effects. The 3-way partition successfully neutralized performance degradation on duplicate-heavy inputs for QuickSort.