# Exhaustive Search (Traveling Salesman Problem)

## 📋 Summary
* **Core Concept:** A brute-force problem-solving technique that systematically generates and evaluates every possible candidate solution to find the one that satisfies the problem's constraints.
* **Takeaways:**
    > * It guarantees finding the optimal solution if one exists.
    > * It is computationally expensive and generally impractical for large input sizes due to combinatorial explosion.
    > * For the Traveling Salesman Problem (TSP), this involves generating every possible route visiting all cities exactly once and returning to the start.

## 📖 Definition

* **Exhaustive Search (Brute Force):** A strategy that explores the entire state space of a problem. It does not use heuristics or optimization techniques to prune the search space.
* **Traveling Salesman Problem (TSP):** A classic algorithmic problem where a salesman must visit a set of $n$ cities exactly once and return to the starting city, seeking the route with the minimum total distance (or cost).
* **Permutation:** An arrangement of all or part of a set of objects, with regard to the order of the arrangement. In TSP, every valid tour is a permutation of the cities.
* **Requirements:**
    * **Finite State Space:** The number of potential solutions must be finite.
    * **Verifiable Solution:** There must be a way to calculate the cost or validity of a generated solution.

## 📊 Complexity Analysis

| Notation | Name | Growth Rate |
| :--- | :--- | :--- |
| $O(1)$ | Constant | Excellent |
| $O(n^2)$ | Quadratic | Poor |
| $O(2^n)$ | Exponential | Very Poor |
| $O(n!)$ | Factorial | Extremely Poor |

* **Worst-Case ($O(n!)$):** The algorithm must generate all permutations of the cities to ensure the minimum is found. For $n$ cities, there are $(n-1)!$ possible distinct tours (assuming a fixed starting city).
* **Best-Case ($\Omega(n!)$):** Since it is exhaustive, the algorithm does not stop early; it generates all possibilities regardless of the input values.
* **Average-Case ($\Theta(n!)$):** The expected performance is the same as the worst case because all solutions are evaluated.

## ❓ Why we use it

* **Guaranteed Optimality:** Unlike heuristic or greedy approaches (like Nearest Neighbor), exhaustive search is mathematically proven to return the absolute best solution.
* **Baseline for Comparison:** It serves as a "ground truth" to measure the accuracy of more efficient, approximate algorithms.
* **Small Input Sizes:** For problems with very small $n$ (e.g., $n \le 12$), modern computers can solve this almost instantly, making complex optimization unnecessary.
* **Simplicity:** It is conceptually simple to implement and does not require complex data structures.

## ⚙️ How it works (TSP Context)
1.  **Step 1:** Fix a starting city (e.g., City 0).
2.  **Step 2 (Basic Operation):** Generate the next permutation of the remaining $n-1$ cities.
3.  **Step 3:** Calculate the total distance of the current route:
    $$Cost = weight(start, c_1) + weight(c_1, c_2) + ... + weight(c_{n-1}, start)$$
4.  **Step 4:** Compare the calculated cost with the current minimum found. If it is lower, update the minimum.
5.  **Step 5:** Repeat until all $(n-1)!$ permutations are checked.
    

    **Mathematical Model:**
    The time complexity $T(n)$ is proportional to the number of permutations generated multiplied by the time to calculate the path cost ($O(n)$):
    $$T(n) \approx n \times (n-1)! = n!$$

## 💻 Usage / Program Example

```c
#include <stdio.h>
#include <limits.h>

#define V 4  // Number of cities (Vertices)

// Adjacency matrix representing distances between cities
int graph[V][V] = {
    {0, 10, 15, 20},
    {10, 0, 35, 25},
    {15, 35, 0, 30},
    {20, 25, 30, 0}
};

int min_path = INT_MAX;

// Function to swap two integers
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Function to calculate the cost of the current permutation path
void update_min_path(int path[]) {
    int current_path_weight = 0;
    
    // Calculate path weight from start node (0) to first in permutation
    int k = 0; // Starting node is always 0
    for (int i = 0; i < V - 1; i++) { // There are V-1 cities in the permutation array
        current_path_weight += graph[k][path[i]];
        k = path[i];
    }
    // Add distance returning to start node
    current_path_weight += graph[k][0];
    
    // Update minimum if current is better
    if (current_path_weight < min_path) {
        min_path = current_path_weight;
    }
}

// Recursive function to generate permutations of cities
// l: starting index, r: ending index
void permute(int path[], int l, int r) {
    if (l == r) {
        update_min_path(path);
    } else {
        for (int i = l; i <= r; i++) {
            swap((path + l), (path + i)); // Swap
            permute(path, l + 1, r);      // Recurse
            swap((path + l), (path + i)); // Backtrack
        }
    }
}

int main() {
    // Array of cities excluding the starting city (0)
    // Cities are labeled 1, 2, 3
    int cities[] = {1, 2, 3}; 
    int num_cities = sizeof(cities) / sizeof(cities[0]);

    // Generate all permutations and find min path
    // Basic Operation: Permutation generation and Cost Addition
    permute(cities, 0, num_cities - 1);

    printf("Minimum cost of Exhaustive Search TSP: %d\n", min_path);
    
    return 0;
}
```

## References

* [Introduction to the Design and Analysis of Algorithms](https://www.pearson.com/en-us/subject-catalog/p/introduction-to-the-design-and-analysis-of-algorithms/P200000003758) — Anany Levitin, Chapter 3 (Brute Force).
* [Introduction to Algorithms (CLRS)](https://mitpress.mit.edu/9780262046305/introduction-to-algorithms/) — Cormen, Leiserson, Rivest, and Stein, Section on NP-Completeness.