# Closest Pair Problem (Brute Force)

## 📋 Summary
* **Core Concept:** The Closest Pair problem involves identifying two points in a given set of $n$ points that have the smallest Euclidean distance between them.
> **Takeaways:** The brute-force approach is straightforward to implement but inefficient for large datasets. It serves as a baseline for measuring the performance of more advanced divide-and-conquer algorithms.

## 📖 Definition
* **Closest Pair:** Given a set of points $P = \{p_1, p_2, ..., p_n\}$, find $p_i, p_j \in P$ such that the distance $d(p_i, p_j)$ is minimal among all possible pairs.
* **Euclidean Distance:** The straight-line distance between two points in Euclidean space, derived from the Pythagorean theorem.



## 📊 Complexity Analysis

| Notation | Name | Growth Rate |
| :--- | :--- | :--- |
| $O(n^2)$ | Quadratic | Poor |
| $O(1)$ | Constant | Excellent |

* **Worst-Case ($O$):** $O(n^2)$ because the algorithm must compare every point with every other point.
* **Best-Case ($\Omega$):** $\Omega(n^2)$ as the nested loops execute regardless of point distribution in the brute-force version.
* **Average-Case ($\Theta$):** $\Theta(n^2)$ because the number of comparisons $(n(n-1)/2)$ is constant for a fixed $n$.

## ❓ Why we use it
* **Collision Detection:** Essential in air traffic control and robotics to prevent physical contact between entities.
* **Cluster Analysis:** Used in data mining to find the most similar data points within a multidimensional dataset.
* **Statistical Testing:** Identifying outliers or tight groupings in spatial data.

## ⚙️ How it works
1. **Step 1:** Initialize a variable `min_dist` to infinity.
2. **Step 2:** Iterate through each point $i$ from $0$ to $n-2$.
3. **Step 3:** For each point $i$, iterate through every subsequent point $j$ from $i+1$ to $n-1$.
4. **Step 4:** Set up the mathematical model for distance:
   $$d = \sqrt{(x_j - x_i)^2 + (y_j - y_i)^2}$$
5. **Step 5:** If $d < min\_dist$, update `min_dist`.

## 💻 Usage / Program Example
```c
#include <stdio.h>
#include <float.h>
#include <math.h>

struct Point { 
    int x, y; 
};

// Basic Operation: Euclidean Distance Calculation
float calculateDistance(struct Point p1, struct Point p2) {
    return sqrt(pow(p1.x - p2.x, 2) + pow(p1.y - p2.y, 2));
}

void findClosestPair(struct Point p[], int n) {
    float min_dist = FLT_MAX;
    
    // Total Comparisons C(n) = (n * (n - 1)) / 2
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            float d = calculateDistance(p[i], p[j]);
            if (d < min_dist) {
                min_dist = d;
            }
        }
    }
    printf("Minimum Distance: %f\n", min_dist);
}
```

## References
* [Introduction to the Design and Analysis of Algorithms] — Anany Levitin, Chapter 3.
* [Algorithm Design] — Jon Kleinberg and Éva Tardos.